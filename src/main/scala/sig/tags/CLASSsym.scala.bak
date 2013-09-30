package avocet
package tags
import scala.reflect.internal.pickling._

object ClassSym {
  var position = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
  //tag
      myPickleBuffer.writeByte(6)
  //len
      myPickleBuffer.writeNat(4)
  //data {
    //reference to entry 1, the class name                 
      myPickleBuffer.writeByte(1)

    //reference to the owner of the class
      new ExtModClassRef_topLevel_class(Position.current + 3).position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 2)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)//should point to "models" if this is for a Salat and Play2 App
      }

    //pickledflags 
      myPickleBuffer.writeNat(64)//(64 represents the "case" modifier)
    //reference to entry 5, the class info 
      myPickleBuffer.writeNat(5)

      Position.current += 1
  }
}

    //optional reference to 2nd level package, i.e., if the immediate owner has a dot, e.g. "com.MyOrg"
      //myPickleBuffer.writeByte()//TODO write immediate as well as top level owners
      //myPickleBuffer.writeByte()//TODO write the TERMname
