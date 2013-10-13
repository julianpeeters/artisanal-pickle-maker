package avocet

import models._
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled
import java.util.Arrays
import java.io.{PrintStream, File}

import scala.tools.scalap.scalax.rules.scalasig._


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


  //val mySig = new ScalaSig(List("models", "MyRecord"), List(("x", "String")))

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
val stringintbool = "\u0006\u0001\u0005\rc\u0001B\u0001\u0003\u0001\u0016\u0011\u0001\"T=SK\u000e|'\u000f\u001a\u0006\u0002\u0007\u00051Qn\u001c3fYN\u001c\u0001a\u0005\u0003\u0001\r1y\u0001CA\u0004\u000b\u001b\u0005A!\"A\u0005\u0002\u000bM\u001c\u0017\r\\1\n\u0005-A!AB!osJ+g\r\u0005\u0002\u0008\u001b%\u0011a\u0002\u0003\u0002\u0008!J|G-^2u!\u00099\u0001#\u0003\u0002\u0012\u0011\u0009a1+\u001a:jC2L'0\u00192mK\"A1\u0003\u0001BK\u0002\u0013\u0005A#A\u0001y+\u0005)\u0002C\u0001\u000c\u001a\u001d\u00099q#\u0003\u0002\u0019\u0011\u00051\u0001K]3eK\u001aL!AG\u000e\u0003\rM#(/\u001b8h\u0015\u0009A\u0002\u0002\u0003\u0005\u001e\u0001\u0009E\u0009\u0015!\u0003\u0016\u0003\u0009A\u0008\u0005\u0003\u0005 \u0001\u0009U\r\u0011\"\u0001!\u0003\u0005IX#A\u0011\u0011\u0005\u001d\u0011\u0013BA\u0012\u0009\u0005\rIe\u000e\u001e\u0005\u0009K\u0001\u0011\u0009\u0012)A\u0005C\u0005\u0011\u0011\u0010\u0009\u0005\u0009O\u0001\u0011)\u001a!C\u0001Q\u0005\u0009!0F\u0001*!\u00099!&\u0003\u0002,\u0011\u00099!i\\8mK\u0006t\u0007\u0002C\u0017\u0001\u0005#\u0005\u000b\u0011B\u0015\u0002\u0005i\u0004\u0003\"B\u0018\u0001\u0009\u0003\u0001\u0014A\u0002\u001fj]&$h\u0008\u0006\u00032gQ*\u0004C\u0001\u001a\u0001\u001b\u0005\u0011\u0001\"B\n/\u0001\u0004)\u0002\"B\u0010/\u0001\u0004\u0009\u0003\"B\u0014/\u0001\u0004I\u0003bB\u001c\u0001\u0003\u0003%\u0009\u0001O\u0001\u0005G>\u0004\u0018\u0010\u0006\u00032siZ\u0004bB\n7!\u0003\u0005\r!\u0006\u0005\u0008?Y\u0002\n\u00111\u0001\"\u0011\u001d9c\u0007%AA\u0002%Bq!\u0010\u0001\u0012\u0002\u0013\u0005a(\u0001\u0008d_BLH\u0005Z3gCVdG\u000fJ\u0019\u0016\u0003}R#!\u0006!,\u0003\u0005\u0003\"AQ$\u000e\u0003\rS!\u0001R#\u0002\u0013Ut7\r[3dW\u0016$'B\u0001$\u0009\u0003)\u0009gN\\8uCRLwN\\\u0005\u0003\u0011\u000e\u0013\u0011#\u001e8dQ\u0016\u001c7.\u001a3WCJL\u0017M\\2f\u0011\u001dQ\u0005!%A\u0005\u0002-\u000babY8qs\u0012\"WMZ1vYR$#'F\u0001MU\u0009\u0009\u0003\u0009C\u0004O\u0001E\u0005I\u0011A(\u0002\u001d\r|\u0007/\u001f\u0013eK\u001a\u000cW\u000f\u001c;%gU\u0009\u0001K\u000b\u0002*\u0001\"9!\u000bAA\u0001\n\u0003\u001a\u0016!\u00049s_\u0012,8\r\u001e)sK\u001aL\u00070F\u0001U!\u0009)&,D\u0001W\u0015\u00099\u0006,\u0001\u0003mC:<'\"A-\u0002\u0009)\u000cg/Y\u0005\u00035YCq\u0001\u0018\u0001\u0002\u0002\u0013\u0005\u0001%\u0001\u0007qe>$Wo\u0019;Be&$\u0018\u0010C\u0004_\u0001\u0005\u0005I\u0011A0\u0002\u001dA\u0014x\u000eZ;di\u0016cW-\\3oiR\u0011\u0001m\u0019\u0009\u0003\u000f\u0005L!A\u0019\u0005\u0003\u0007\u0005s\u0017\u0010C\u0004e;\u0006\u0005\u0009\u0019A\u0011\u0002\u0007a$\u0013\u0007C\u0004g\u0001\u0005\u0005I\u0011I4\u0002\u001fA\u0014x\u000eZ;di&#XM]1u_J,\u0012\u0001\u001b\u0009\u0004S2\u0004W\"\u00016\u000b\u0005-D\u0011AC2pY2,7\r^5p]&\u0011QN\u001b\u0002\u0009\u0013R,'/\u0019;pe\"9q\u000eAA\u0001\n\u0003\u0001\u0018\u0001C2b]\u0016\u000bX/\u00197\u0015\u0005%\n\u0008b\u00023o\u0003\u0003\u0005\r\u0001\u0019\u0005\u0008g\u0002\u0009\u0009\u0011\"\u0011u\u0003!A\u0017m\u001d5D_\u0012,G#A\u0011\u0009\u000fY\u0004\u0011\u0011!C!o\u0006AAo\\*ue&tw\rF\u0001U\u0011\u001dI\u0008!!A\u0005Bi\u000ca!Z9vC2\u001cHCA\u0015|\u0011\u001d!\u00070!AA\u0002\u0001<q! \u0002\u0002\u0002#\u0005a0\u0001\u0005NsJ+7m\u001c:e!\u0009\u0011tP\u0002\u0005\u0002\u0005\u0005\u0005\u0009\u0012AA\u0001'\u0011y\u00181A\u0008\u0011\u0011\u0005\u0015\u00111B\u000b\"SEj!!a\u0002\u000b\u0007\u0005%\u0001\"A\u0004sk:$\u0018.\\3\n\u0009\u00055\u0011q\u0001\u0002\u0012\u0003\n\u001cHO]1di\u001a+hn\u0019;j_:\u001c\u0004BB\u0018\u0000\u0009\u0003\u0009\u0009\u0002F\u0001\u0011\u001d1x0!A\u0005F]D\u0011\"a\u0006\u0000\u0003\u0003%\u0009)!\u0007\u0002\u000b\u0005\u0004\u0008\u000f\\=\u0015\u000fE\nY\"!\u0008\u0002 !11#!\u0006A\u0002UAaaHA\u000b\u0001\u0004\u0009\u0003BB\u0014\u0002\u0016\u0001\u0007\u0011\u0006C\u0005\u0002$}\u000c\u0009\u0011\"!\u0002&\u00059QO\\1qa2LH\u0003BA\u0014\u0003g\u0001RaBA\u0015\u0003[I1!a\u000b\u0009\u0005\u0019y\u0005\u000f^5p]B1q!a\u000c\u0016C%J1!!\r\u0009\u0005\u0019!V\u000f\u001d7fg!I\u0011QGA\u0011\u0003\u0003\u0005\r!M\u0001\u0004q\u0012\u0002\u0004\"CA\u001d\u0006\u0005I\u0011BA\u001e\u0003-\u0011X-\u00193SKN|GN^3\u0015\u0005\u0005u\u0002cA+\u0002@%\u0019\u0011\u0011\u0009,\u0003\r=\u0013'.Z2u\u0001"


