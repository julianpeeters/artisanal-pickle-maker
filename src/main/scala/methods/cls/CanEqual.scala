package avocet
package methods
package cls

import scala.reflect.internal.pickling._

import tags._
import types._

case class CanEqual(myPickleBuffer: PickleBuffer, productElement: ProductElement, Boolean: TypeRefTpe_Boolean, Any: TypeRefTpe_Any) {
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write(myPickleBuffer)
  TermName("canEqual").write(myPickleBuffer)
  MethodTpe(List(Position.current + 1, Position.current + 4)).write(myPickleBuffer)
  Boolean.write(myPickleBuffer)
  ValSym(productElement.termNamex1Position, valSymPosition, 2105344L, Any.position).write(myPickleBuffer)
}
