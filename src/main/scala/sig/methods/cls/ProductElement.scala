package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.generic._

case class ProductElement(myPickleBuffer: PickleBuffer, Any: TypeRefTpe_Any, Int: TypeRefTpe_Int) {
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write(myPickleBuffer)
  TermName("productElement").write(myPickleBuffer)
  Any.position match {
    case 0      => { 
      MethodTpe(List(Position.current + 1, Position.current + 4)).write(myPickleBuffer)
      Any.write(myPickleBuffer)
    }
    case i: Int => MethodTpe(List(i, Position.current + 1)).write(myPickleBuffer)
  }
  ValSym(Position.current + 1, valSymPosition, 2105344L, Int.position).write(myPickleBuffer)
  val termNamex1Position = Position.current
  TermName("x$1").write(myPickleBuffer)
}
