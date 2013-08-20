package avocet 
package types
import tags._
import scala.reflect.internal.pickling._

case class TypeRefTpe_UncheckedVariance(unchecked: ExtModClassRef_unchecked, annotation: ExtModClassRef_annotation, scala: ExtModClassRef_scala) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current 
    TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 6).writeEntry(myPickleBuffer)
    val thisTpe_unchecked = ThisTpe_unchecked()
    thisTpe_unchecked.write(myPickleBuffer)
    unchecked.write(myPickleBuffer)
    TermName("unchecked").write(myPickleBuffer)
    annotation.write(myPickleBuffer, scala)
    TermName("annotation").write(myPickleBuffer)
    ExtRef_nested(Position.current + 1, Position.current - 4).write(myPickleBuffer)
    TypeName("uncheckedVariance").write(myPickleBuffer)
  }
}
