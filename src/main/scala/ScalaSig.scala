package avocet
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._

//takes a List of flags,  a list of class names, and a list of value member names and types
class ScalaSig(flags: List[String], names: List[String], args: List[(String, String)]) {

//set up resources to supply us with the named objects we'll use to make sig entries
  val sigResources = new SigResources

//write entries
  val entries = new Entries(sigResources, flags, names, args)

//after writing entries, how many were written?
  val entriesNumber = Position.current

// get the bytes, trimming the excess 0s but leaving one 0. Header written last so we know # entries
  val bytes = Array.concat(SigHeader().bytes, sigResources.myPickleBuffer.bytes).reverse.dropWhile(b => b == 0).reverse:+(0.toByte)

//reset position keeper
  Position.current = 0
}