val intint = "\u0006\u0001\u0005ea\u0001B\u0001\u0003\u0001\u0016\u0011\u0001\"T=SK\u000e|'\u000f\u001a\u0006\u0002\u0007\u00051Qn\u001c3fYN\u001c\u0001a\u0005\u0003\u0001\r1y\u0001CA\u0004\u000b\u001b\u0005A!\"A\u0005\u0002\u000bM\u001c\u0017\r\\1\n\u0005-A!AB!osJ+g\r\u0005\u0002\u0008\u001b%\u0011a\u0002\u0003\u0002\u0008!J|G-^2u!\u00099\u0001#\u0003\u0002\u0012\u0011\u0009a1+\u001a:jC2L'0\u00192mK\"A1\u0003\u0001BK\u0002\u0013\u0005A#A\u0001y+\u0005)\u0002CA\u0004\u0017\u0013\u00099\u0002BA\u0002J]RD\u0001\"\u0007\u0001\u0003\u0012\u0003\u0006I!F\u0001\u0003q\u0002B\u0001b\u0007\u0001\u0003\u0016\u0004%\u0009\u0001F\u0001\u0002s\"AQ\u0004\u0001B\u0009B\u0003%Q#\u0001\u0002zA!)q\u0004\u0001C\u0001A\u00051A(\u001b8jiz\"2!I\u0012%!\u0009\u0011\u0003!D\u0001\u0003\u0011\u0015\u0019b\u00041\u0001\u0016\u0011\u0015Yb\u00041\u0001\u0016\u0011\u001d1\u0003!!A\u0005\u0002\u001d\nAaY8qsR\u0019\u0011\u0005K\u0015\u0009\u000fM)\u0003\u0013!a\u0001+!91$\nI\u0001\u0002\u0004)\u0002bB\u0016\u0001#\u0003%\u0009\u0001L\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00132+\u0005i#FA\u000b/W\u0005y\u0003C\u0001\u00196\u001b\u0005\u0009$B\u0001\u001a4\u0003%)hn\u00195fG.,GM\u0003\u00025\u0011\u0005Q\u0011M\u001c8pi\u0006$\u0018n\u001c8\n\u0005Y\n$!E;oG\",7m[3e-\u0006\u0014\u0018.\u00198dK\"9\u0001\u0008AI\u0001\n\u0003a\u0013AD2paf$C-\u001a4bk2$HE\r\u0005\u0008u\u0001\u0009\u0009\u0011\"\u0011<\u00035\u0001(o\u001c3vGR\u0004&/\u001a4jqV\u0009A\u0008\u0005\u0002>\u00056\u0009aH\u0003\u0002@\u0001\u0006!A.\u00198h\u0015\u0005\u0009\u0015\u0001\u00026bm\u0006L!a\u0011 \u0003\rM#(/\u001b8h\u0011\u001d)\u0005!!A\u0005\u0002Q\u0009A\u0002\u001d:pIV\u001cG/\u0011:jifDqa\u0012\u0001\u0002\u0002\u0013\u0005\u0001*\u0001\u0008qe>$Wo\u0019;FY\u0016lWM\u001c;\u0015\u0005%c\u0005CA\u0004K\u0013\u0009Y\u0005BA\u0002B]fDq!\u0014$\u0002\u0002\u0003\u0007Q#A\u0002yIEBqa\u0014\u0001\u0002\u0002\u0013\u0005\u0003+A\u0008qe>$Wo\u0019;Ji\u0016\u0014\u0018\r^8s+\u0005\u0009\u0006c\u0001*V\u00136\u00091K\u0003\u0002U\u0011\u0005Q1m\u001c7mK\u000e$\u0018n\u001c8\n\u0005Y\u001b&\u0001C%uKJ\u000cGo\u001c:\u0009\u000fa\u0003\u0011\u0011!C\u00013\u0006A1-\u00198FcV\u000cG\u000e\u0006\u0002[;B\u0011qaW\u0005\u00039\"\u0011qAQ8pY\u0016\u000cg\u000eC\u0004N/\u0006\u0005\u0009\u0019A%\u0009\u000f}\u0003\u0011\u0011!C!A\u0006A\u0001.Y:i\u0007>$W\rF\u0001\u0016\u0011\u001d\u0011\u0007!!A\u0005B\r\u000c\u0001\u0002^8TiJLgn\u001a\u000b\u0002y!9Q\rAA\u0001\n\u00032\u0017AB3rk\u0006d7\u000f\u0006\u0002[O\"9Q\nZA\u0001\u0002\u0004IuaB5\u0003\u0003\u0003E\u0009A[\u0001\u0009\u001bf\u0014VmY8sIB\u0011!e\u001b\u0004\u0008\u0003\u0009\u0009\u0009\u0011#\u0001m'\rYWn\u0004\u0009\u0006]F,R#I\u0007\u0002_*\u0011\u0001\u000fC\u0001\u0008eVtG/[7f\u0013\u0009\u0011xNA\u0009BEN$(/Y2u\rVt7\r^5p]JBQaH6\u0005\u0002Q$\u0012A\u001b\u0005\u0008E.\u000c\u0009\u0011\"\u0012d\u0011\u001d98.!A\u0005\u0002b\u000cQ!\u00199qYf$2!I={\u0011\u0015\u0019b\u000f1\u0001\u0016\u0011\u0015Yb\u000f1\u0001\u0016\u0011\u001da8.!A\u0005\u0002v\u000cq!\u001e8baBd\u0017\u0010F\u0002\u0003\u0013\u0001BaB@\u0002\u0004%\u0019\u0011\u0011\u0001\u0005\u0003\r=\u0003H/[8o!\u00159\u0011QA\u000b\u0016\u0013\r\u00099\u0001\u0003\u0002\u0007)V\u0004H.\u001a\u001a\u0009\u0011\u0005-10!AA\u0002\u0005\n1\u0001\u001f\u00131\u0011%\u0009ya[A\u0001\n\u0013\u0009\u0009\"A\u0006sK\u0006$'+Z:pYZ,GCAA\n!\ri\u0014QC\u0005\u0004\u0003/q$AB(cU\u0016\u001cG\u000f"
  val correctSig: String = {
    val scalaSigAnnot = classOf[MyRecord_Int].getAnnotation(classOf[scala.reflect.ScalaSignature])
    val encodedBytes  = scalaSigAnnot.bytes
    encodedBytes
  }

