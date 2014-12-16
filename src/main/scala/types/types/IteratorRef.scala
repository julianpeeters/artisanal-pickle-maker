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

case class TypeRefTpe_Iterator(currentPosition: Position, stores: Stores, thisTpe_collection: ThisTpe_collection, Any: TypeRefTpe_Any, collection: ExtModClassRef_collection, scala: ExtModClassRef_scala) extends Tpe{
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0

  val typeName = "Iterator"

  def write(myPickleBuffer: PickleBuffer) = {
    position = currentPosition.current

    TypeRefTpe_generic(currentPosition, currentPosition.current + 1, currentPosition.current + 4, Any.position).writeEntry(myPickleBuffer)
    thisTpe_collection.write(currentPosition, stores, myPickleBuffer)
    collection.write(currentPosition, myPickleBuffer, scala)
    TermName(currentPosition, "collection").write(myPickleBuffer)
    ExtRef_nested(currentPosition, currentPosition.current + 1, collection.position).write(myPickleBuffer)
    TypeName(currentPosition, "Iterator").write(myPickleBuffer)
  }
}
