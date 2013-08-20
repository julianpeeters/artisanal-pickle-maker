package avocet
package tags
import scala.reflect.internal.pickling._

case class TypeName (name: String) {
  def write(myPickleBuffer: PickleBuffer) = {
  //tag
    myPickleBuffer.writeByte(2)
  //len
    myPickleBuffer.writeNat(name.length)
  //data {
    //               
      name.getBytes.foreach(b => myPickleBuffer.writeNat(b))
  //}
      Position.current += 1
  }
}
