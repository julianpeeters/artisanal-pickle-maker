

import artisinal.pickle.maker 
import models._

//import org.specs2._
//mutable._
//import specification._

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature



object Main extends App {
 // val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListUserListUser"), List(("lu1", "List[MyRecord_User]"), ("lu2", "List[MyRecord_User]")))

  //val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_OptionString"), List(("oa", "Option[String]")))
 // val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_StringOptionString"), List(("oa1", "String"), ("oa2", "Option[String]")))

  val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_OptionStringOptionInt"), List(("oc1", "Option[String]"), ("oc2", "Option[Int]")))

 // val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListListString"), List(("p", "List[List[String]]")))
 // val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListIntInt"), List(("pu1", "List[Int]"), ("pu2", "Int")))

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

  def parseByteCodeFromMySig(sig: artisinal.pickle.maker.ScalaSig): Option[ByteCode] = {
    val bytes = sig.bytes.getBytes("UTF-8")
    val len = ByteCodecs.decode(bytes)
    Option(ByteCode(bytes.take(len)))   
  }


    val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_OptionStringOptionInt]).map(ScalaSigAttributeParsers.parse(_)).get
//    val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_StringListStringUserListUser]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get

println(correctParsedSig)
println("+++++++++++++++++++++++++++")
println(myParsedSig)
//println("DIFFFF" + myParsedSig.toString.diff(correctParsedSig.toString))
 
   println( correctParsedSig.toString == myParsedSig.toString)

}

