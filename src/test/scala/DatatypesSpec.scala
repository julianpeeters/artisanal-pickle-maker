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

class UnitSpec extends mutable.Specification {

  val mySig_Short = new ScalaSig(List("case class"), List("models", "MyRecord_Int"), List(("c", "Int")))

  val mySig_Int = new ScalaSig(List("case class"), List("models", "MyRecord_Int"), List(("c", "Int")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Long"), List(("d", "Long")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Float"), List(("e", "Float")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Double"), List(("f", "Double")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Char"), List(("g", "Char")))
//  val mySig = new ScalaSig(List("models", "MyRecord_String"), List(("h", "String")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Boolean"), List(("i", "Boolean")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Unit"), List(("j", "Unit")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Null"), List(("k", "Null")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Nothing"), List(("l", "Nothing")))
  //val mySig = new ScalaSig(List("models", "MyRecord_Any"), List(("m", "Any")))
  //val mySig = new ScalaSig(List("models", "MyRecord_AnyRef"), List(("n", "AnyRef")))


 // val mySig = new ScalaSig(List("models", "MyRecord_Short"), List(("l", "Short")))



  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_Int].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)

    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for a case class with all supported datatypes" should {
    "have the correct bytes" in {
      mySig_Short.bytes === correctBytes
    }
  }
 


  val correctBytes_Int: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_Int].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)

    Arrays.copyOf(encodedBytes, len)
  }

  "a ScalaSig for a case class with all supported datatypes" should {
    "have the correct bytes" in {
      mySig_Int.bytes === correctBytes_Int
    }
  }



//mySig_Int.bytes.foreach(println)
//println("---------------------------------------------------")
//correctBytes_Int.foreach(println)

///view results
/*
  val pickleBuffer = new PickleBuffer(correctBytes_Int, 0, correctBytes_Int.length)
  val ps = new PrintStream(new File("output/ShowPickled.MyRecord_Int"))
  ShowPickled.printFile(pickleBuffer, ps)
*/

  val myPickleBuffer_Int = new PickleBuffer(mySig_Int.bytes, 0, mySig_Int.bytes.length-1)
  val ps_Int = new PrintStream(new File("output/ShowPickled.myPickleBuffer_Int"))

  ShowPickled.printFile(myPickleBuffer_Int, ps_Int)

 
}

