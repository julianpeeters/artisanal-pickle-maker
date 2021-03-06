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
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._
import stores._
import tags._
import types._


class ModuleMethods(position: Position, stores: Stores, classSym_Module: ClassSym_Module, sigResources: SigResources, valueMembers: List[ValueMember], initMethod: Init, toStringMethod: ToString) {

  val initMethod_Module = Init_Module(position, classSym_Module, sigResources, initMethod)
  val toStringMethod_Module = ToString_Module(position, classSym_Module, sigResources, valueMembers, toStringMethod)
  val applyMethod = Apply(position, classSym_Module, sigResources, valueMembers, initMethod)
  val UnapplyMethod = Unapply(position, stores, classSym_Module, sigResources, valueMembers, initMethod)
  val readResolveMethod = ReadResolve(position, classSym_Module, sigResources)
}
