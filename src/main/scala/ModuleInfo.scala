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
import tags._
import types._
import scala.reflect.internal.pickling._

class ModuleInfo(myPickleBuffer: PickleBuffer, names: List[String], valueMembers: List[ValueMember], moduleClass: TypeRefTpe_moduleClass, modelsMyRecord: TypeRefTpe_modelsMyRecord, thisTpe_runtime: ThisTpe_runtime, runtime: ExtModClassRef_runtime, scala: ExtModClassRef_scala) {
  ModuleSym.write(myPickleBuffer)
  names.length match {
    case 1          => TermName(names(0)).write(myPickleBuffer)
    case x if x > 1 => TermName(names(1)).write(myPickleBuffer) 
    case _          => println("whoops, no class name?")
  }
  moduleClass.write(myPickleBuffer)
  ClassSym_Module.write(myPickleBuffer)
  ClassInfoTpe_Module(valueMembers, modelsMyRecord, thisTpe_runtime, runtime, scala).write(myPickleBuffer)
  TypeRefTpe_AbstractFunction(valueMembers, modelsMyRecord, thisTpe_runtime, runtime, scala).write(myPickleBuffer)
}