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
import cls._
import scala.reflect.internal.pickling._

case class Init_Module(currentPosition: Position, classSym_Module: ClassSym_Module, sigResources: SigResources, init: Init) {
  val position = currentPosition.current
    
  ValSym(currentPosition, init.termNamePosition , classSym_Module.position, 512L, currentPosition.current + 1).write(sigResources.myPickleBuffer)
  MethodTpe(currentPosition, List(sigResources.typeRefTpes.moduleClass.position)).write(sigResources.myPickleBuffer)
}
