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

class NothingNothingSpec extends mutable.Specification {




  "a ScalaSig for case class MyRecord_NothingNothing(l1: Nothing, l2: Nothing)" should {
    "have the correct string" in {

  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_NothingNothing"), List(("l1", "Nothing"), ("l2", "Nothing")))

    val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_NothingNothing]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
 
    correctParsedSig.toString === myParsedSig.toString
    }
  }

}
