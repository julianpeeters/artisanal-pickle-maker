package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.internal.pickling._

case class Equals(myPickleBuffer: PickleBuffer, productElement: ProductElement, Boolean: TypeRefTpe_Boolean, Any: TypeRefTpe_Any) {
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write(myPickleBuffer) 
  TermName("equals").write(myPickleBuffer)
  MethodTpe(List(Boolean.position, Position.current + 1)).write(myPickleBuffer)
  ValSym(productElement.termNamex1Position, valSymPosition, 2105344L, Any.position).write(myPickleBuffer)
}
