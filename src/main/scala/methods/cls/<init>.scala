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

case class Init(position: Position, classSym: ClassSym, sigResources: SigResources, valueMembers: List[ValueMember]) {

  var valSymPosition = 0
  var termNamePosition = 0
  val typeRefTpePosition = position.current + 3

  valSymPosition = position.current
  ValSym(position, position.current + 1, classSym.position, 512L, position.current + 2).write(sigResources.myPickleBuffer)
  termNamePosition = position.current
  TermName(position, "<init>").write(sigResources.myPickleBuffer)
   
  val paramPositions = (1 to valueMembers.length).toList.map(vm => position.current + 2 + vm)//use by appending a first param

    sigResources.thisTpes.owner.position match {//ThisTpe_owner already written if the member's type is custom and local
      case 0      => { 
        MethodTpe(position, position.current + 1 :: paramPositions).write(sigResources.myPickleBuffer);
        sigResources.typeRefTpes.modelsMyRecord.write(sigResources.myPickleBuffer);
        sigResources.thisTpes.owner.write(position, sigResources.myPickleBuffer, sigResources.extModClassRefs.owner, "!!!") 
      }
      case i: Int => {  // is already defined, so won't need to be defined next
        MethodTpe(position, position.current + 1 :: (paramPositions.map(p => p - 1))).write(sigResources.myPickleBuffer); 
        sigResources.typeRefTpes.modelsMyRecord.write(sigResources.myPickleBuffer)
      }
    } 

  valueMembers.foreach(vm => ValSym(position, vm.termNamePosition, valSymPosition, 8192L, vm.typeRefPosition).write(sigResources.myPickleBuffer))

  
}
