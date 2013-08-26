package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.internal.pickling._

case class ProductArity(myPickleBuffer: PickleBuffer, Int: TypeRefTpe_Int) {
  val valSymPosition = Position.current
  Int.position match {
    case 0      => {
      ValSym(Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write(myPickleBuffer)
      TermName("productArity").write(myPickleBuffer)
      PolyTpe(Int).write(myPickleBuffer)
      Int.write(myPickleBuffer)
    }
    case i: Int => {
      ValSym(Position.current + 1, ClassSym.position, 2097664L, i - 1).write(myPickleBuffer)
      TermName("productArity").write(myPickleBuffer)
    }
  }


}
