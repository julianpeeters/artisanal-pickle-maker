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
package methods
package cls

import tags._
import types._
import scala.reflect.internal.pickling._

case class CopyDefault(position: Position, classSym: ClassSym, sigResources: SigResources, valueMembers: List[ValueMember]) {

  var valueMemberNumber = 0
  val valSymPosition = position.current

  valueMembers.length match {
    case 1 => { //if there is only one value member, then:
      ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
      TermName(position, "copy$default$1").write(sigResources.myPickleBuffer)
      //takes valueMembers in order for Annotation to pass the value member's position
      PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
      Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
      sigResources.typeRefTpes.uncheckedVariance.write(sigResources.myPickleBuffer)
    }
    case x if x > 1 => { //if there's more than one value member, then:


      valueMembers.foreach(vm => { 
        valueMemberNumber += 1
        writeType(vm)

        if(sigResources.typeRefTpes.uncheckedVariance.position == 0 ) sigResources.typeRefTpes.uncheckedVariance.write(sigResources.myPickleBuffer)
      })

    }
    case _ => error("what, no value members?")
  }

  
        def writeType(vm: ValueMember) {
        vm.tpeName match {
//TODO replace all these cases by using a parameterized method?
          case "Byte" => {
            sigResources.typeRefTpes.byte.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.byte.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.byte.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Short" => {
            sigResources.typeRefTpes.short.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.short.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.short.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Int" => {
            sigResources.typeRefTpes.int.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.int.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.int.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Long" => {
            sigResources.typeRefTpes.long.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.long.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.long.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Float" => {
            sigResources.typeRefTpes.float.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.float.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.float.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Double" => {
            sigResources.typeRefTpes.double.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.double.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.double.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Char" => {
            sigResources.typeRefTpes.char.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.char.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.char.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "String" => {
            sigResources.typeRefTpes.string.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.string.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.string.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Boolean" => {
            sigResources.typeRefTpes.boolean.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.boolean.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.boolean.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Unit" => {
            sigResources.typeRefTpes.unit.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.unit.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.unit.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Null" => {
            sigResources.typeRefTpes.nul.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.nul.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.nul.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Nothing" => {
            sigResources.typeRefTpes.nothing.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.nothing.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.nothing.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Any" => {
            sigResources.typeRefTpes.any.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.any.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.any.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "AnyRef" => {
            sigResources.typeRefTpes.anyRef.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.anyRef.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.anyRef.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Object" => {
            sigResources.typeRefTpes.obj.annotPos match {
              case 0      => {
                ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.obj.annotPos = position.current
                PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(position, position.current + 1, classSym.position, 35652096L,  sigResources.typeRefTpes.obj.annotPos).write(sigResources.myPickleBuffer)
                TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case listType: String if listType.startsWith("List[") => {   
            val g = TypeStore.types.get(listType)
            if (g.isDefined) {
              val listTypeRef = g.get
              listTypeRef.annotPos match {
                case 0      => { 
                  ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                  TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                  listTypeRef.annotPos = position.current
                  PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                  Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
                }
                case i: Int => { 
                  ValSym(position, position.current + 1, classSym.position, 35652096L, listTypeRef.annotPos).write(sigResources.myPickleBuffer)
                  TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                }
              } 
            }
          }
          case x: String  => {   //user-defined types
            val g = TypeStore.types.get(x)
            if (g.isDefined) {
              val listTypeRef = g.get
              listTypeRef.annotPos match {
                case 0      => { 
                  ValSym(position, position.current + 1, classSym.position, 35652096L, position.current + 2).write(sigResources.myPickleBuffer)
                  TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                  listTypeRef.annotPos = position.current
                  PolyTpe(position, Annotation(position, valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                  Annotation(position, vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
                }
                case i: Int => {
                  ValSym(position, position.current + 1, classSym.position, 35652096L, listTypeRef.annotPos).write(sigResources.myPickleBuffer)
                  TermName(position, "copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                }
              } 
            }
          }



      } 
    }

}
