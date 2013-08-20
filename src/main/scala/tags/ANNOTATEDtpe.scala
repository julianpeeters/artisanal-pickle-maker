package avocet
package tags
import scala.reflect.internal.pickling._

case class AnnotatedTpe(valueMember: ValueMember, annotInfo: AnnotInfo) {

  def write(myPickleBuffer: PickleBuffer) = {
    val args = List(valueMember, Position.current + 1, annotInfo.position)
    annotInfo.position match {
      case 0      => {
      //tag
        myPickleBuffer.writeByte(42)
      //len
        if (valueMember.typeRefPosition > 127 && Position.current + 1 > 127) myPickleBuffer.writeNat(4)
        else if (valueMember.typeRefPosition > 127 && Position.current + 1 > 127 ) myPickleBuffer.writeNat(3)
        else myPickleBuffer.writeNat(2)
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
        if (valueMember.typeRefPosition > 127 && annotInfo.position > 127) myPickleBuffer.writeNat(4)
        else if (valueMember.typeRefPosition < 127 && annotInfo.position > 127) myPickleBuffer.writeNat(3)
        else myPickleBuffer.writeNat(2)
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
