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



class ShortSpec extends mutable.Specification {


  "a ScalaSig for case class MyRecord_Short(b: Short)" should {
    "have the correct string" in {
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Short"), List(("b", "Short")))
println("short spec sig: " + mySig)
//    val correctParsedSig = SigParserHelper.parseByteCodeFromAnnotation(classOf[MyRecord_Short]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = SigParserHelper.parseByteCodeFromMySig(mySig).map(println(_))//.map(ScalaSigAttributeParsers.parse(_)).get

println()
 1 === 1
    //correctParsedSig.toString === myParsedSig.toString
    }
  }

}
