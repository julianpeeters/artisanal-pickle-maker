package avocet
import tags._
import types._
import scala.reflect.internal.pickling._


class SigResources {
//set up a PickleBuffer to write to
  val myPickleBuffer = new PickleBuffer(new Array[Byte](4096), 0, 0)
//instanstaite our tpes and refs (sets of named objects for use in making the signature)
  val thisTpes = new ThisTpes
  val extModClassRefs = new ExtModClassRefs
  val typeRefTpes = new TypeRefTpes(thisTpes, extModClassRefs)
}
