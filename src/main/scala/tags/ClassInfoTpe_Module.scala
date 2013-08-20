package avocet
package tags
import types._
import scala.reflect.internal.pickling._

case class ClassInfoTpe_Module(valueMembers: List[ValueMember], modelsMyRecord: TypeRefTpe_modelsMyRecord, thisTpe_runtime: ThisTpe_runtime, runtime: ExtModClassRef_runtime, scala: ExtModClassRef_scala) {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
//tag
    myPickleBuffer.writeByte(19)
//len
    if (Position.current + 1 > 127 || TypeRefTpe_AbstractFunction(valueMembers, modelsMyRecord, thisTpe_runtime, runtime, scala).position > 127) myPickleBuffer.writeNat(4);  myPickleBuffer.writeNat(3)
//data {
  //reference to a ClassSym
    myPickleBuffer.writeNat(ClassSym_Module.position)  
  //reference to AbstractFuntion
    TypeRefTpe_AbstractFunction(valueMembers, modelsMyRecord, thisTpe_runtime, runtime, scala).position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 1)
        case i: Int => myPickleBuffer.writeNat(i)
    }
  //reference to entry 15, Serializable typereftype
    myPickleBuffer.writeNat(15)
    

    Position.current += 1
  }
}
