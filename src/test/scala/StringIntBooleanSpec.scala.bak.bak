package avocet 

import models._
import java.util.Arrays

import scala.reflect.generic._
import scala.tools.nsc.util.ShowPickled
import java.io.{File, PrintStream}

import org.specs2._
import mutable._
import specification._

class StringIntBooleanSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_StringIntBoolean"), List(("x", "String"), ("y", "Int"), ("z", "Boolean")))
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_StringIntBoolean].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)
    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for case class MyRecord_StringIntBoolean(x: String, y: Int, z: Boolean)" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes:+(0.toByte)
    }
  }


//view results
  val pickleBuffer = new PickleBuffer(correctBytes, 0, correctBytes.length)
  val ps = new PrintStream(new File("output/ShowPickled.MyRecord_StringIntBoolean"))
  ShowPickled.printFile(pickleBuffer, ps)

  val myPickleBuffer = new PickleBuffer(mySig.bytes, 0, mySig.bytes.length-1)
  val myPs = new PrintStream(new File("output/ShowPickled.myPickleBuffer"))

  ShowPickled.printFile(myPickleBuffer, myPs)

 
}

