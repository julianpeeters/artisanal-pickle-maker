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

import stores._
import tags._
import types._
import cls._
import scala.reflect.internal.pickling._

case class Unapply(position: Position, stores: Stores, classSym_Module: ClassSym_Module, sigResources: SigResources, valueMembers: List[ValueMember], init: Init) { 

  val valSymPosition = position.current
  val valueMemberTypeRefPositions = valueMembers.map(vm => vm.typeRefPosition)

  ValSym(position, position.current + 1, classSym_Module.position, 2097728L, position.current + 2).write(sigResources.myPickleBuffer)
  TermName(position, "unapply").write(sigResources.myPickleBuffer)
  val optionTypeRef = stores.typeStore.types.get("Option") //if the base type for lists has already been written

  valueMembers.length match {
    case 1          => {  // if there is only 1 value member, have the option typereftpe ref the value member
      if (optionTypeRef.isDefined) { 
        MethodTpe(position, List(position.current + 1, position.current + 2)).write(sigResources.myPickleBuffer)  
        TypeRefTpe_unapplyOption(position, sigResources.thisTpes.scala.position, optionTypeRef.get.position - 2, valueMembers(0).typeRefPosition).writeEntry(sigResources.myPickleBuffer)
      }
      else {
        MethodTpe(position, List(position.current + 1, position.current + 4)).write(sigResources.myPickleBuffer)
        TypeRefTpe_unapplyOption(position, sigResources.thisTpes.scala.position, position.current + 1, valueMembers(0).typeRefPosition).writeEntry(sigResources.myPickleBuffer)
        ExtRef_nested(position, position.current + 1, sigResources.extModClassRefs.scala.position).write(sigResources.myPickleBuffer)
        TypeName(position, "Option").write(sigResources.myPickleBuffer)
      }
    }
    case x if x > 1 =>{ // if there is more than 1 value member, have the option's typereftpe ref TupleRef
      if (optionTypeRef.isDefined) {  
        MethodTpe(position, List(position.current + 1, position.current + 5)).write(sigResources.myPickleBuffer)
        TypeRefTpe_unapplyOption(position, sigResources.thisTpes.scala.position, optionTypeRef.get.position - 2, position.current + 1).writeEntry(sigResources.myPickleBuffer)
        TypeRefTpe_Tuple(position, sigResources.thisTpes.scala, sigResources.extModClassRefs.scala, valueMembers).write(sigResources.myPickleBuffer)
      }
      else {
        MethodTpe(position, List(position.current + 1, position.current + 7)).write(sigResources.myPickleBuffer)
        TypeRefTpe_unapplyOption(position, sigResources.thisTpes.scala.position, position.current + 1,  position.current + 3).writeEntry(sigResources.myPickleBuffer)
        ExtRef_nested(position, position.current + 1, sigResources.extModClassRefs.scala.position).write(sigResources.myPickleBuffer)
        TypeName(position, "Option").write(sigResources.myPickleBuffer)
        TypeRefTpe_Tuple(position, sigResources.thisTpes.scala, sigResources.extModClassRefs.scala, valueMembers).write(sigResources.myPickleBuffer)
      }
    } 
    case _          => error("Hmm. what's wrong with your value members? Do you have any?") 
  }


  ValSym(position, position.current + 1, valSymPosition, 2105344L, init.typeRefTpePosition).write(sigResources.myPickleBuffer)
  TermName(position, "x$0").write(sigResources.myPickleBuffer)

}
