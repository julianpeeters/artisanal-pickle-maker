package avocet
package methods
package module

import tags._
import types._
import cls._
import scala.reflect.internal.pickling._

case class Unapply(myPickleBuffer: PickleBuffer, valueMembers: List[ValueMember], init: Init, thisTpe_scala: ThisTpe_scala, Option: TypeRefTpe_Option, scala: ExtModClassRef_scala) {
  val valSymPosition = Position.current
  val valueMemberTypeRefPositions = valueMembers.map(vm => vm.typeRefPosition)

  ValSym(Position.current + 1, ClassSym_Module.position, 2097728L, Position.current + 2).write(myPickleBuffer)
  TermName("unapply").write(myPickleBuffer)
  
  valueMembers.length match {
    case 1          => {  // if there is only 1 value member, have the option typereftpe ref the value member
      Option.position match {
        case 0      => {
          MethodTpe(List(Position.current + 1, Position.current + 4)).write(myPickleBuffer)
          TypeRefTpe_unapplyOption(thisTpe_scala.position, Position.current + 1, valueMembers(0).typeRefPosition).writeEntry(myPickleBuffer)
          ExtRef_nested(Position.current + 1, scala.position).write(myPickleBuffer)
          TypeName("Option").write(myPickleBuffer)

        }
        case i: Int => {
          MethodTpe(List(Position.current + 1, Position.current + 2)).write(myPickleBuffer)  
          TypeRefTpe_unapplyOption(thisTpe_scala.position, Option.position + 1, valueMembers(0).typeRefPosition).writeEntry(myPickleBuffer)
        }
      }
    }
    case x if x > 1 =>{ // if there is more than 1 value member, have the option's typereftpe ref TupleRef
      Option.position match {
        case 0      => {
          MethodTpe(List(Position.current + 1, Position.current + 4)).write(myPickleBuffer)
          TypeRefTpe_unapplyOption(thisTpe_scala.position, Position.current + 1,  Position.current + 3).writeEntry(myPickleBuffer)
          ExtRef_nested(Position.current + 1, scala.position).write(myPickleBuffer)
          TypeName("Option").write(myPickleBuffer)
          TypeRefTpe_Tuple(valueMembers, thisTpe_scala, scala).write(myPickleBuffer)
        }
        case i: Int => {
          MethodTpe(List(Position.current + 1, Position.current + 2)).write(myPickleBuffer)  
          TypeRefTpe_unapplyOption(thisTpe_scala.position, Option.position + 1, Position.current + 1).writeEntry(myPickleBuffer)
        }
      }
    }
    case _          => println("Hmm. what's wrong with your value members? Do you have any?") 
  }


  ValSym(Position.current + 1, valSymPosition, 2105344L, init.typeRefTpePosition).write(myPickleBuffer)
  TermName("x$0").write(myPickleBuffer)

}
