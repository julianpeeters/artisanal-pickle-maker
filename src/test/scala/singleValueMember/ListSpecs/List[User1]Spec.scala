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



class ListUser1Spec extends mutable.Specification {




  "a ScalaSig for case class MyRecord_ListUser1(ae: List[MyRec])" should {
    "have the correct string" in {

  val mySig = new artisanal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListUser1"), List(("ae", "List[MyRec]")))

    val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_ListUser1]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
    correctParsedSig.toString === myParsedSig.toString
    }
  }



}

