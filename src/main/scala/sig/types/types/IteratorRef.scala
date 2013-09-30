package avocet 
package types
import tags._
import scala.reflect.generic._

case class TypeRefTpe_Iterator(thisTpe_collection: ThisTpe_collection, Any: TypeRefTpe_Any, collection: ExtModClassRef_collection, scala: ExtModClassRef_scala) extends Tpe{
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  def write(myPickleBuffer: PickleBuffer) = {
  position = Position.current

  TypeRefTpe_generic(Position.current + 1, Position.current + 4, Any.position).writeEntry(myPickleBuffer)
  thisTpe_collection.write(myPickleBuffer)
  collection.write(myPickleBuffer, scala)
  TermName("collection").write(myPickleBuffer)
  ExtRef_nested(Position.current + 1, collection.position).write(myPickleBuffer)
  TypeName("Iterator").write(myPickleBuffer)
}
}

