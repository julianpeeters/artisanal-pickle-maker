package avocet

import models._
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled
import java.util.Arrays
import java.io.{PrintStream, File}

import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._ //using Salat's method for getting a sig simply to ensure this works with Salat
import scala.reflect.ScalaSignature


//for debug purposes
object ArtisinalPickleMaker extends App {

  //val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Int"), List(("c", "Int")))
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_StringIntBoolean"), List(("x", "String"), ("y", "Int"), ("z", "Boolean")))

  //val clz = classOf[MyRecord_String]
  val clz = classOf[MyRecord_StringIntBoolean]

  println("My sig and a real sig share the following traits: ")

//Compare the strings
  val correctSig = parseSigFromAnnotation(clz).get
    println("Same encoded strings: " + (correctSig == mySig.bytes).toString)
    mySig.bytes.diff(correctSig).foreach(println)//

//Compare the decoded bytes (raw, what the Pickle Buffer reads and writes)
  val myBytes = parseBytesFromMySig(mySig).get
  val correctBytes = parseBytes(classSigToBytes(clz).get).get//.dropRight(1)//.map(ScalaSigAttributeParsers.parse(_)).get
    println("Same decoded bytes  : " + (myBytes.sameElements(correctBytes)).toString)

//Compare pre-encoded array, i.e the pickle buffer output bytes before pickling(some of the real sigs have an extra "0")
  println("Same prior to encoding: " + (mySig.array).sameElements(correctBytes).toString)





//Methods for my stuff
  def parseBytesFromMySig(sig: ScalaSig): Option[Array[Byte]] = {
    val bytes = sig.bytes.getBytes("UTF-8")
    val len = ByteCodecs.decode(bytes)
    Option(bytes.take(len))
  }

//Methods for the real stuff
  def parseSigFromAnnotation(clazz: Class[_]): Option[String] = {
    clazz.annotation[ScalaSignature] match {
      case Some(sig) if sig != null => {
        val bytes = sig.bytes
        Option(bytes)
      }
      case _ => None
    }
  }

  def classSigToBytes(clazz: Class[_]): Option[Array[Byte]] = {
    clazz.annotation[ScalaSignature] match {
      case Some(sig) if sig != null => {
        val bytes = sig.bytes.getBytes("UTF-8")
        Option(bytes)
      }
      case _ => None
    }
  }

  def parseBytes(bytes: Array[Byte]): Option[Array[Byte]] = {
    val len = ByteCodecs.decode(bytes)
    Option(bytes.take(len))
  }



//view results
  val pickleBuffer = new PickleBuffer(correctBytes, 0, correctBytes.length)
  val ps = new PrintStream(new File("MyRecord.ShowPickled"))
  ShowPickled.printFile(pickleBuffer, ps)


  //val myPickleBuffer = new PickleBuffer(mySig.array, 0, mySig.array.length)  //pre-, i.e. un- ,encoded array works fine
  val myPickleBuffer = new PickleBuffer(myBytes, 0, myBytes.length)
  val myPs = new PrintStream(new File("myPickleBuffer.ShowPickled"))

 // ShowPickled.printFile(myPickleBuffer, myPs)


}

