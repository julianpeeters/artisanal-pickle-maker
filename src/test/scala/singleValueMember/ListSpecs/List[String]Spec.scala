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



class ListStringSpec extends mutable.Specification {



  "a ScalaSig for case class MyRecord_ListString(pp: List[String])" should {
    "have the correct string" in {


  val mySig = new artisanal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListString"), List(("pp", "List[String]")))

    val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_ListString]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
    correctParsedSig.toString === myParsedSig.toString
    }
  }



}

