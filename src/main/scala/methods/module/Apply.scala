package avocet
package methods
package module

import tags._
import cls._
import scala.reflect.internal.pickling._

case class Apply(myPickleBuffer: PickleBuffer, valueMembers: List[ValueMember], init: Init) {
  val valSymPosition = Position.current

  ValSym(Position.current + 1, ClassSym_Module.position, 2097728L, Position.current + 2).write(myPickleBuffer)
  TermName("apply").write(myPickleBuffer)
  val valueMembersAsParamsPositions = (Position.current + 1 to Position.current + valueMembers.length).toList
  MethodTpe(init.typeRefTpePosition :: valueMembersAsParamsPositions).write(myPickleBuffer)
  valueMembers.foreach(vm => ValSym(vm.termNamePosition, this.valSymPosition, 8192L, vm.typeRefPosition).write(myPickleBuffer))
  
}
