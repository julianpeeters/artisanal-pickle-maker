package avocet
package tags
import types._
import scala.reflect.internal.pickling._

case class CaseClassInfoTpe(AnyRef: TypeRefTpe_AnyRef, Product: TypeRefTpe_Product, Serializable: TypeRefTpe_Serializable) {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(19)
  //len
    myPickleBuffer.writeNat(4)
  //data {
    //reference to entry 1, the CLASSsym                 
      myPickleBuffer.writeNat(ClassSym.position)
    //reference to entry 6, AnyRef typereftype
      AnyRef.position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 1)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)
      }
    //reference to entry 12, Product typereftype 
      Product.position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 7)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)
      }
    //reference to entry 15, Serializable typereftype
      Serializable.position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 10)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)
      }

    Position.current += 1
  }
}
case class ClassInfoTpe(AnyRef: TypeRefTpe_AnyRef) {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(19)
  //len
    myPickleBuffer.writeNat(2)
  //data {
    //reference to entry 1, the CLASSsym                 
      myPickleBuffer.writeNat(ClassSym.position)
    //reference to entry 6, AnyRef typereftype
      AnyRef.position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 1)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)
      }


    Position.current += 1
  }
}
