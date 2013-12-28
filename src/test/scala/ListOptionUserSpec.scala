package artisanal.pickle.maker 
import models._

import org.specs2._
import mutable._
import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature



class ListOptionUserSpec extends mutable.Specification {

  val mySig = new artisanal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListOptionUser"), List(("cc1", "String"), ("cc2", "List[String]"), ("cc3", "Option[String]"), ("cc4", "Option[List[MyRecord_User]]"), ("cc5", "List[Option[MyRecord_User]]")))

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

  def parseByteCodeFromMySig(sig: artisanal.pickle.maker.ScalaSig): Option[ByteCode] = {
    val bytes = sig.bytes.getBytes("UTF-8")
    val len = ByteCodecs.decode(bytes)
    Option(ByteCode(bytes.take(len)))   
  }

  "a ScalaSig for case class MyRecord_ListOptionUser(cc1: String, cc2: List[String], cc3: Option[String], cc4: Option[List[MyRecord_User]], cc5: List[Option[MyRecord_User]], )" should {
    "have the correct string" in {
    val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_ListOptionUser]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
    correctParsedSig.toString === myParsedSig.toString
    }
  }



}

