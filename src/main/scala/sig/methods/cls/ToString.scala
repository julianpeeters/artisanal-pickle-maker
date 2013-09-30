package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.generic._

case class ToString(myPickleBuffer: PickleBuffer, javaLangString: TypeRefTpe_javaLangString) {
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write(myPickleBuffer)

  val termNamePosition = Position.current
  TermName("toString").write(myPickleBuffer)

  val MethodTpePosition = Position.current
  MethodTpe(List(javaLangString.position)).write(myPickleBuffer)
}
