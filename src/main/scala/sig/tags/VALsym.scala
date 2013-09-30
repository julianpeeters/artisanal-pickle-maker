package avocet
package tags
import scala.math._
import scala.reflect.internal.pickling._

case class ValSym(termNamePos: Int, classSymPos: Int, flags: Long, typeRefPos: Int) {
  val args = List(termNamePos, classSymPos, flags, typeRefPos)
  def write(myPickleBuffer: PickleBuffer)  = {

  //tag
    myPickleBuffer.writeByte(8)
  //len
    val byteBoundaries = (1 to 10).map(power => pow(128,power))//for filtering values that will require more than one byte to write,
    val extraLength = byteBoundaries.map(byteBoundary => args.filter(arg => arg > byteBoundary-1).length).sum//sums the lengths of each filter
    myPickleBuffer.writeNat(4 + extraLength)
  //data {
    //reference 
      myPickleBuffer.writeNat(termNamePos)
    //reference 
      myPickleBuffer.writeNat(classSymPos)
    //reference 
      myPickleBuffer.writeLongNat(flags)
    //reference 
      myPickleBuffer.writeNat(typeRefPos)
    Position.current += 1


  }
}
