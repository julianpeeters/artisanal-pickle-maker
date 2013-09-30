package avocet
package tags
import scala.reflect.generic._

case class AnnotatedTpe(valueMember: ValueMember, annotInfo: AnnotInfo) {

  def write(myPickleBuffer: PickleBuffer) = {
  //  val args = List(valueMember.typeRefPosition, Position.current + 1, annotInfo.position)
    val argsA = List(valueMember.typeRefPosition, Position.current + 1)
    val argsB = List(valueMember.typeRefPosition, annotInfo.position)
    annotInfo.position match {
      case 0      => {
      //tag
        myPickleBuffer.writeByte(42)
      //len

    myPickleBuffer.writeNat(2 + argsA.filter(arg => arg > 127).length)
      //data {
        //reference to the next entry, EXTMODCLASSref                 
          myPickleBuffer.writeNat(valueMember.typeRefPosition)
        //reference to 
          myPickleBuffer.writeNat(Position.current + 1)
      } 
      case i: Int => {
      //tag
        myPickleBuffer.writeByte(42)
      //len

    myPickleBuffer.writeNat(2 + argsB.filter(arg => arg > 127).length)
      //data {
        //reference to the next entry, EXTMODCLASSref                 
          myPickleBuffer.writeNat(valueMember.typeRefPosition)
        //reference to 
          myPickleBuffer.writeNat(annotInfo.position)
      //}
      }
    }
    Position.current += 1 
  } 
}  
