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



class StringOptionStringSpec extends mutable.Specification {



  "a ScalaSig for case class MyRecord_StringOptionString(oa1: String, oa2: Option[String])" should {
    "have the correct string" in {



  val mySig = new artisanal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_StringOptionString"), List(("oa1", "String"), ("oa2", "Option[String]")))

    val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_StringOptionString]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
    correctParsedSig.toString === myParsedSig.toString
    }
  }



}

