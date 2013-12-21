package artisinal.pickle.maker 
import models._

import org.specs2._
import mutable._
import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature



class ListStringStringListStringSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ListStringStringListString"), List(("lsl1", "List[String]"), ("lsl2", "String"), ("lsl3", "List[String]")))
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

  "a ScalaSig for case class MyRecord_ListStringStringListString(lsl1: List[String], lsl2: String, lsl3: List[String])" should {
    "have the correct string" in {
    val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_ListStringStringListString]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
    correctParsedSig.toString === myParsedSig.toString
    }
  }

}

