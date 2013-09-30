package avocet
package tags
import scala.reflect.generic._

case class ExtRef_topLevel(ref: Int) {
  //Write entry  EXTref
  def write(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(9)
  //len
    if (ref > 127) myPickleBuffer.writeNat(2)
    else myPickleBuffer.writeNat(1)
  //data {
    //reference               
      myPickleBuffer.writeNat(ref)
  //}
      Position.current += 1
  }
}

case class ExtRef_nested(nameRef: Int, ownerRef: Int) {
  val args = List(nameRef, ownerRef)
  //Write entry  EXTref
  def write(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(9)
  //len
    myPickleBuffer.writeNat(2 + args.filter(arg => arg > 127).length)
/*
    if (nameRef > 127 && ownerRef > 127) myPickleBuffer.writeNat(4);  
    else if (nameRef > 127 || ownerRef > 127) myPickleBuffer.writeNat(3);  
    else myPickleBuffer.writeNat(2)
*/
  //data {
    //reference to the next entry,              
     myPickleBuffer.writeNat(nameRef)
    //reference to the next entry,              
     myPickleBuffer.writeNat(ownerRef)
  //}
      Position.current += 1
  }
}
