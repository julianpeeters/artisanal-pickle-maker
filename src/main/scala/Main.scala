package avocet

import models._
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled
import java.util.Arrays
import java.io.{PrintStream, File}

import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature


//for debug purposes
object ArtisinalPickleMaker extends App {
//first, output what I know to be a correct scala signature
/*
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[myRecord].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes

    Arrays.copyOf(encodedBytes, len)
  }
*/
 // val pickleBuffer = new PickleBuffer(bytes, 0, bytes.length)
  //val p = new PrintStream(new File("output/ShowPickled.MyRecord_AnyAny"))
 // ShowPickled.printFile(pickleBuffer, p)
//


//  val mySig = new ScalaSig(List("models", "MyRecord"), List(("c", "Int")))

 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig_Short = new ScalaSig(buf_Short, pos_Short, List("models", "MyRecord_Short"), List(("c", "Int")))
//  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord"), List(("x", "String"), ("y", "Int")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Long"), List(("d", "Long")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
//println(mySig)

//println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=")

//  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Int"), List(("c", "Int")))
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord"), List(("x", "String"), ("y", "Int"), ("z", "Boolean")))
/*
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_Int].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }
*/

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

  def parseByteCodeFromMySig(sig: ScalaSig): ByteCode = {
  
        val bytes = sig.bytes.getBytes("UTF-8")
        val len = ByteCodecs.decode(bytes)
        ByteCode(bytes.take(len))
    
  }





//val correctSig = parseByteCodeFromAnnotation(classOf[MyRecord_Int]).map(ScalaSigAttributeParsers.parse(_))



val correctParsedSig = parseByteCodeFromAnnotation(classOf[MyRecord_String]).map(ScalaSigAttributeParsers.parse(_)).get
println(correctParsedSig)

val myParsedSig = parseByteCodeFromMySig(mySig)
println(myParsedSig)



///view results
/*
  val pickleBuffer = new PickleBuffer(correctBytes, 0, correctBytes.length)
  val ps = new PrintStream(new File("output/1"))
  ShowPickled.printFile(pickleBuffer, ps)
*/
//  val myPickleBuffer = new PickleBuffer(mySig.bytes, 0, mySig.bytes.length)
//  val myPs = new PrintStream(new File("output/2"))
 // ShowPickled.printFile(myPickleBuffer, myPs)


/*
 val duplicateBuffer = new PickleBuffer(bytes, 0, bytes.length)
  val index: Array[Int] = {
    val i = duplicateBuffer.createIndex
    duplicateBuffer.readIndex = 0
    i
  }
  val entryNumber = 129//an arbitrary entry to inspect
  val entryBuffer = new PickleBuffer(duplicateBuffer.toIndexedSeq(entryNumber)._2, 0, duplicateBuffer.toIndexedSeq(entryNumber)._2.length)
  entryBuffer.readNat
  entryBuffer.readNat
  println("flag: " + entryBuffer.readLongNat)
*/
}

