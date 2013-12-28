package artisanal.pickle.maker 
import models._

import org.specs2._
import mutable._
import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature



class AllDatatypesSpec extends mutable.Specification {

  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AllDatatypes"), List(("a", "Byte"), ("b", "Short"), ("c", "Int"), ("d", "Long"), ("e", "Float"), ("f", "Double"), ("g", "Char"), ("h", "String"), ("i", "Boolean"), ("j", "Unit"), ("k", "Null"), ("l", "Nothing"), ("m", "Any"), ("n", "Byte"), ("o", "Object")))


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

  "a ScalaSig for a case class with all supported datatypes (MyRecord_AllDatatypes) " should {
    "have the correct string" in {


 val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_AllDatatypes]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get

    correctParsedSig.toString === myParsedSig.toString
  }

    }

}

