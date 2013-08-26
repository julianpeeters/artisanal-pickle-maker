
package avocet
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._

class ExtModClassRefs {
  val scala = ExtModClassRef_scala()
  val runtime = ExtModClassRef_runtime()
  val lang = ExtModClassRef_lang()
  val java = ExtModClassRef_java()
  val owner = ExtModClassRef_owner()
  val unchecked = ExtModClassRef_unchecked()
  val annotation = ExtModClassRef_annotation()
  val collection = ExtModClassRef_collection()
  val predef = ExtModClassRef_predef()
}

