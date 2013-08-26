package avocet 
package types
import tags._
import scala.reflect.internal.pickling._

case class TypeRefTpe_Stream(scala: ExtModClassRef_scala) extends Tpe {
  var polyTpePosition = 0
  var position = 0
  var annotPos = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_generic(Position.current + 1, Position.current + 9, Position.current + 12) 
    SingleTpe(Position.current + 1, Position.current + 6)
    SingleTpe(Position.current + 1, Position.current + 4)
    val thisTpe_root = ThisTpe_root
    ExtModClassRef_root
    TermName("<root>")
    ExtRef_topLevel(9)
    ExtRef_nested(Position.current + 1, scala.position)
    TermName("package")
    ExtRef_nested(Position.current + 1, Position.current + 2)
    TypeName("Stream")
  }
}
