package avocet
package tags
import scala.reflect.internal.pickling._

object ModuleSym {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(7)
  //len
    if (Position.current + 1 > 127 && Position.current + 2 > 127) myPickleBuffer.writeNat(9);  
    else if (Position.current + 1 > 127 || Position.current + 2 > 127) myPickleBuffer.writeNat(8);  
    else myPickleBuffer.writeNat(7)
  //data {
    //reference to entry 1, the class name                 
      myPickleBuffer.writeNat(Position.current + 1)
    //reference to the owner of the class
      myPickleBuffer.writeNat(2)//TYPEREFs for types not already defined need to be added next
    //pickledflags 
      myPickleBuffer.writeLongNat(2098176L)//(64 represents the "case" modifier)
    //reference to entry 5, the class info 
      myPickleBuffer.writeNat(Position.current + 2)


      Position.current += 1
  }
}

