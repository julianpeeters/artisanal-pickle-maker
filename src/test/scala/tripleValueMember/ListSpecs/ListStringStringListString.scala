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



class ListStringStringListStringSpec extends mutable.Specification {


  "a ScalaSig for case class MyRecord_ListStringStringListString(lsl1: List[String], lsl2: String, lsl3: List[String])" should {
    "have the correct string" in {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ListStringStringListString"), List(("lsl1", "List[String]"), ("lsl2", "String"), ("lsl3", "List[String]")))
    val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_ListStringStringListString]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
    correctParsedSig.toString === myParsedSig.toString
    }
  }

}

