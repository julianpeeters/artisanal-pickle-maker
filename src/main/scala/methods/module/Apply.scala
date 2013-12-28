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
import cls._
import scala.reflect.internal.pickling._

case class Apply(sigResources: SigResources, valueMembers: List[ValueMember], init: Init) {
  val valSymPosition = Position.current

  ValSym(Position.current + 1, ClassSym_Module.position, 2097728L, Position.current + 2).write(sigResources.myPickleBuffer)
  TermName("apply").write(sigResources.myPickleBuffer)
  val valueMembersAsParamsPositions = (Position.current + 1 to Position.current + valueMembers.length).toList
  MethodTpe(init.typeRefTpePosition :: valueMembersAsParamsPositions).write(sigResources.myPickleBuffer)
  valueMembers.foreach(vm => ValSym(vm.termNamePosition, this.valSymPosition, 8192L, vm.typeRefPosition).write(sigResources.myPickleBuffer))
  
}