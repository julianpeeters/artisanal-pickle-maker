package avocet 
package types
import tags._
import scala.reflect.internal.pickling._

case class TypeRefTpe_moduleClass(thisTpe_owner: ThisTpe_owner) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_nonGeneric(thisTpe_owner.position, Position.current + 1).writeEntry(myPickleBuffer)
  }
}
