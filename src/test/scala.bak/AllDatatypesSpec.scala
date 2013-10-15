package avocet 

import models._
import java.util.Arrays

import scala.io.Codec._

import scala.reflect.internal.pickling._


import org.specs2._
import mutable._
import specification._
import execute.Success

class AllDatatypesSpec extends mutable.Specification {

  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AllDatatypes"), List(("a", "Byte"), ("b", "Short"), ("c", "Int"), ("d", "Long"), ("e", "Float"), ("f", "Double"), ("g", "Char"), ("h", "String"), ("i", "Boolean"), ("j", "Unit"), ("k", "Null"), ("l", "Nothing"), ("m", "Any"), ("n", "Byte"), ("o", "Object")))


  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_AllDatatypes].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for a case class with all supported datatypes (MyRecord_AllDatatypes) " should {
    "have the correct string" in {

//       mySig.bytes.dropRight(6).foreach(println)
//println("************************************************")
//correctSig.foreach(println)
      
val correctLen = ByteCodecs.decode(correctSig.getBytes("UTF-8")) 
//println(correctLen)
val myLen = ByteCodecs.decode(mySig.bytes.dropRight(6).getBytes("UTF-8"))
//println(myLen)

val myArray = Arrays.copyOf(mySig.bytes.getBytes("UTF-8"), myLen)
val correctArray = Arrays.copyOf(correctSig.getBytes("UTF-8"), correctLen)
//myArray.foreach(println)
//println("||||||||||||||||||||||||||||||||||||||||||")
//correctArray.foreach(println)


//mySig.bytes === correctSig
myArray === correctArray
  }

    }

}

