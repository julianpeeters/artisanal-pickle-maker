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

case class TypeRefTpe_AnyRef(thisTpe_scala: ThisTpe_scala, scala: ExtModClassRef_scala) extends Tpe {
  var polyTpePosition = 0
  var position = 0
  var annotPos = 0

  val typeName = "AnyRef"

  def write(myPickleBuffer: PickleBuffer) = {    
    position = Position.current
    TypeRefTpe_nonGeneric(Position.current + 1, Position.current + 4).writeEntry(myPickleBuffer)//this type, ExtRef
    thisTpe_scala.write(myPickleBuffer)
    scala.write(myPickleBuffer)
    TermName("scala").write(myPickleBuffer)
    ExtRef_nested(Position.current + 1, scala.position).write(myPickleBuffer)
    TypeName("AnyRef").write(myPickleBuffer)

  }
}
