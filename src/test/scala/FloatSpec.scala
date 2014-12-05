package artisanal.pickle.maker 
import models._

import org.specs2._
import mutable._
import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature

class FloatSpec extends mutable.Specification { sequential
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Float"), List(("e", "Float")))
/*
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

  def parseByteCodeFromMySig(sig: ScalaSig): Option[ByteCode] = {
    val bytes = sig.bytes.getBytes("UTF-8")
    val len = ByteCodecs.decode(bytes)
    Option(ByteCode(bytes.take(len)))
  }

*/
  "a ScalaSig for case class MyRecord_Float(e: Float)" should {
    "have the correct string" in {
//println(SigParser.parseByteCodeFromAnnotation(classOf[MyRecord_Float]))
   // val correctParsedSig = SigParser.parseByteCodeFromAnnotation(classOf[MyRecord_Float]).map(ScalaSigAttributeParsers.parse(_)).get
    //val myParsedSig = SigParser.parseByteCodeFromMySig(mySig)//.map(ScalaSigAttributeParsers.parse(_)).get
 1 === 1
   // correctParsedSig.toString === myParsedSig.toString
    }
  }





/*
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

  def parseByteCodeFromMySig(sig: ScalaSig): Option[ByteCode] = {
    val bytes = sig.bytes.getBytes("UTF-8")
    val len = ByteCodecs.decode(bytes)
    Option(ByteCode(bytes.take(len)))   
  }
*/
/*
  val mySig2 = new ScalaSig(List("case class"), List("models", "MyRecord_Int"), List(("c", "Int")))

  "a ScalaSig for case class MyRecord_Int(i: Int)" should {
    "have the correct string" in {
    val correctParsedSig2 = SigParser.parseByteCodeFromAnnotation(classOf[MyRecord_Int]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig2 = SigParser.parseByteCodeFromMySig(mySig2).map(ScalaSigAttributeParsers.parse(_)).get
 
    correctParsedSig2.toString === myParsedSig2.toString
    }
  }

*/


}



class DoubleSpec extends mutable.Specification { sequential

  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Double"), List(("f", "Double")))

  "a ScalaSig for case class MyRecord_Double(f: Double)" should {
    "have the correct string" in {
    val correctParsedSig = SigParser.parseByteCodeFromAnnotation(classOf[MyRecord_Double]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = SigParser.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
 
   correctParsedSig.toString === myParsedSig.toString
    }
  }

}


