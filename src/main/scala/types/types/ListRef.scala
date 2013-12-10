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
package artisinal.pickle.maker 
package types
import tags._
import scala.reflect.internal.pickling._


//case class TypeRefTpe_List(noSymbol: NoneSym, scala: ExtModClassRef_scala) extends Tpe{
case class TypeRefTpe_List(noSymbol: NoneSym, scala: ExtModClassRef_scala, thisTpe_scala: ThisTpe_scala, predef: ExtModClassRef_predef, types: TypeRefTpes) extends Tpe{
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  var typeNamePosition = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current

    TypeRefTpe_generic(Position.current + 1, Position.current + 9, Position.current + 12) .writeEntry(myPickleBuffer)
    SingleTpe(Position.current + 1, Position.current + 6).write(myPickleBuffer)
    SingleTpe(Position.current + 1, Position.current + 4).write(myPickleBuffer)
    val thisTpe_root = ThisTpe_root()
    thisTpe_root.write(myPickleBuffer)
    ExtModClassRef_root.write(myPickleBuffer, noSymbol)
    TermName("<root>").write(myPickleBuffer)
    ExtRef_topLevel(9).write(myPickleBuffer)
    ExtRef_nested(Position.current + 1, scala.position).write(myPickleBuffer)
    TermName("package").write(myPickleBuffer)
    ExtRef_nested(Position.current + 1, Position.current + 2).write(myPickleBuffer)
    TypeName("List").write(myPickleBuffer)
    new ExtModClassRef_nested(Position.current - 3, scala.position).write(myPickleBuffer)



    types.string.write(myPickleBuffer)


  }
}
