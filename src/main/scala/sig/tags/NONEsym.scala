package avocet
package tags
import scala.reflect.generic._

case class NoneSym {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    Position.current
  //tag
    myPickleBuffer.writeByte(3)
  //len
    myPickleBuffer.writeNat(0)
  //data
  //}
    Position.current += 1
  }
}

