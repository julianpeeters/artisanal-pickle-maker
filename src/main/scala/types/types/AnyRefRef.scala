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

case class TypeRefTpe_AnyRef(currentPosition: Position, stores: Stores, thisTpe_scala: ThisTpe_scala, scala: ExtModClassRef_scala) extends Tpe {
  var polyTpePosition = 0
  var position = 0
  var annotPos = 0

  val typeName = "AnyRef"

  def write(myPickleBuffer: PickleBuffer) = {    
    position = currentPosition.current
    TypeRefTpe_nonGeneric(currentPosition, currentPosition.current + 1, currentPosition.current + 4).writeEntry(myPickleBuffer)//this type, ExtRef
    thisTpe_scala.write(currentPosition, stores, myPickleBuffer)
    scala.write(currentPosition, stores, "scala", myPickleBuffer)
    TermName(currentPosition, "scala").write(myPickleBuffer)
    ExtRef_nested(currentPosition, currentPosition.current + 1, scala.position).write(myPickleBuffer)
    TypeName(currentPosition, "AnyRef").write(myPickleBuffer)

  }
}
