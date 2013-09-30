package avocet
package tags
import types._
import scala.reflect.internal.pickling._

case class ClassInfoTpe_Module(valueMembers: List[ValueMember], modelsMyRecord: TypeRefTpe_modelsMyRecord, thisTpe_runtime: ThisTpe_runtime, runtime: ExtModClassRef_runtime, scala: ExtModClassRef_scala) {
  val args = List(Position.current + 1, ClassSym_Module.position)
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
//tag
    myPickleBuffer.writeByte(19)
//len
    myPickleBuffer.writeNat(3 + args.filter(arg => arg > 127).length)
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
