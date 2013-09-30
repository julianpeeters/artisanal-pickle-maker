package avocet
package tags
import scala.reflect.generic._

case class SingleTpe(scalaRef: Int, modRef: Int) {
  def write(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(14)
  //len
    if (scalaRef > 127 && modRef > 127) myPickleBuffer.writeNat(4);  
    else if (scalaRef > 127 || modRef > 127) myPickleBuffer.writeNat(3);  
    else myPickleBuffer.writeNat(2)
  //data {
    //reference 
    myPickleBuffer.writeNat(scalaRef)
    //reference 
    myPickleBuffer.writeNat(modRef)
  //}
      Position.current += 1
  
}}
