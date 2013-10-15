package avocet 

import models._
import java.util.Arrays
import scala.reflect.internal.pickling._

import org.specs2._
import mutable._
import specification._

import scala.reflect.ScalaSignature
import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature

class IntSpec extends mutable.Specification {

  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Int"), List(("c", "Int")))

  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_Int].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

  "a ScalaSig for case class MyRecord_Int(c: Int)" should {
    "have the correct string" in {

  def parseByteCodeFromAnnotation(clazz: Class[_]): Option[ByteCode] = {
    clazz.annotation[ScalaSignature] match {
      case Some(sig) if sig != null => {
        val bytes = sig.bytes.getBytes("UTF-8")
        val len = ByteCodecs.decode(bytes)
        Option(ByteCode(bytes.take(len)))
      }
      case _ => None
    }
  }

  def parseByteCodeFromMySig(sig: ScalaSig): ByteCode = {
    val bytes = sig.bytes.getBytes("UTF-8")
    val len = ByteCodecs.decode(bytes)
    ByteCode(bytes.take(len))   
  }





//val correctSig = parseByteCodeFromAnnotation(classOf[MyRecord_Int]).map(ScalaSigAttributeParsers.parse(_))



val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_Int]).map(ScalaSigAttributeParsers.parse(_))
  println(correctParsedSig)
val myParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_Int]).map(ScalaSigAttributeParsers.parse(_))
  println(myParsedSig)











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
//myArray.sameElements(correctArray) === true
correctSig === mySig.bytes

//correctParsedSig === myParsedSig
    }
  }

}
