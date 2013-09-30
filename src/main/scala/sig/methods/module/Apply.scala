package avocet
package methods
package module

import tags._
import cls._
import scala.reflect.generic._

case class Apply(sigResources: SigResources, valueMembers: List[ValueMember], init: Init) {
  val valSymPosition = Position.current

  ValSym(Position.current + 1, ClassSym_Module.position, 2097728L, Position.current + 2).write(sigResources.myPickleBuffer)
  TermName("apply").write(sigResources.myPickleBuffer)
  val valueMembersAsParamsPositions = (Position.current + 1 to Position.current + valueMembers.length).toList
  MethodTpe(init.typeRefTpePosition :: valueMembersAsParamsPositions).write(sigResources.myPickleBuffer)
  valueMembers.foreach(vm => ValSym(vm.termNamePosition, this.valSymPosition, 8192L, vm.typeRefPosition).write(sigResources.myPickleBuffer))
  
}
