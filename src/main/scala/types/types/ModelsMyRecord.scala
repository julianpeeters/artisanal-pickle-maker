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

case class TypeRefTpe_modelsMyRecord(thisTpe_owner: ThisTpe_owner) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0

  val typeName = "modelsMyRecord"

  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    thisTpe_owner.position match { //write it next if it hasn't been written before
      case 0      => TypeRefTpe_nonGeneric(Position.current + 1, ClassSym.position).writeEntry(myPickleBuffer)
      case i: Int => TypeRefTpe_nonGeneric(thisTpe_owner.position, ClassSym.position).writeEntry(myPickleBuffer)
    }
  }
}
