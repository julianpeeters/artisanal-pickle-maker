package avocet 
package types
import tags._
import scala.reflect.internal.pickling._

case class TypeRefTpe_modelsMyRecord extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_nonGeneric(Position.current + 1, ClassSym.position).writeEntry(myPickleBuffer)
  }
}

