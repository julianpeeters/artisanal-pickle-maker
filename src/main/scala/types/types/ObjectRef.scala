/*
 * Copyright 2013 Julian Peeters
 *   
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package artisanal.pickle.maker 
package types
import tags._
import scala.reflect.internal.pickling._


case class TypeRefTpe_Object(currentPosition: Position, thisTpe_scala: ThisTpe_scala, thisTpe_lang: ThisTpe_lang, lang: ExtModClassRef_lang, java: ExtModClassRef_java) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0

  val typeName = "Object"

  def write(myPickleBuffer: PickleBuffer) = {
    position = currentPosition.current
    TypeRefTpe_nonGeneric(currentPosition, currentPosition.current + 1, currentPosition.current + 6).writeEntry(myPickleBuffer)
    thisTpe_lang.write(currentPosition, myPickleBuffer)
    lang.write(currentPosition, myPickleBuffer)
    TermName(currentPosition, "lang").write(myPickleBuffer)
    java.write(currentPosition, "java", myPickleBuffer)
    TermName(currentPosition, "java").write(myPickleBuffer)
    ExtRef_nested(currentPosition, currentPosition.current + 1, lang.position).write(myPickleBuffer)
    TypeName(currentPosition, "Object").write(myPickleBuffer)
  }
}
case class TypeRefTpe_ObjectReadResolve(currentPosition: Position, thisTpe_javaLang: ThisTpe_javaLang, lang: ExtModClassRef_lang) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0

  val typeName = "ObjectReadResolve"

  def write(myPickleBuffer: PickleBuffer) = {
    position = currentPosition.current
    TypeRefTpe_nonGeneric(currentPosition, thisTpe_javaLang.position, currentPosition.current + 1).writeEntry(myPickleBuffer)
    ExtRef_nested(currentPosition, currentPosition.current + 1, lang.position).write(myPickleBuffer)
    TypeName(currentPosition, "Object").write(myPickleBuffer)
  }
}
