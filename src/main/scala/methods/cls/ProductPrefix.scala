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
package methods
package cls
import stores._
import tags._
import types._
import scala.reflect.internal.pickling._

case class ProductPrefix(position: Position, stores: Stores, classSym: ClassSym, sigResources: SigResources) {

  val valSymPosition = position.current
  ValSym(position, position.current + 1, classSym.position, 2097696L, position.current + 2).write(sigResources.myPickleBuffer)
  TermName(position, "productPrefix").write(sigResources.myPickleBuffer)
  PolyTpe(position, sigResources.typeRefTpes.javaLangString).write(sigResources.myPickleBuffer)
  sigResources.thisTpes.lang.position match {
    case 0 => { //if a java type hasn't been used as a value member's type, then write the full type name
      sigResources.typeRefTpes.javaLangString.write(sigResources.myPickleBuffer)
      sigResources.thisTpes.javaLang.write(position, stores, sigResources.myPickleBuffer)
      sigResources.extModClassRefs.lang.write(position, sigResources.myPickleBuffer)
      TermName(position, "lang").write(sigResources.myPickleBuffer)
      sigResources.extModClassRefs.java.write(position, stores, "java", sigResources.myPickleBuffer)
      TermName(position, "java").write(sigResources.myPickleBuffer)
    }
    case i: Int => {// if a java type has been written already, reference that thisTpe_javaLang position
      sigResources.typeRefTpes.javaLangString.write(sigResources.myPickleBuffer)
    }
  }
  sigResources.typeRefTpes.string.typeNamePosition match {
    case 0      => ExtRef_nested(position, position.current + 1, sigResources.extModClassRefs.lang.position).write(sigResources.myPickleBuffer); TypeName(position, "String").write(sigResources.myPickleBuffer)
    case i: Int => ExtRef_nested(position, sigResources.typeRefTpes.string.typeNamePosition, sigResources.extModClassRefs.lang.position).write(sigResources.myPickleBuffer)
  }
}
