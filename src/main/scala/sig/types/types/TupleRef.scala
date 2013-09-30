package avocet 
package types
import tags._
import scala.reflect.generic._

case class TypeRefTpe_Tuple(valueMembers: List[ValueMember], thisTpe_scala: ThisTpe_scala, scala: ExtModClassRef_scala) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_tuple(thisTpe_scala.position + 1, Position.current + 1, valueMembers.map(_.typeRefPosition)).writeEntry(myPickleBuffer)
    ExtRef_nested(Position.current + 1, scala.position).write(myPickleBuffer)
    TypeName("Tuple" + valueMembers.length).write(myPickleBuffer)
  }
}
