package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.internal.pickling._

case class CopyDefault(sigResources: SigResources, valueMembers: List[ValueMember]) {

  val valSymPosition = Position.current

  valueMembers.length match {
    case 1 => { //if there is only one value member, then:
      ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
      TermName("copy$default$1").write(sigResources.myPickleBuffer)
      PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
      Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
      sigResources.typeRefTpes.uncheckedVariance.write(sigResources.myPickleBuffer)
    }
    case x if x > 1 => { //if there's more than one value member, then:
      var valueMemberNumber = 0
      valueMembers.foreach(vm => {
        valueMemberNumber += 1
        vm.tpeName match {
//TODO replace all these cases by using a parameterized method?
          case "Byte" => {
            sigResources.typeRefTpes.byte.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.byte.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.byte.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Short" => {
            sigResources.typeRefTpes.short.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.short.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.short.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Int" => {
            sigResources.typeRefTpes.int.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.int.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.int.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Long" => {
            sigResources.typeRefTpes.long.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.long.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.long.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Float" => {
            sigResources.typeRefTpes.float.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.float.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.float.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Double" => {
            sigResources.typeRefTpes.double.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.double.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.double.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Char" => {
            sigResources.typeRefTpes.char.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.char.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.char.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "String" => {
            sigResources.typeRefTpes.string.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.string.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.string.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Boolean" => {
            sigResources.typeRefTpes.boolean.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.boolean.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.boolean.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Unit" => {
            sigResources.typeRefTpes.unit.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.unit.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.unit.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Null" => {
            sigResources.typeRefTpes.nul.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.nul.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.nul.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Nothing" => {
            sigResources.typeRefTpes.nothing.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.nothing.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.nothing.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Any" => {
            sigResources.typeRefTpes.any.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.any.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.any.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "AnyRef" => {
            sigResources.typeRefTpes.anyRef.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.anyRef.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.anyRef.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }
          case "Object" => {
            sigResources.typeRefTpes.obj.annotPos match {
              case 0      => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
                sigResources.typeRefTpes.obj.annotPos = Position.current
                PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
                Annotation(vm, sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
              }
              case i: Int => {
                ValSym(Position.current + 1, ClassSym.position, 35652096L,  sigResources.typeRefTpes.obj.annotPos).write(sigResources.myPickleBuffer)
                TermName("copy$default$" + valueMemberNumber).write(sigResources.myPickleBuffer)
              }
            }
          }

        }  
        if(sigResources.typeRefTpes.uncheckedVariance.position == 0 ) sigResources.typeRefTpes.uncheckedVariance.write(sigResources.myPickleBuffer)
      })
    }
    case _ => println("what, no value members?")
  }


}