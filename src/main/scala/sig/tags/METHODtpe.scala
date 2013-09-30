package avocet
package tags
import scala.reflect.generic._

case class MethodTpe(typeRefs: List[Int]) {
  var position = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(20)
  //len
    myPickleBuffer.writeNat(typeRefs.length + typeRefs.filter(tr => tr > 127).length)
  //data {
    //write type references
    typeRefs.foreach(tr => myPickleBuffer.writeNat(tr))

    Position.current += 1
  }
}
