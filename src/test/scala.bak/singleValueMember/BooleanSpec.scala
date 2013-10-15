package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

class BooleanSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Boolean"), List(("i", "Boolean")))
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_Boolean].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_Boolean(i: Boolean)" should {
    "have the correct string" in {

val correctBytes = correctSig.getBytes("UTF-8")
//val correctBytes = intint.getBytes("UTF-8")
val correctLength = ByteCodecs.decode(correctBytes)
val correctArray = Arrays.copyOf(correctBytes, correctLength)




//correctBytes.foreach(println)

println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
 // val mySig = new ScalaSig(List("case class"), List("models", "MyRecord"), List(("c", "Int"), ("c", "Int"))).bytes
  //val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Boolean"), List(("i", "Boolean"))).bytes
//val sig = classOf[MyRecord_Int].getAnnotation(classOf[ScalaSignature]).bytes
//val correctLen = ByteCodecs.decode(correctSig.getBytes("UTF-8"))
val myBytes = mySig.bytes.getBytes("UTF-8")
val myLength = ByteCodecs.decode(myBytes)
val myArray = Arrays.copyOf(myBytes, myLength)
//correctBytes.take(5).foreach(println)








//view results

 // val pickleBuffer = new PickleBuffer(correctSig.getBytes, 0, correctSig.length)
 // val ps = new PrintStream(new File("output/ShowPickled.MyRecord_StringIntBoolean"))
 // ShowPickled.printFile(pickleBuffer, ps)

 // val myPickleBuffer = new PickleBuffer(mySig.debug, 0, mySig.debug.length)
 // val myPs = new PrintStream(new File("output/ShowPickled.myPickleBuffer"))

  //ShowPickled.printFile(myPickleBuffer, myPs)


//myBytes.foreach(println)
println(mySig.bytes == correctSig)
println(mySig.bytes.diff(correctSig))
println(myBytes.sameElements(correctBytes))
println(myBytes == correctBytes)
println(myLength == correctLength)
println(correctLength)
println(myLength)
      mySig.bytes === correctSig
//      mySig === correctSig
    }
  }

}
