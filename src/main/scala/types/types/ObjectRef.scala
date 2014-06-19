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


case class TypeRefTpe_Object(thisTpe_scala: ThisTpe_scala, thisTpe_lang: ThisTpe_lang, lang: ExtModClassRef_lang, java: ExtModClassRef_java) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0

  val typeName = "Object"

  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 6).writeEntry(myPickleBuffer)
    thisTpe_lang.write(myPickleBuffer)
    lang.write(myPickleBuffer)
    TermName("lang").write(myPickleBuffer)
    java.write("java", myPickleBuffer)
    TermName("java").write(myPickleBuffer)
    ExtRef_nested(Position.current + 1, lang.position).write(myPickleBuffer)
    TypeName("Object").write(myPickleBuffer)
  }
}
case class TypeRefTpe_ObjectReadResolve(thisTpe_javaLang: ThisTpe_javaLang, lang: ExtModClassRef_lang) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0

  val typeName = "ObjectReadResolve"

  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    TypeRefTpe_nonGeneric(thisTpe_javaLang.position, Position.current + 1).writeEntry(myPickleBuffer)
    ExtRef_nested(Position.current + 1, lang.position).write(myPickleBuffer)
    TypeName("Object").write(myPickleBuffer)
  }
}
