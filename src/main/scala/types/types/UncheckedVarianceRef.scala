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

case class TypeRefTpe_UncheckedVariance(currentPosition: Position, stores: Stores, unchecked: ExtModClassRef_unchecked, annotation: ExtModClassRef_annotation, scala: ExtModClassRef_scala) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0

  val typeName = "uncheckedVariance"

  def write(myPickleBuffer: PickleBuffer) = {
    position = currentPosition.current 
    TypeRefTpe_nonGeneric(currentPosition, currentPosition.current + 1, currentPosition.current + 6).writeEntry(myPickleBuffer)
    val thisTpe_unchecked = ThisTpe_unchecked()
    thisTpe_unchecked.write(currentPosition, stores, myPickleBuffer)
    unchecked.write(currentPosition, myPickleBuffer)
    TermName(currentPosition, "unchecked").write(myPickleBuffer)
    annotation.write(currentPosition, myPickleBuffer, scala)
    TermName(currentPosition, "annotation").write(myPickleBuffer)
    ExtRef_nested(currentPosition, currentPosition.current + 1, currentPosition.current - 4).write(myPickleBuffer)
    TypeName(currentPosition, typeName).write(myPickleBuffer)
  }
}
