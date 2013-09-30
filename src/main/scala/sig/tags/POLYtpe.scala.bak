package avocet
package tags
import types._
import scala.reflect.internal.pickling._

case class PolyTpe[X <: Tpe](typeRef: X) {
 // val args = List(Position.current + 1, typeRef.position)
  def write(myPickleBuffer: PickleBuffer) {
  //tag
    myPickleBuffer.writeByte(21)
  //len
    //myPickleBuffer.writeNat(1 + args.filter(arg => arg > 127).length)
    if (Position.current + 1 > 127 || typeRef.position > 127) myPickleBuffer.writeNat(2); else myPickleBuffer.writeNat(1)
  //data {
    //reference to the head of the type's typereftype chain             
      typeRef.position match {//TYPEREFs for types not already defined need to be added next
        case 0      => myPickleBuffer.writeNat(Position.current + 1); typeRef.polyTpePosition = Position.current
        case i: Int => myPickleBuffer.writeNat(i); typeRef.polyTpePosition = Position.current
      }
  //}
      Position.current += 1
  }
}


