package avocet 
import models._

import org.specs2._
import mutable._
import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature



class StringIntBooleanSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_StringIntBoolean"), List(("x", "String"), ("y", "Int"), ("z", "Boolean")))
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

  "a ScalaSig for case class MyRecord_StringIntBoolean(x: String, y: Int, z: Boolean)" should {
    "have the correct string" in {
    val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_UnitUnit]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_UnitUnit]).map(ScalaSigAttributeParsers.parse(_)).get
 println(correctParsedSig.toString)
    correctParsedSig.toString === myParsedSig.toString
    }
  }

/*
//view results
  val pickleBuffer = new PickleBuffer(correctBytes, 0, correctBytes.length)
  val ps = new PrintStream(new File("output/ShowPickled.MyRecord_StringIntBoolean"))
  ShowPickled.printFile(pickleBuffer, ps)

  val myPickleBuffer = new PickleBuffer(mySig.bytes, 0, mySig.bytes.length-1)
  val myPs = new PrintStream(new File("output/ShowPickled.myPickleBuffer"))

  ShowPickled.printFile(myPickleBuffer, myPs)
*/
 
}

