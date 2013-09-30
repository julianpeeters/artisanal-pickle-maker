package avocet
package tags
import scala.reflect.internal.pickling._

case class AnnotInfo {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(43)
  //len
    if (Position.current + 1 > 127) myPickleBuffer.writeNat(2); else myPickleBuffer.writeNat(1)
  //data {
    //reference to the next entry, EXTMODCLASSref                 
    myPickleBuffer.writeNat(Position.current + 1)
  //}  
    Position.current += 1 
  }  
}  

