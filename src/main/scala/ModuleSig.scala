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

import tags._
import types._

//Write a module signature: composed of module info and module methods
class ModuleSig(position: Position, sigResources: SigResources, names: List[String], valueMembers: List[ValueMember], initMethod: Init, caseClassMethods: CaseClassMethods){

  val classSym_Module = new ClassSym_Module(position)
  val moduleSym = new ModuleSym(position)

//Write Module Info
  val moduleInfo = new ModuleInfo(
    position,
    classSym_Module,
    moduleSym,
    sigResources.myPickleBuffer, 
    names, 
    valueMembers, 
    sigResources.typeRefTpes.moduleClass, 
    sigResources.typeRefTpes.modelsMyRecord, 
    sigResources.thisTpes.runtime, 
    sigResources.extModClassRefs.runtime, 
    sigResources.extModClassRefs.scala)

//write Module Methods
  val moduleMethods = new ModuleMethods(position, classSym_Module, sigResources, valueMembers, initMethod, caseClassMethods.toStringMethod)

}
