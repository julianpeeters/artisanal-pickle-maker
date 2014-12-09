import artisanal.pickle.maker.parser._

import org.specs2._
import mutable._
import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature

case class MyRec(x: Int)
case class MyRecord_NoNamespaceUserNoNamespace(myRec: MyRec)


class NoNamespaceUserNoNamespaceSpec extends mutable.Specification {

  "a ScalaSig for case class MyRecord_User(myRec: MyRec)" should {
    "have the correct string" in {

      val mySig = new artisanal.pickle.maker.ScalaSig(List("case class"), List("<empty>", "MyRecord_NoNamespaceUserNoNamespace"), List(("myRec", "MyRec")))

      val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_NoNamespaceUserNoNamespace]).map(ScalaSigAttributeParsers.parse(_)).get
     // val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig)//.map(ScalaSigAttributeParsers.parse(_)).get
      correctParsedSig.toString === 1//myParsedSig.toString
    }
  }

}

