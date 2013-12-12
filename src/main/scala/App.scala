

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


  val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListStringString"), List(("po1", "List[String]"), ("po2", "String")))

  //val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListInt"), List(("po", "List[Int]")))

 //val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListStringListString"), List(("p1", "List[String]"), ("p2", "List[String]")))
 // val mySig = new artisinal.pickle.maker.ScalaSig(List("case class"), List("models", "MyRecord_ListString"), List(("x", "List[String]")))

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


    val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_ListInt]).map(ScalaSigAttributeParsers.parse(_)).get
    val myParsedSig = parseByteCodeFromMySig(mySig).map(ScalaSigAttributeParsers.parse(_)).get

println(correctParsedSig)
println("+++++++++++++++++++++++++++")
println(myParsedSig)
 
   println( correctParsedSig.toString == myParsedSig.toString)

}

