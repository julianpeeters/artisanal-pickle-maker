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



class ListOptionUserSpec extends mutable.Specification {



  "a ScalaSig for case class MyRecord_ListOptionUser(cc1: String, cc2: List[String], cc3: Option[String], cc4: Option[List[MyRecord_User]], cc5: List[Option[MyRecord_User]], )" should {
    "have the correct string" in {

      val mySig = new artisanal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListOptionUser"), List(("cc1", "String"), ("cc2", "List[String]"), ("cc3", "Option[String]"), ("cc4", "Option[List[MyRecord_User]]"), ("cc5", "List[Option[MyRecord_User]]")))

      val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_ListOptionUser]).map(ScalaSigAttributeParsers.parse(_)).get
      val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
      correctParsedSig.toString === myParsedSig.toString
    }
  }



}

