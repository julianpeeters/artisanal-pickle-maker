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

case class TypeRefTpe_OptionNoBoxed(currentPosition: Position) extends Tpe{
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  var typeNamePosition = 0

  val typeName = "Option"

  def write(myPickleBuffer: PickleBuffer) = {
    position = currentPosition.current
  }
}


case class TypeRefTpe_Option(currentPosition: Position, stores: Stores, thisTpe_scala: ThisTpe_scala, scala: ExtModClassRef_scala, boxedTypeRef: Tpe) extends Tpe {

  var position = 0
  var polyTpePosition = 0
  var annotPos = 0

  val typeName = "Option[" + boxedTypeRef.typeName + "]"

  def write(myPickleBuffer: PickleBuffer) = { 
    position = currentPosition.current
    val g = stores.typeStore.types.get("Option") //if the base type for lists has already been written
    if (g.isDefined) { //previously defined types just need to be referenced

      boxedTypeRef.position match {
        case 0 => { //if the boxed type hasn't been written yet, write it next
          TypeRefTpe_generic(currentPosition, thisTpe_scala.position, g.get.position-2 , currentPosition.current + 1 ).writeEntry(myPickleBuffer)
        }
        case i: Int => TypeRefTpe_generic(currentPosition, thisTpe_scala.position, g.get.position - 2 , boxedTypeRef.position).writeEntry(myPickleBuffer)
      }
    }
    else { //if the type hasn't been written yet write it now
      boxedTypeRef.position match {
        case 0 => TypeRefTpe_generic(currentPosition, thisTpe_scala.position, currentPosition.current + 1, currentPosition.current + 3).writeEntry(myPickleBuffer)
        case i => TypeRefTpe_generic(currentPosition, thisTpe_scala.position, currentPosition.current + 1 , boxedTypeRef.position).writeEntry(myPickleBuffer)
      }
      ExtRef_nested(currentPosition, currentPosition.current + 1, scala.position).write(myPickleBuffer)
      TypeName(currentPosition, "Option").write(myPickleBuffer)
    }

    //add the new types to the typestore
    val baseOptionTpe = TypeRefTpe_OptionNoBoxed(currentPosition)
    baseOptionTpe.write(myPickleBuffer)
    stores.typeStore.accept(this)//add the new TypeRefType to the list of types
    stores.typeStore.accept(baseOptionTpe)//and add the base list type to the list of types

    //finally, write the boxed type 
    if (boxedTypeRef.position == 0) boxedTypeRef.write(myPickleBuffer)
  }
}
