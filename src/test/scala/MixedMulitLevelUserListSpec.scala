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



class MixedMulitLevelUserListSpec extends mutable.Specification {

  "a ScalaSig for case class MyRecord_MixedMulitLevelUserList(s1: List[List[String]], s2: String, s3: List[MyRecord_User], s4: MyRecord_User, s5: List[List[List[List[Object]]]])" should {
    "have the correct string" in {

      val mySig = new artisanal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_MixedMulitLevelUserList"), List(("s1", "List[List[String]]"), ("s2", "String"), ("s3", "List[MyRecord_User]"), ("s4", "MyRecord_User"), ("s5", "List[List[List[List[Object]]]]")))

      val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_MixedMulitLevelUserList]).map(ScalaSigAttributeParsers.parse(_)).get
      val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get

      correctParsedSig.toString === myParsedSig.toString
    }
  }



}

