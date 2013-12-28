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

import tags._
import types._
import scala.reflect.internal.pickling._

case class ProductPrefix(sigResources: SigResources) {

  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097696L, Position.current + 2).write(sigResources.myPickleBuffer)
  TermName("productPrefix").write(sigResources.myPickleBuffer)
  PolyTpe(sigResources.typeRefTpes.javaLangString).write(sigResources.myPickleBuffer)
  sigResources.thisTpes.lang.position match {
    case 0 => { //if a java type hasn't been used as a value member's type, then write the full type name
      sigResources.typeRefTpes.javaLangString.write(sigResources.myPickleBuffer)
      sigResources.thisTpes.javaLang.write(sigResources.myPickleBuffer)
      sigResources.extModClassRefs.lang.write(sigResources.myPickleBuffer)
      TermName("lang").write(sigResources.myPickleBuffer)
      sigResources.extModClassRefs.java.write(sigResources.myPickleBuffer)
      TermName("java").write(sigResources.myPickleBuffer)
    }
    case i: Int => {// if a java type has been written already, reference that thisTpe_javaLang position
      sigResources.typeRefTpes.javaLangString.write(sigResources.myPickleBuffer)
    }
  }
  sigResources.typeRefTpes.string.typeNamePosition match {
    case 0      => ExtRef_nested(Position.current + 1, sigResources.extModClassRefs.lang.position).write(sigResources.myPickleBuffer); TypeName("String").write(sigResources.myPickleBuffer)
    case i: Int => ExtRef_nested(sigResources.typeRefTpes.string.typeNamePosition, sigResources.extModClassRefs.lang.position).write(sigResources.myPickleBuffer)
  }
}
