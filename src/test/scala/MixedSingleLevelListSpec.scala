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



class StringListStringUserListUserSpec extends mutable.Specification {


  "a ScalaSig for case class MyRecord_StringListStringUserListUser(mmm1: String, mmm2: List[String], mmm3: MyRec, mmm4: List[MyRec], mmm5: MyRecord_User, mmm6: List[MyRecord_UserUser])" should {
    "have the correct string" in {

      val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_StringListStringUserListUser"), List(("mmm1", "String"), ("mmm2", "List[String]"), ("mmm3", "MyRec"), ("mmm4", "List[MyRec]"), ("mmm5", "MyRecord_User"), ("mmm6", "List[MyRecord_UserUser]")))

      val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_StringListStringUserListUser]).map(ScalaSigAttributeParsers.parse(_)).get
      val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
      correctParsedSig.toString === myParsedSig.toString
    }
  }

}

