package avocet
import scala.reflect.internal.pickling._
import PickleFormat._


case class SigHeader {
  val hB = new HB
//write version
  //Version
    hB.headerBuffer.writeNat(PickleFormat.MajorVersion)
    hB.headerBuffer.writeNat(PickleFormat.MinorVersion)

//write # of entries
    hB.headerBuffer.writeNat(Position.current)

    val bytes = if (Position.current > 127) hB.headerBuffer.bytes.take(4); else hB.headerBuffer.bytes.take(3)
}
