package avocet 
import scala.reflect.internal.pickling._

class HB {
  val headerBuffer = new PickleBuffer(new Array[Byte](1024), -1, 0)//get an array ready to be written to
}
