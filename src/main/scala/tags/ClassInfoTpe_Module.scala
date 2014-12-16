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
package tags
import stores._
import types._
import scala.reflect.internal.pickling._

case class ClassInfoTpe_Module(currentPosition: Position, stores: Stores, classSym_Module: ClassSym_Module, valueMembers: List[ValueMember], modelsMyRecord: TypeRefTpe_modelsMyRecord, thisTpe_runtime: ThisTpe_runtime, runtime: ExtModClassRef_runtime, scala: ExtModClassRef_scala) {
  val args = List(currentPosition.current + 1, classSym_Module.position)
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = currentPosition.current
//tag
    myPickleBuffer.writeByte(19)
//len
    myPickleBuffer.writeNat(3 + args.filter(arg => arg > 127).length)
//data {
  //reference to a ClassSym
    myPickleBuffer.writeNat(classSym_Module.position)  
  //reference to AbstractFuntion
    TypeRefTpe_AbstractFunction(currentPosition, stores, valueMembers, modelsMyRecord, thisTpe_runtime, runtime, scala).position match {
        case 0      => myPickleBuffer.writeNat(currentPosition.current + 1)
        case i: Int => myPickleBuffer.writeNat(i)
    }
  //reference to entry 15, Serializable typereftype
    myPickleBuffer.writeNat(15)
    

    currentPosition.current += 1
  }
}
