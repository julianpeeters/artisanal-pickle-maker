package avocet 
package types
import tags._
import scala.reflect.internal.pickling._

case class TypeRefTpe_String(thisTpe_scala: ThisTpe_scala, scala: ExtModClassRef_scala, predef: ExtModClassRef_predef) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var typeNamePosition = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 4).writeEntry(myPickleBuffer)
    SingleTpe(thisTpe_scala.position, Position.current + 1).write(myPickleBuffer) 
    ExtRef_nested(Position.current + 1, scala.position).write(myPickleBuffer)
    TermName("Predef").write(myPickleBuffer)
    ExtRef_nested(Position.current + 1, Position.current + 2).write(myPickleBuffer)
    typeNamePosition = Position.current
    TypeName("String").write(myPickleBuffer)
    predef.write(myPickleBuffer, scala)
  }
}


