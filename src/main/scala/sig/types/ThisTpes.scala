package avocet
import methods.cls._
import methods.module._
import scala.reflect.generic._

import tags._
import types._

class ThisTpes {
  val owner = ThisTpe_owner()
  val scala = ThisTpe_scala()
  val lang = ThisTpe_lang()
  val javaLang = ThisTpe_javaLang()
  val collection = ThisTpe_collection()
  val runtime = ThisTpe_runtime()
}


