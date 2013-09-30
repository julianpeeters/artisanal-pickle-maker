package avocet 

import models._
import java.util.Arrays
import java.io.{File, PrintStream}
import scala.reflect.generic._
import scala.tools.nsc.util.ShowPickled

import org.specs2._
import mutable._
import specification._
import execute.Success

class tempSpec extends mutable.Specification {

//  val mySig_Short = new ScalaSig(List("case class"), List("models", "MyRecord_Int"), List(("c", "Int")))

  //val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Int"), List(("c", "Int")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Long"), List(("d", "Long")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Float"), List(("e", "Float")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Double"), List(("f", "Double")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Char"), List(("g", "Char")))
//  val mySig = new ScalaSig(List("models", "MyRecord_String"), List(("h", "String")))
 // val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Boolean"), List(("i", "Boolean")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Unit"), List(("j", "Unit")))
//  val mySig = new ScalaSig(List("models", "MyRecord_Null"), List(("k", "Null")))
//  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Nothing"), List(("l", "Nothing")))
 // val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Any"), List(("m", "Any")))
  //val mySig = new ScalaSig(List("models", "MyRecord_AnyRef"), List(("n", "AnyRef")))


 // val mySig = new ScalaSig(List("models", "MyRecord_Short"), List(("l", "Short")))
  //val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_IntInt"), List(("c1", "Null"), ("c2", "Null")))


  //val correctBytes: Array[Byte] = {
 //   val scalaSigAnnot = classOf[MyRecord_IntInt].getAnnotation(classOf[scala.reflect.ScalaSignature])
 //   val encodedBytes  = scalaSigAnnot.bytes.getBytes
 //   val len           = ByteCodecs.decode(encodedBytes)

 //   Arrays.copyOf(encodedBytes, len)
 // }
/*
  "a ScalaSig for a case class with all supported datatypes" should {
    "have the correct bytes" in {
      mySig.bytes === correctBytes
    }
  }
 */




//mySig_Int.bytes.foreach(println)
//println("---------------------------------------------------")
//correctBytes_Int.foreach(println)

///view results
/*
  val pickleBuffer = new PickleBuffer(correctBytes, 0, correctBytes.length)
  val ps = new PrintStream(new File("output/ShowPickled.MyRecord_IntInt"))
  ShowPickled.printFile(pickleBuffer, ps)


  val myPickleBuffer = new PickleBuffer(mySig.bytes, 0, mySig.bytes.length-1)
  val myPs = new PrintStream(new File("output/ShowPickled.myPickleBuffer"))

  ShowPickled.printFile(myPickleBuffer, myPs)
*/
 
}

