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
package module


import tags._
import types._
import scala.reflect.internal.pickling._

case class ReadResolve(sigResources: SigResources) {
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym_Module.position, 2097668L, Position.current + 2).write(sigResources.myPickleBuffer)
  TermName("readResolve").write(sigResources.myPickleBuffer)

  sigResources.typeRefTpes.obj.position match {
    case 0      => {
      MethodTpe(List(Position.current + 1)).write(sigResources.myPickleBuffer)
      sigResources.typeRefTpes.objectReadResolve.write(sigResources.myPickleBuffer)
    }
    case i: Int => MethodTpe(List(i)).write(sigResources.myPickleBuffer)
  }



}