val correctBytes = correctSig.getBytes("UTF-8")
val dup = correctSig.getBytes("UTF-8")
//val correctBytes = intint.getBytes("UTF-8")
val correctLength = ByteCodecs.decode(correctBytes)
val correctArray = Arrays.copyOf(correctBytes, correctLength)
val reBytes = ByteCodecs.encode(correctArray)
val reSig =  (new String(reBytes, "UTF-8"))//.dropRight(1)
//correctSig.foreach(println)
println(reBytes.length)//
println(correctBytes.length)
//reBytes.diff(correctBytes).foreach(println)
println(reSig.length)//
println(correctSig.length)
println(correctArray.length)
//dup.foreach(println)
//reBytes.diff(dup).foreach(println)
println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
//reBytes.foreach(println)
 // val mySig = new ScalaSig(List("case class"), List("models", "MyRecord"), List(("c", "Int"), ("c", "Int"))).bytes
  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord_Int"), List(("c", "Int"))).bytes
//val sig = classOf[MyRecord_Int].getAnnotation(classOf[ScalaSignature]).bytes
//val correctLen = ByteCodecs.decode(correctSig.getBytes("UTF-8"))
val myBytes = mySig.getBytes("UTF-8")
val myLength = ByteCodecs.decode(myBytes)
val myArray = Arrays.copyOf(myBytes, myLength)
//correctBytes.take(5).foreach(println)








//view results

 // val pickleBuffer = new PickleBuffer(correctSig.getBytes, 0, correctSig.length)
 // val ps = new PrintStream(new File("output/ShowPickled.MyRecord_StringIntBoolean"))
 // ShowPickled.printFile(pickleBuffer, ps)

 // val myPickleBuffer = new PickleBuffer(mySig.debug, 0, mySig.debug.length)
 // val myPs = new PrintStream(new File("output/ShowPickled.myPickleBuffer"))

  //ShowPickled.printFile(myPickleBuffer, myPs)


//myBytes.foreach(println)
println(mySig == correctSig)
//mySig.diff(correctSig).foreach(println)

println(myBytes.sameElements(correctBytes))
//myBytes.diff(correctBytes).foreach(println)
//correctBytes.diff(myBytes).foreach(println)

println(myLength == correctLength)
println(correctLength)
println(myLength)
println(correctArray.sameElements(myArray.dropRight(1)))
println(mySig.length)
reSig.diff(mySig).foreach(println)
//myArray.diff(correctArray).foreach(println)
//correctArray.diff(myArray).foreach(println)

//val scalaSig = ScalaSigParser.parse(classOf[MyRecord_Int])
 // println(scalaSig)
}

//case class R(x: String)
