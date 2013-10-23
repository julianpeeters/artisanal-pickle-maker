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
package avocet
package methods
package module

import tags._
import cls._
import scala.reflect.internal.pickling._

case class ToString_Module(sigResources: SigResources, valueMembers: List[ValueMember], toStringMethod: ToString) {
  val position = Position.current
  ValSym(toStringMethod.termNamePosition, ClassSym_Module.position, 2097698L, toStringMethod.MethodTpePosition).write(sigResources.myPickleBuffer)

   
}