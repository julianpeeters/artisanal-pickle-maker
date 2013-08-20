package avocet 
package types
import tags._
import scala.reflect.internal.pickling._

case class TypeRefTpe_AnyRef(thisTpe_scala: ThisTpe_scala, scala: ExtModClassRef_scala) extends Tpe {
  var polyTpePosition = 0
  var position = 0
  def write(myPickleBuffer: PickleBuffer) = {    
    position = Position.current
    TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 4).writeEntry(myPickleBuffer)//this type, ExtRef
    thisTpe_scala.write(myPickleBuffer)
    scala.write(myPickleBuffer)
    TermName("scala").write(myPickleBuffer)
    ExtRef_nested(Position.current + 1, scala.position).write(myPickleBuffer)
    TypeName("AnyRef").write(myPickleBuffer)

  }
}

