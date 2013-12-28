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

case class ProductElement(myPickleBuffer: PickleBuffer, Any: TypeRefTpe_Any, Int: TypeRefTpe_Int) {
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write(myPickleBuffer)
  TermName("productElement").write(myPickleBuffer)
  Any.position match {
    case 0      => { 
      MethodTpe(List(Position.current + 1, Position.current + 4)).write(myPickleBuffer)
      Any.write(myPickleBuffer)
    }
    case i: Int => MethodTpe(List(i, Position.current + 1)).write(myPickleBuffer)
  }
  ValSym(Position.current + 1, valSymPosition, 2105344L, Int.position).write(myPickleBuffer)
  val termNamex1Position = Position.current
  TermName("x$1").write(myPickleBuffer)
}