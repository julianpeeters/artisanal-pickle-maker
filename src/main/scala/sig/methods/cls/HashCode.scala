package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.internal.pickling._

case class HashCode(myPickleBuffer: PickleBuffer, Int: TypeRefTpe_Int) {
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write(myPickleBuffer)
  TermName("hashCode").write(myPickleBuffer)
  MethodTpe(List(Int.position)).write(myPickleBuffer)
}
