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
import stores._
import tags._
import scala.reflect.internal.pickling._

case class TypeRefTpe_AbstractFunction(currentPosition: Position, stores: Stores, valueMembers: List[ValueMember], modelsMyRecord: TypeRefTpe_modelsMyRecord, thisTpe_runtime: ThisTpe_runtime, runtime: ExtModClassRef_runtime, scala: ExtModClassRef_scala) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0

  val typeName = "AbstractFunction"

  def write(myPickleBuffer: PickleBuffer) = {
    position = currentPosition.current
    TypeRefTpe_function(currentPosition, currentPosition.current + 1, currentPosition.current + 4, valueMembers.map(_.typeRefPosition), modelsMyRecord.position).writeEntry(myPickleBuffer)
    thisTpe_runtime.write(currentPosition, stores, myPickleBuffer)
    runtime.write(currentPosition, myPickleBuffer, scala)
    TermName(currentPosition, "runtime").write(myPickleBuffer)
    ExtRef_nested(currentPosition, currentPosition.current + 1, currentPosition.current - 2).write(myPickleBuffer)
    TypeName(currentPosition, "AbstractFunction" + valueMembers.length).write(myPickleBuffer)
  }
}
