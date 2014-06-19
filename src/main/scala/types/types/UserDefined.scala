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
package types
import tags._
import scala.reflect.internal.pickling._

case class TypeRefTpe_userDefined(typeName: String, ownerName: String, thisTpe_owner: ThisTpe_owner, extModClassRefs: ExtModClassRefs) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    if (ThisTypeStore.owners.get(ownerName).isDefined) { 
        TypeRefTpe_nonGeneric(ThisTypeStore.owners.get(ownerName).get.position, Position.current + 1).writeEntry(myPickleBuffer)
        ExtRef_nested(Position.current + 1, extModClassRefs.owner.position).write(myPickleBuffer)
        TypeName(typeName).write(myPickleBuffer)
      }
      else{ 
          if (ExtModClassRefStore.owners.get(ownerName).isDefined) {
            TypeRefTpe_nonGeneric(Position.current + 1,   Position.current + 2).writeEntry(myPickleBuffer)
            thisTpe_owner.write(myPickleBuffer, extModClassRefs.owner, ownerName) 
            ExtRef_nested(Position.current + 1, ExtModClassRefStore.owners.get(ownerName).get.position).write(myPickleBuffer)
            TypeName(typeName).write(myPickleBuffer)
          }
          else { 
            TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 4).writeEntry(myPickleBuffer)
            new ThisTpe_owner_().write(myPickleBuffer, ExtModClassRef_owner(), ownerName) 
            ExtModClassRef_owner().write(ownerName, myPickleBuffer)
            TermName(ownerName).write(myPickleBuffer)
            ExtRef_nested(Position.current + 1, Position.current - 2).write(myPickleBuffer)
            TypeName(typeName).write(myPickleBuffer)
          }
      }
    
    TypeStore.accept(this) //adds this TypeRefType to the list of types
  }
}
