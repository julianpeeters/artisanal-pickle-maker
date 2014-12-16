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



class ListStringListStringStringSpec extends mutable.Specification {


  "a ScalaSig for case class MyRecord_ListStringListStringListString(lss1: List[String], lss2: List[String], lss3: String)" should {
    "have the correct string" in {

  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ListStringListStringString"), List(("lss1", "List[String]"), ("lss2", "List[String]"), ("lss3", "String")))
    val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_ListStringListStringString]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
    correctParsedSig.toString === myParsedSig.toString
    }
  }

}

