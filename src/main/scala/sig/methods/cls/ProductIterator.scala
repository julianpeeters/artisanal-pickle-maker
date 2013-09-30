package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.generic._

case class ProductIterator(myPickleBuffer: PickleBuffer, Iterator: TypeRefTpe_Iterator) {
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write(myPickleBuffer)
  TermName("productIterator").write(myPickleBuffer)
  PolyTpe(Iterator).write(myPickleBuffer)
  Iterator.write(myPickleBuffer)
}
