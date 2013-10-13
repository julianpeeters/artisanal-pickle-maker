package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class IntSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Int"), List(("c", "Int")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_Int].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_Int(c: Int)" should {
    "have the correct string" in {



val correctBytes = correctSig.getBytes("UTF-8")
val correctLen = ByteCodecs.decode(correctBytes) 
println(correctLen)
val correctArray = Arrays.copyOf(correctBytes, correctLen)


val myBytes = mySig.bytes.getBytes("UTF-8").dropRight(1)
val myLen = ByteCodecs.decode(myBytes)
println(myLen)
val myArray = Arrays.copyOf(myBytes, myLen)

//correctLen === myLen
correctArray.diff(myArray).foreach(println)
//correctLen === myLen
myArray.sameElements(correctArray) === true
//correctSig === mySig.bytes
    }
  }

}
