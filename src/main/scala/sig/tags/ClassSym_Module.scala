package avocet
package tags
import scala.reflect.internal.pickling._

object ClassSym_Module {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
      myPickleBuffer.writeByte(6)
  //len
     // myPickleBuffer.writeNat(7)
    if (Position.current + 1 > 127) myPickleBuffer.writeNat(8); else myPickleBuffer.writeNat(7)
  //data {
    //reference to entry 1, the class name                 
      myPickleBuffer.writeByte(1)

    //reference to the owner of the class
      myPickleBuffer.writeNat(2)
    //pickledflags 
      myPickleBuffer.writeLongNat(2098176L)
    //reference
      myPickleBuffer.writeNat(Position.current + 1)

      Position.current += 1
  }
}


