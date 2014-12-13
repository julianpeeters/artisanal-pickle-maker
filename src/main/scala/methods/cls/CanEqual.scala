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

import scala.reflect.internal.pickling._

import tags._
import types._

case class CanEqual(currentPosition: Position, classSym: ClassSym, myPickleBuffer: PickleBuffer, productElement: ProductElement, typeRefTpe_Boolean: TypeRefTpe_Boolean, typeRefTpe_Any: TypeRefTpe_Any) {
  val valSymPosition = currentPosition.current
  ValSym(currentPosition, currentPosition.current + 1, classSym.position, 2097664L, currentPosition.current + 2).write(myPickleBuffer)
  TermName(currentPosition, "canEqual").write(myPickleBuffer)
  typeRefTpe_Boolean.position match {
    case 0      => {
      MethodTpe(currentPosition, List(currentPosition.current + 1, currentPosition.current + 4)).write(myPickleBuffer)
      typeRefTpe_Boolean.write(myPickleBuffer)
    }
    case i: Int =>MethodTpe(currentPosition, List(typeRefTpe_Boolean.position, currentPosition.current + 1)).write(myPickleBuffer)
  }
  ValSym(currentPosition, productElement.termNamex1Position, valSymPosition, 2105344L, typeRefTpe_Any.position).write(myPickleBuffer)
}
