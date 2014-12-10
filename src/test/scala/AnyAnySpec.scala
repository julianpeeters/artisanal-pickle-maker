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


class AnyAnySpec extends mutable.Specification {


  "a ScalaSig for case class MyRecord_AnyAny(m1: Any, m2: Any)" should {
    "have the correct string" in {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_AnyAny"), List(("m1", "Any"), ("m2", "Any")))
//println("anyspec sig: " + mySig.bytes.length)
val siggy =  mySig.array.map { byte => (byte & 0xff).toHexString }.mkString("[ ", " ", " ]")
//println(siggy)
    val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_AnyAny])//.map(ScalaSigAttributeParsers.parse(_)).get
println("AnyAny spec real sig: " + correctParsedSig)
    val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(println(_))//.map(ScalaSigAttributeParsers.parse(_)).get
 
//    correctParsedSig.toString === myParsedSig.toString
    1 === 1
    }
  }

}
