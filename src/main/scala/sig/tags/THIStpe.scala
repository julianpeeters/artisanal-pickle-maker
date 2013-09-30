package avocet
package tags
import scala.reflect.internal.pickling._

case class ThisTpe_scala      extends ThisTpe//(Position.current + 1)
case class ThisTpe_package    extends ThisTpe//(Position.current + 1)
case class ThisTpe_lang       extends ThisTpe//(Position.current + 1)
case class ThisTpe_javaLang   extends ThisTpe//(Position.current + 1)
case class ThisTpe_root       extends ThisTpe//(Position.current + 1) 
case class ThisTpe_unchecked  extends ThisTpe//(Position.current + 1)
case class ThisTpe_collection extends ThisTpe//(Position.current + 1)
case class ThisTpe_runtime    extends ThisTpe//(Position.current + 1) 
case class ThisTpe_owner      extends ThisTpe_owner_//(ExtModClassRef_owner.position)

class ThisTpe {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  =  {
  position = Position.current  
  //tag
    myPickleBuffer.writeByte(13)
  //len
    if (Position.current + 1 > 127) myPickleBuffer.writeNat(2); else myPickleBuffer.writeNat(1)
  //data {
    //reference to the head of the type's typereftype chain             
      Position.current + 1 match {
        case 0      => myPickleBuffer.writeNat(Position.current + 1)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)       
      }
  //}
      Position.current += 1
  }
}

class ThisTpe_owner_ {
  var position = 0
  def write(myPickleBuffer: PickleBuffer, owner: ExtModClassRef_owner)  =  {
    position = Position.current  
  //tag
    myPickleBuffer.writeByte(13)
  //len

    owner.position match {
      case 0      => if (Position.current + 1 > 127) myPickleBuffer.writeNat(2); else myPickleBuffer.writeNat(1)//TYPEREFs for types not already defined need to be added next
      case i: Int => if (owner.position > 127) myPickleBuffer.writeNat(2); else myPickleBuffer.writeNat(1)       
    }
  //  if (Position.current + 1 > 127 || owner.position > 127) myPickleBuffer.writeNat(2); else myPickleBuffer.writeNat(1)
  //data {
    //reference to the head of the type's typereftype chain             
      owner.position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 1)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)       
      }
  //}

      Position.current += 1

  }

}  
