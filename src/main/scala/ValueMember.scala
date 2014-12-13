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
package artisanal.pickle.maker
import tags._
import types._
import scala.reflect.internal.pickling._



class ValueMember(position: Position, classSym: ClassSym, myPickleBuffer: PickleBuffer, names: List[String], termName: String, typeName: String, typeRefTpes: TypeRefTpes){
  val tpeName = typeName
  var polyTpePosition = 0
  var typeRefPosition = 0
  var termNamePosition = 0

  writeType(typeName)
  ValSym(position, position.current + 1, classSym.position, 554172420L, typeRefPosition).write(myPickleBuffer)
  TermName(position, termName + " ").write(myPickleBuffer)

  def getBoxed(typeName: String) = {
    typeName.dropWhile( c => (c != '[') ).drop(1).dropRight(1)
  }

  def writeType(typeName: String) = { 
    if (typeName.endsWith("]")) {
      val boxedTypeName = getBoxed(typeName)
      writeGenericTpe(matchTypes(typeName), matchTypes(boxedTypeName))//pass the matched entire type and the boxed
    }
    else writeNonGenericTpe(matchTypes(typeName))
  }

  def matchTypes(tpeName: String):  Tpe = { 
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

      //collections, generics, and user-defined types
      case i: String => {
        val tpe = TypeStore.types.get(tpeName)

        if (tpe.isDefined)  tpe.get
        else {  
          i match {
            case x if x.startsWith("List[")   => typeRefTpes.list(typeName, matchTypes(getBoxed(x)))
            case x if x.startsWith("Option[") => typeRefTpes.option(matchTypes(getBoxed(x)))
            case x           /*User Defined*/ => typeRefTpes.userDefined(x, names(0))
          }
        }
      }
      case _ => error("Not a String: types must be defined with strings")
    }
  }

  //For types without type parameters
  def writeNonGenericTpe[X <: Tpe](typeRef:X) = {//if type is previous value member's, ref previous member's polytype
    typeRef.position match { //polytpe position is determined by TypeRef position (all types but AnyRef follow a polytpe)
      case 0      => { //if it doesn't exist, write it next
        polyTpePosition = position.current + 2
        ValSym(position, position.current + 1, classSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
        termNamePosition = position.current
        TermName(position, termName).write(myPickleBuffer)
        PolyTpe(position, typeRef).write(myPickleBuffer)
        typeRefPosition = position.current
        typeRef.write(myPickleBuffer)
      }
      case 6      => {//AnyRef at pos 6 gets special treatment: it's the only type defined before all other value member types
        typeRefTpes.anyRef.polyTpePosition match {
          case 0      => {//if there is no polyTpe, write one after the termName
            polyTpePosition = position.current + 2
            typeRefPosition = typeRef.position 
            ValSym(position, position.current + 1, classSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
            termNamePosition = position.current
            TermName(position, termName).write(myPickleBuffer)
            PolyTpe(position, typeRef).write(myPickleBuffer)
          }
          case i: Int => {
            polyTpePosition = i
            typeRefPosition = typeRef.position 
            ValSym(position, position.current + 1, classSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
            termNamePosition = position.current
            TermName(position, termName).write(myPickleBuffer)
          }
        }  

      }
      case i: Int => {//if we've written a given typeRef, but the polytpe position is still zero, then write the polytpe here
        if (typeRef.polyTpePosition == 0) {
          polyTpePosition = position.current + 2
          typeRefPosition = typeRef.position
          ValSym(position, position.current + 1, classSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
          termNamePosition = position.current
          TermName(position, termName).write(myPickleBuffer)
          PolyTpe(position, typeRef).write(myPickleBuffer)
        }
        else {
          polyTpePosition = typeRef.position - 1
          typeRefPosition = typeRef.position
          ValSym(position, position.current + 1, classSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
          termNamePosition = position.current
          TermName(position, termName).write(myPickleBuffer) 
        }
      }
    }
  }

  //For types that take type parameters
  def writeGenericTpe[X<: Tpe, Y <: Tpe](typeRef:X, boxedTypeRef: Y) = {
    typeRef.position match { //polytpe position is determined by TypeRef position (all types but AnyRef follow a polytpe)
      case 0      => { //if it doesn't exist, write it next
        polyTpePosition = position.current + 2
        ValSym(position, position.current + 1, classSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
        termNamePosition = position.current
        TermName(position, termName).write(myPickleBuffer)
        PolyTpe(position, typeRef).write(myPickleBuffer)
        typeRefPosition = position.current
        typeRef.position = position.current

        typeRef.write(myPickleBuffer)
      }
      case i: Int => { //if the type has been previously 
        polyTpePosition = typeRef.position - 1
        typeRefPosition = typeRef.position

        if (TypeStore.types.get(boxedTypeRef.typeName).isDefined ) { 
          if (ValueMemberStore.valueMembers.get(typeRef.typeName).isDefined ) { 
            ValSym(position, position.current + 1, classSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
            termNamePosition = position.current
            TermName(position, termName).write(myPickleBuffer)
          }
          else {
            ValSym(position, position.current + 1, classSym.position, 692060672L, position.current + 2).write(myPickleBuffer)
            termNamePosition = position.current
            TermName(position, termName).write(myPickleBuffer)
            PolyTpe(position, typeRef).write(myPickleBuffer)
          }
        }
        else {
          ValSym(position, position.current + 1, classSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
          termNamePosition = position.current
          TermName(position, termName).write(myPickleBuffer)
        }
      }
    }
  }

  //keeping a list of value members so I can discern between nested types and top level value members
  ValueMemberStore.accept(this)

}
