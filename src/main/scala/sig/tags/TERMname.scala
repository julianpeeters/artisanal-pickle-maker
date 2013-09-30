package avocet
package tags
import scala.reflect.generic._

case class TermName (name: String){
  def write(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(1)
  //len
    myPickleBuffer.writeNat(name.length)
  //data {
    //write the bytes of the string to the pickle buffer                 
      name.getBytes.foreach(b => myPickleBuffer.writeNat(b))
  //}
      Position.current += 1
  }
}
