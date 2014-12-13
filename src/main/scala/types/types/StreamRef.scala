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

case class TypeRefTpe_Stream(currentPosition: Position, scala: ExtModClassRef_scala) extends Tpe {
  var polyTpePosition = 0
  var position = 0
  var annotPos = 0

  val typeName = "Stream"

  def write(myPickleBuffer: PickleBuffer) = {
    position = currentPosition.current
    TypeRefTpe_generic(currentPosition, currentPosition.current + 1, currentPosition.current + 9, currentPosition.current + 12) 
    SingleTpe(currentPosition, currentPosition.current + 1, currentPosition.current + 6)
    SingleTpe(currentPosition, currentPosition.current + 1, currentPosition.current + 4)
    val thisTpe_root = ThisTpe_root
    ExtModClassRef_root
    TermName(currentPosition, "<root>")
    ExtRef_topLevel(currentPosition, 9)
    ExtRef_nested(currentPosition, currentPosition.current + 1, scala.position)
    TermName(currentPosition, "package")
    ExtRef_nested(currentPosition, currentPosition.current + 1, currentPosition.current + 2)
    TypeName(currentPosition, "Stream")
  }
}
