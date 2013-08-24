package avocet 

import models._
import java.util.Arrays
import java.io.{File, PrintStream}
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled

import org.specs2._
import mutable._
import specification._
import execute.Success

class AllDatatypesSpec extends mutable.Specification {

  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AllDatatypes"), List(("a", "Byte"), ("b", "Short")))//, ("c", "Int"), ("d", "Long"), ("e", "Float"), ("f", "Double"), ("g", "Char"), ("h", "String"), ("i", "Boolean"), ("j", "Unit"), ("k", "Null"), ("l", "Nothing"), ("m", "Any"), ("n", "AnyRef"), ("o", "Object")))


  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_AllDatatypes].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)

    Arrays.copyOf(encodedBytes, len)
  }
/*
  "a ScalaSig for a case class with all supported datatypes" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes:+(0.toByte)
    }
  }
 */
///view results
  val pickleBuffer = new PickleBuffer(correctBytes, 0, correctBytes.length)
  val ps = new PrintStream(new File("output/ShowPickled.MyRecord_AllDatatypes"))
  ShowPickled.printFile(pickleBuffer, ps)


  val myPickleBuffer = new PickleBuffer(mySig.bytes, 0, mySig.bytes.length-1)
  val myPs = new PrintStream(new File("output/ShowPickled.myPickleBuffer"))

  ShowPickled.printFile(myPickleBuffer, myPs)

 
}

