package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.internal.pickling._

case class Copy(sigResources: SigResources, valueMembers: List[ValueMember]) {

  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write(sigResources.myPickleBuffer)
  TermName("copy").write(sigResources.myPickleBuffer)


  MethodTpe(List(sigResources.typeRefTpes.modelsMyRecord.position)++(Position.current + 1 until Position.current + 1 + valueMembers.length)).write(sigResources.myPickleBuffer)
  valueMembers.foreach(m => ValSym(m.termNamePosition, valSymPosition, 33562624L, m.typeRefPosition).write(sigResources.myPickleBuffer))
}
