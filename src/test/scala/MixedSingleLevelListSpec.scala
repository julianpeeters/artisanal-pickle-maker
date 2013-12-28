package artisanal.pickle.maker 
import models._

import org.specs2._
import mutable._
import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature



class StringListStringUserListUserSpec extends mutable.Specification {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_StringListStringUserListUser"), List(("mmm1", "String"), ("mmm2", "List[String]"), ("mmm3", "MyRec"), ("mmm4", "List[MyRec]"), ("mmm5", "MyRecord_User"), ("mmm6", "List[MyRecord_UserUser]")))
  def parseByteCodeFromAnnotation(clazz: Class[_]): Option[ByteCode] = {
    clazz.annotation[ScalaSignature] match {
      case Some(sig) if sig != null => {
        val bytes = sig.bytes.getBytes("UTF-8")
        val len = ByteCodecs.decode(bytes)
        Option(ByteCode(bytes.take(len)))
      }
      case _ => None
    }
  }

  def parseByteCodeFromMySig(sig: ScalaSig): Option[ByteCode] = {
    val bytes = sig.bytes.getBytes("UTF-8")
    val len = ByteCodecs.decode(bytes)
    Option(ByteCode(bytes.take(len)))   
  }

  "a ScalaSig for case class MyRecord_StringListStringUserListUser(mmm1: String, mmm2: List[String], mmm3: MyRec, mmm4: List[MyRec], mmm5: MyRecord_User, mmm6: List[MyRecord_UserUser])" should {
    "have the correct string" in {
    val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_StringListStringUserListUser]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get
    correctParsedSig.toString === myParsedSig.toString
    }
  }

}

