/*
 * Copyright 2013 Julian Peeters
 *   
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package artisinal.pickle.maker
import tags._
import types._
import scala.reflect.internal.pickling._
import scala.collection.JavaConversions.JConcurrentMapWrapper
import java.util.concurrent.ConcurrentHashMap


 class ValueMember(myPickleBuffer: PickleBuffer, termName: String, typeName: String, typeRefTpes: TypeRefTpes){
  val tpeName = typeName
  var polyTpePosition = 0
  var typeRefPosition = 0
  var termNamePosition = 0

  writeType(typeName)
  ValSym(Position.current + 1, ClassSym.position, 554172420L, typeRefPosition).write(myPickleBuffer)
  TermName(termName + " ").write(myPickleBuffer)


  def getBoxed(typeName: String) = {
    typeName.dropWhile( c => (c != '[') ).drop(1).dropRight(1)
  }

  def writeType(typeName: String) = { 
    if (typeName.endsWith("]")) {
      val typeNames = typeName.dropRight(1).split('[')
      writeGenericTpe(matchTypes(typeName), matchTypes(typeNames(1)))
    }
    else writeNonGenericTpe(matchTypes(typeName))
  }


  def matchTypes(tpeName: String):  Tpe = { println("matching " + tpeName)
      tpeName match {
    //basic data types
    case "Byte"     => typeRefTpes.byte
    case "Short"    => typeRefTpes.short
    case "Int"      => typeRefTpes.int
    case "Long"     => typeRefTpes.long
    case "Float"    => typeRefTpes.float
    case "Double"   => typeRefTpes.double
    case "Char"     => typeRefTpes.char
    case "String"   => typeRefTpes.string
    case "Boolean"  => typeRefTpes.boolean
    case "Unit"     => typeRefTpes.unit
    case "Null"     => typeRefTpes.nul
    case "Nothing"  => typeRefTpes.nothing 
    case "Any"      => typeRefTpes.any 
    case "AnyRef"   => typeRefTpes.anyRef
    case "Object"   => typeRefTpes.obj 
    //generics
    case "Option"   => typeRefTpes.option
    case "Iterator" => typeRefTpes.iterator


    case x: String if x.startsWith("List[")     => { 
      val g = TypeStore.types.get(x)
      if (g.isDefined) { println("WAS DEFINED " + TypeStore.types)
        g.get
      }
      else { //println("ELSE "  + typeRefTpes.protoList.position )
   //      typeRefTpes.protoList.write(myPickleBuffer)
//println("ELSE "  + typeRefTpes.protoList.position )
         typeRefTpes.list(matchTypes(getBoxed(x)))
      }
    }

   // case "List[String]" => {println("VM found a list STring"); typeRefTpes.list}
   // case "Stream" => writeTpe(TypeRefTpe_Stream) 
    //user-defined
  //  case "rec"      => {println("what could have gone wrong? "); writeTpe(typeRefTpes.string)}//TODO not right! just for debug this line
   // case x: String  => {println("USER DEFINED ");typeRefTpes.userDefined(x)}
    case x: String    => { println("USER DEFINED " ); println(TypeStore.types)
      val g = TypeStore.types.get(x)
      if (g.isDefined) { println("was defined  ")
        g.get
      }
      else {println("FRESH")
         typeRefTpes.userDefined(x)
      }
    }
    case _          => error("unsupported type")
    }
  }

  //For types without type parameters
  def writeNonGenericTpe[X <: Tpe](typeRef:X) = {//if type is previous value member's, ref previous member's polytype
    typeRef.position match { //polytpe position is determined by TypeRef position (all types but AnyRef follow a polytpe)
      case 0      => { //if it doesn't exist, write it next
        polyTpePosition = Position.current + 2
        ValSym(Position.current + 1, ClassSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
        termNamePosition = Position.current
        TermName(termName).write(myPickleBuffer)
        PolyTpe(typeRef).write(myPickleBuffer)
        typeRefPosition = Position.current
        typeRef.write(myPickleBuffer)
      }
      case 6      => {//AnyRef at pos 6 gets special treatment: it's the only type defined before all other value member types
        typeRefTpes.anyRef.polyTpePosition match {
          case 0      => {//if there is no polyTpe, write one after the termName
            polyTpePosition = Position.current + 2
            typeRefPosition = typeRef.position 
            ValSym(Position.current + 1, ClassSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
            termNamePosition = Position.current
            TermName(termName).write(myPickleBuffer)
            PolyTpe(typeRef).write(myPickleBuffer)
          }
          case i: Int => {
            polyTpePosition = i
            typeRefPosition = typeRef.position 
            ValSym(Position.current + 1, ClassSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
            termNamePosition = Position.current
            TermName(termName).write(myPickleBuffer)
          }
        }  

      }
      case i: Int => {//if the type has been previously 
      //if we've written a given typeRef, but the polytpe position is still zero, then write the polytpe here
        if (typeRef.polyTpePosition == 0) {
          polyTpePosition = Position.current + 2
          typeRefPosition = typeRef.position
          ValSym(Position.current + 1, ClassSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
          termNamePosition = Position.current
          TermName(termName).write(myPickleBuffer)
          PolyTpe(typeRef).write(myPickleBuffer)
        }
        else {
          polyTpePosition = typeRef.position - 1
          typeRefPosition = typeRef.position
          ValSym(Position.current + 1, ClassSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
          termNamePosition = Position.current
          TermName(termName).write(myPickleBuffer) 
        }
      }
    }
  }

  //For types that take type parameters
  def writeGenericTpe[X<: Tpe, Y <: Tpe](typeRef:X, boxedTypeRef: Y) = {//if type is previous value member's, ref previous member's polytype  

    typeRef.position match { //polytpe position is determined by TypeRef position (all types but AnyRef follow a polytpe)
      case 0      => { //if it doesn't exist, write it next

        if (typeRef.position == 0) { 
          polyTpePosition = Position.current + 2
          ValSym(Position.current + 1, ClassSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
          termNamePosition = Position.current
          TermName(termName).write(myPickleBuffer)
          PolyTpe(typeRef).write(myPickleBuffer)
          typeRefPosition = Position.current
          typeRef.position = Position.current

          typeRef.write(myPickleBuffer)
        }

        if (boxedTypeRef.position == 0) boxedTypeRef.write(myPickleBuffer)
      }
      case i: Int => {//if the type has been previously 
        polyTpePosition = typeRef.position - 1
        typeRefPosition = typeRef.position
        ValSym(Position.current + 1, ClassSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
        termNamePosition = Position.current
        TermName(termName).write(myPickleBuffer)
      }
    }
  }



}
