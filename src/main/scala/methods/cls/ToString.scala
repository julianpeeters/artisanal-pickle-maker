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

case class ToString(position: Position, classSym: ClassSym, myPickleBuffer: PickleBuffer, javaLangString: TypeRefTpe_javaLangString) {
  val valSymPosition = position.current
  ValSym(position, position.current + 1, classSym.position, 2097696L, position.current + 2).write(myPickleBuffer)

  val termNamePosition = position.current
  TermName(position, "toString").write(myPickleBuffer)

  val MethodTpePosition = position.current
  MethodTpe(position, List(javaLangString.position)).write(myPickleBuffer)
}
