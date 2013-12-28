package artisanal.pickle.maker 
import models._

import org.specs2._
import mutable._
import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature


class AnyRefAnyRefSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AnyRefAnyRef"), List(("n1", "AnyRef"), ("n2", "AnyRef")))
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


  "a ScalaSig for case class MyRecord_AnyRefAnyRef(n1: AnyRef, n2: AnyRef)" should {
    "have the correct string" in {
    val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_AnyRefAnyRef]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_AnyRefAnyRef]).map(ScalaSigAttributeParsers.parse(_)).get
 
    correctParsedSig.toString === myParsedSig.toString
    }
  }

}
