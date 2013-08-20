package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.internal.pickling._

case class ProductPrefix(myPickleBuffer: PickleBuffer, javaLangString: TypeRefTpe_javaLangString, thisTpe_javaLang: ThisTpe_javaLang, String: TypeRefTpe_String, lang: ExtModClassRef_lang, java: ExtModClassRef_java) {
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write(myPickleBuffer)
  TermName("productPrefix").write(myPickleBuffer)
  PolyTpe(javaLangString).write(myPickleBuffer)
  javaLangString.write(myPickleBuffer)
  thisTpe_javaLang.write(myPickleBuffer)
  lang.write(myPickleBuffer)
  TermName("lang").write(myPickleBuffer)
  java.write(myPickleBuffer)
  TermName("java").write(myPickleBuffer)
  String.typeNamePosition match {
    case 0      => ExtRef_nested(Position.current + 1, lang.position).write(myPickleBuffer); TypeName("String").write(myPickleBuffer)
    case i: Int => ExtRef_nested(String.typeNamePosition, lang.position).write(myPickleBuffer)
  }
}
