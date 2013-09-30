package avocet
//import models._
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled
import java.util.Arrays
import java.io.{PrintStream, File}

 
case class M()
object ArtisinalPickleMaker extends App {
//first, output what I know to be a correct scala signature
  val correctBytes: Array[Byte] = {
    val scalaSigAnnot = classOf[M].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes.getBytes
    val len           = ByteCodecs.decode(encodedBytes)

    Arrays.copyOf(encodedBytes, len)
  }
 // val pickleBuffer = new PickleBuffer(bytes, 0, bytes.length)
  //val p = new PrintStream(new File("output/ShowPickled.MyRecord_AnyAny"))
 // ShowPickled.printFile(pickleBuffer, p)
//


  //val mySig = new ScalaSig(List("models", "MyRecord"), List(("x", "String")))

 // val mySig = new ScalaSig(List("models", "MyRecord_Byte"), List(("a", "Byte")))
 // val mySig_Short = new ScalaSig(buf_Short, pos_Short, List("models", "MyRecord_Short"), List(("c", "Int")))
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord"), List(("x", "String"), ("y", "Int"), ("z", "Boolean")))
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
mySig.bytes.take(5).foreach(println)
println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=")
//(new String(ByteCodecs.encode(mySig.bytes))).foreach(println)

//val arrays = (0 to 150).map(n=>n.toByte).map((Array[Byte](_)))//.foreach(_.foreach(println))
val testbyte = Array[Byte](127)
val testencoded = ByteCodecs.encode(testbyte)
testencoded.foreach(println)
val str = new String(testencoded, "ISO-8859-1")
val s = testencoded.mkString
//val strUni = new String(testencoded, "Unicode")
//val strUTF8 = new String(testencoded, "UTF-8")
println(str)
//println(strUni)
//println(strUTF8)
//println(str == strUni)

val testdec = Arrays.copyOf(str.getBytes, ByteCodecs.decode(str.getBytes))//.foreach(println)
println("str")
testdec.foreach(println)


val testdecoded = Arrays.copyOf(testencoded, ByteCodecs.decode(testencoded))//.foreach(println)
//println(testbyte)
println("break")
testdecoded.foreach(println)
val encoded = ByteCodecs.encode(mySig.bytes)//
//encoded.foreach(println)
val bytes = Arrays.copyOf(encoded, ByteCodecs.decode(encoded))//.foreach(println)
//bytes.foreach(println)

///view results
  val pickleBuffer = new PickleBuffer(correctBytes, 0, correctBytes.length)
  val ps = new PrintStream(new File("output/ShowPickled.MyRecord_StringIntBoolean"))
  ShowPickled.printFile(pickleBuffer, ps)

  //val myPickleBuffer = new PickleBuffer(mySig.bytes, 0, mySig.bytes.length-1)
  //val myPs = new PrintStream(new File("output/ShowPickled.myPickleBuffer"))

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


