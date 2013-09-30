package avocet
package methods
package module

import tags._
import cls._
import scala.reflect.generic._

case class ToString_Module(sigResources: SigResources, valueMembers: List[ValueMember], toStringMethod: ToString) {
  val position = Position.current
  ValSym(toStringMethod.termNamePosition, ClassSym_Module.position, 2097698L, toStringMethod.MethodTpePosition).write(sigResources.myPickleBuffer)

   
}
