package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.internal.pickling._

case class Copy(myPickleBuffer: PickleBuffer, valueMembers: List[ValueMember], modelsMyRecord: TypeRefTpe_modelsMyRecord) {
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write(myPickleBuffer)
  TermName("copy").write(myPickleBuffer)
  MethodTpe(List(modelsMyRecord.position, Position.current + 1)).write(myPickleBuffer)
  valueMembers.foreach(m => ValSym(m.termNamePosition, valSymPosition, 33562624L, m.typeRefPosition).write(myPickleBuffer))
}
