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

case class ProductElement(position: Position, classSym: ClassSym, myPickleBuffer: PickleBuffer, Any: TypeRefTpe_Any, Int: TypeRefTpe_Int) {
  val valSymPosition = position.current
  ValSym(position, position.current + 1, classSym.position, 2097664L, position.current + 2).write(myPickleBuffer)
  TermName(position, "productElement").write(myPickleBuffer)
  Any.position match {
    case 0      => { 
      MethodTpe(position, List(position.current + 1, position.current + 4)).write(myPickleBuffer)
      Any.write(myPickleBuffer)
    }
    case i: Int => MethodTpe(position, List(i, position.current + 1)).write(myPickleBuffer)
  }
  ValSym(position, position.current + 1, valSymPosition, 2105344L, Int.position).write(myPickleBuffer)
  val termNamex1Position = position.current
  TermName(position, "x$1").write(myPickleBuffer)
}
