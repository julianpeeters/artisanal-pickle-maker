package avocet
package methods
package cls

import scala.reflect.generic._

import tags._
import types._

case class CanEqual(myPickleBuffer: PickleBuffer, productElement: ProductElement, typeRefTpe_Boolean: TypeRefTpe_Boolean, typeRefTpe_Any: TypeRefTpe_Any) {
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write(myPickleBuffer)
  TermName("canEqual").write(myPickleBuffer)
  typeRefTpe_Boolean.position match {
    case 0      => {
      MethodTpe(List(Position.current + 1, Position.current + 4)).write(myPickleBuffer)
      typeRefTpe_Boolean.write(myPickleBuffer)
    }
    case i: Int =>MethodTpe(List(typeRefTpe_Boolean.position, Position.current + 1)).write(myPickleBuffer)
  }
  ValSym(productElement.termNamex1Position, valSymPosition, 2105344L, typeRefTpe_Any.position).write(myPickleBuffer)
}
