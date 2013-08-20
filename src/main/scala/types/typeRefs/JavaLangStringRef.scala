package avocet 
package types
import tags._
import scala.reflect.internal.pickling._

case class TypeRefTpe_javaLangString extends Tpe{
  var position = 0
  var polyTpePosition = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 6).writeEntry(myPickleBuffer)
  }
}
