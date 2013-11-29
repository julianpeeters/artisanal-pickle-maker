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

 class ValueMember(myPickleBuffer: PickleBuffer, termName: String, typeName: String, typeRefTpes: TypeRefTpes){
  val tpeName = typeName
  var polyTpePosition = 0
  var typeRefPosition = 0
  var termNamePosition = 0

  def writeTpe[X <: Tpe](typeRef:X) = {//if type is previous value member's, ref previous member's polytype
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
      case 6      => {//AnyRef gets special treatement, since it's the only type defined before all other value member types
        typeRefTpes.anyRef.polyTpePosition match {
          case 0      => {//if there is no polyTpe, write one after ther termname
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
        polyTpePosition = typeRef.position - 1
        typeRefPosition = typeRef.position
        ValSym(Position.current + 1, ClassSym.position, 692060672L, polyTpePosition).write(myPickleBuffer)
        termNamePosition = Position.current
        TermName(termName).write(myPickleBuffer)
      }
    }
  }

  typeName match {
    case "Byte" => writeTpe(typeRefTpes.byte) 
    case "Short" => writeTpe(typeRefTpes.short) 
    case "Int" => writeTpe(typeRefTpes.int) 
    case "Long" => writeTpe(typeRefTpes.long) 
    case "Float" => writeTpe(typeRefTpes.float) 
    case "Double" => writeTpe(typeRefTpes.double)
    case "Char"     => writeTpe(typeRefTpes.char)
    case "String"   => writeTpe(typeRefTpes.string) 
    case "Boolean"  => writeTpe(typeRefTpes.boolean) 
    case "Unit"     => writeTpe(typeRefTpes.unit) 
    case "Null"     => writeTpe(typeRefTpes.nul) 
    case "Nothing"  => writeTpe(typeRefTpes.nothing) 
    case "Any"      => writeTpe(typeRefTpes.any) 
    case "AnyRef"   => writeTpe(typeRefTpes.anyRef)
    case "Object"   => writeTpe(typeRefTpes.obj) 
    //generics
    case "Option"   => writeTpe(typeRefTpes.option) 
    case "Iterator" => writeTpe(typeRefTpes.iterator) 
   // case "List"   => writeTpe(TypeRefTpe_List) 
   // case "Stream" => writeTpe(TypeRefTpe_Stream) 
    //user-defined
    case x: String  => {println("value members found a user defined type " + x);writeTpe(typeRefTpes.userDefined(x))}
    case _          => error("unsupported type")
  }

  ValSym(Position.current + 1, ClassSym.position, 554172420L, typeRefPosition).write(myPickleBuffer)
  TermName(termName + " ").write(myPickleBuffer)
}
