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



class ListStringListIntListBooleanSpec extends mutable.Specification {

  "a ScalaSig for case class MyRecord_ListStringListStringListString(lls1: List[String], lli2: List[Int], llb3: List[Boolean])" should {
    "have the correct string" in {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_ListStringListIntListBoolean"), List(("lls1", "List[String]"), ("lli2", "List[Int]"), ("llb3", "List[Boolean]")))
    val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_ListStringListIntListBoolean]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
    correctParsedSig.toString === myParsedSig.toString
    }
  }

}

