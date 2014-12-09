package artisanal.pickle.maker 
import models._
import parser._

import org.specs2._
import mutable._
import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature



class AllDatatypesSpec extends mutable.Specification {


  "a ScalaSig for a case class with all supported datatypes (MyRecord_AllDatatypes) " should {
    "have the correct string" in {

      val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AllDatatypes"), List(("a", "Byte"), ("b", "Short"), ("c", "Int"), ("d", "Long"), ("e", "Float"), ("f", "Double"), ("g", "Char"), ("h", "String"), ("i", "Boolean"), ("j", "Unit"), ("k", "Null"), ("l", "Nothing"), ("m", "Any"), ("n", "Byte"), ("o", "Object")))

      val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_AllDatatypes]).map(ScalaSigAttributeParsers.parse(_)).get
      val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get

      correctParsedSig.toString === myParsedSig.toString
  }

    }

}

