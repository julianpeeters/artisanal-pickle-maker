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
import java.util.concurrent.ConcurrentHashMap

case class TypeRefTpe_ListNoBoxed(currentPosition: Position) extends Tpe{
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  var typeNamePosition = 0

  val typeName = "List"

  def write(myPickleBuffer: PickleBuffer) = {
    position = currentPosition.current
  }
}

case class TypeRefTpe_List(currentPosition: Position, noSymbol: NoneSym, scalaExt: ExtModClassRef_scala, thisTpe_scala: ThisTpe_scala, predef: ExtModClassRef_predef, valueMemberName: String, boxedTypeRef: Tpe) extends Tpe{
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  var typeNamePosition = 0

  val typeName = "List[" + boxedTypeRef.typeName + "]"

  def write(myPickleBuffer: PickleBuffer) = {
    position = currentPosition.current
    val g = TypeStore.types.get("List") //if the base type for lists has already been written
    if (g.isDefined) {//previously defined types just need to be referenced
      boxedTypeRef.position match {
        case 0 => TypeRefTpe_generic(currentPosition, g.get.position -11, g.get.position -3 , currentPosition.current + 1).writeEntry(myPickleBuffer)
        case i => TypeRefTpe_generic(currentPosition, g.get.position -11, g.get.position -3 , boxedTypeRef.position).writeEntry(myPickleBuffer)
      }
    }
    else { //if the type hasn't been written yet write it now
      boxedTypeRef.position match {
        case 0 => TypeRefTpe_generic(currentPosition, currentPosition.current + 1, currentPosition.current + 9, currentPosition.current + 12).writeEntry(myPickleBuffer)
        case i => TypeRefTpe_generic(currentPosition, currentPosition.current + 1, currentPosition.current + 9, boxedTypeRef.position).writeEntry(myPickleBuffer) 
      }

      SingleTpe(currentPosition, currentPosition.current + 1, currentPosition.current + 6).write(myPickleBuffer)
      SingleTpe(currentPosition, currentPosition.current + 1, currentPosition.current + 4).write(myPickleBuffer)
      val thisTpe_root = ThisTpe_root()
      thisTpe_root.write(currentPosition, myPickleBuffer)
      ExtModClassRef_root.write(currentPosition, myPickleBuffer, noSymbol)
      TermName(currentPosition, "<root>").write(myPickleBuffer)
      ExtRef_topLevel(currentPosition, 9).write(myPickleBuffer)
      ExtRef_nested(currentPosition, currentPosition.current + 1, scalaExt.position).write(myPickleBuffer)
      TermName(currentPosition, "package").write(myPickleBuffer)
      ExtRef_nested(currentPosition, currentPosition.current + 1, currentPosition.current + 2).write(myPickleBuffer)
      TypeName(currentPosition, "List").write(myPickleBuffer)
      new ExtModClassRef_nested(currentPosition.current - 3, scalaExt.position).write(currentPosition, myPickleBuffer)
    }

    //add the new types to the typestore
    val baseListTpe = TypeRefTpe_ListNoBoxed(currentPosition)
    baseListTpe.write(myPickleBuffer)
    TypeStore.accept(baseListTpe)//and add the base list type to the list of types
    TypeStore.accept(this)//add the new TypeRefType to the list of types

    //finally, write the boxed type 
    if (boxedTypeRef.position == 0) boxedTypeRef.write(myPickleBuffer)


  }
}
