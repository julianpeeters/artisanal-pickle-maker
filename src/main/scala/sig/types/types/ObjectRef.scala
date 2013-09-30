package avocet 
package types
import tags._
import scala.reflect.generic._


case class TypeRefTpe_Object(thisTpe_scala: ThisTpe_scala, thisTpe_lang: ThisTpe_lang, lang: ExtModClassRef_lang, java: ExtModClassRef_java) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 6).writeEntry(myPickleBuffer)
    thisTpe_lang.write(myPickleBuffer)
    lang.write(myPickleBuffer)
    TermName("lang").write(myPickleBuffer)
    java.write(myPickleBuffer)
    TermName("java").write(myPickleBuffer)
    ExtRef_nested(Position.current + 1, lang.position).write(myPickleBuffer)
    TypeName("Object").write(myPickleBuffer)
  }
}
case class TypeRefTpe_ObjectReadResolve(thisTpe_javaLang: ThisTpe_javaLang, lang: ExtModClassRef_lang) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_nonGeneric(thisTpe_javaLang.position, Position.current + 1).writeEntry(myPickleBuffer)
    ExtRef_nested(Position.current + 1, lang.position).write(myPickleBuffer)
    TypeName("Object").write(myPickleBuffer)
  }
}
