package avocet
import models._
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled
import java.util.Arrays
import java.io.{PrintStream, File}

class dd{println("Hello World")}

object ArtisinalPickleMaker extends App {
//first, output what I know to be a correct scala signature
  val bytes: Array[Byte] = {
    val scalaSigAnnot = classOf[MyRecord_AnyAny].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)

    Arrays.copyOf(encodedBytes, len)
  }
  val pickleBuffer = new PickleBuffer(bytes, 0, bytes.length)
  val p = new PrintStream(new File("output/ShowPickled.MyRecord_AnyAny"))
  ShowPickled.printFile(pickleBuffer, p)
//


  //val mySig = new ScalaSig(List("models", "MyRecord"), List(("x", "String")))

 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig_Short = new ScalaSig(buf_Short, pos_Short, List("models", "MyRecord_Short"), List(("c", "Int")))
  val mySig_ByteByte = new ScalaSig(List("case class"), List("models", "MyRecord_AnyAny"), List(("m1", "Any"), ("m2", "Any")))
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
/*
//A "collector" PickleBuffer is used to collect the bytes of the sig we made so we can display it
  val myPickleBuffer_ByteByte = new PickleBuffer(mySig_ByteByte.bytes, 0, mySig_ByteByte.bytes.length-1)
  val ps_ByteByte = new PrintStream(new File("output/ShowPickled.myPickleBuffer_AnyAny"))

  ShowPickled.printFile(myPickleBuffer_ByteByte, ps_ByteByte)
*/
/*
  val myPickleBuffer = new PickleBuffer(mySig.bytes, 0, mySig.bytes.length)
  val ps = new PrintStream(new File("output/ShowPickled.myPickleBuffer"))

  ShowPickled.printFile(myPickleBuffer, ps)

*/


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


