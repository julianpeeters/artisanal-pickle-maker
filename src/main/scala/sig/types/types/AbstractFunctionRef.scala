package avocet 
package types
import tags._
import scala.reflect.generic._

case class TypeRefTpe_AbstractFunction(valueMembers: List[ValueMember], modelsMyRecord: TypeRefTpe_modelsMyRecord, thisTpe_runtime: ThisTpe_runtime, runtime: ExtModClassRef_runtime, scala: ExtModClassRef_scala) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_function(Position.current + 1, Position.current + 4, valueMembers.map(_.typeRefPosition), modelsMyRecord.position).writeEntry(myPickleBuffer)
    thisTpe_runtime.write(myPickleBuffer)
    runtime.write(myPickleBuffer, scala)
    TermName("runtime").write(myPickleBuffer)
    ExtRef_nested(Position.current + 1, Position.current - 2).write(myPickleBuffer)
    TypeName("AbstractFunction" + valueMembers.length).write(myPickleBuffer)
  }
}
