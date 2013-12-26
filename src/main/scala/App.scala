

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

 // val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListStringListString"), List(("p1", "List[String]"), ("p2", "List[String]")))
 // val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListIntListInt"), List(("pi1", "List[Int]"), ("pi2", "List[Int]")))

//val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_OptionListUserListUser"), List(("oa1", "Option[List[MyRecord_User]]"), ("oa2", "List[MyRecord_User]")))

  //val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_OptionString"), List(("oa", "Option[String]")))
 // val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_StringOptionString"), List(("oa1", "String"), ("oa2", "Option[String]")))

  //val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_OptionStringOptionInt"), List(("oc1", "Option[String]"), ("oc2", "Option[Int]")))

val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_UserOptionUser"), List(("oc1", "MyRecord_User"), ("oc2", "Option[MyRecord_User]")))

//  val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_OptionListIntListOptionInt"), List(("oa1", "Option[List[Int]]"), ("oa2", "List[Option[Int]]")))


  //val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_OptionListUserListUser"), List(("oa1", "Option[List[MyRecord_User]]"), ("oa2", "List[MyRecord_User]")))

//val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListOptionUser"), List(("oa", "List[Option[MyRecord_User]]")))

 // val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListOptionUser"), List(  ("cc3", "Option[String]"), ("cc4", "Option[List[MyRecord_User]"), ("cc5", "List[Option[MyRecord_User]]")))


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


    val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_UserOptionUser]).map(ScalaSigAttributeParsers.parse(_)).get
//    val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_StringListStringUserListUser]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get

println(correctParsedSig)
println("+++++++++++++++++++++++++++")
println(myParsedSig)
//println("DIFFFF" + myParsedSig.toString.diff(correctParsedSig.toString))
 
   println( correctParsedSig.toString == myParsedSig.toString)

}

