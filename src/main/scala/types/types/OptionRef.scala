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

case class TypeRefTpe_OptionNoBoxed extends Tpe{
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  var typeNamePosition = 0

  val typeName = "Option"

  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
  }
}


case class TypeRefTpe_Option(thisTpe_scala: ThisTpe_scala, scala: ExtModClassRef_scala, boxedTypeRef: Tpe) extends Tpe {

  var position = 0
  var polyTpePosition = 0
  var annotPos = 0

  val typeName = "Option[" + boxedTypeRef.typeName + "]"

  def write(myPickleBuffer: PickleBuffer) = { 
    position = Position.current
    val g = TypeStore.types.get("Option") //if the base type for lists has already been written
    if (g.isDefined) { //previously defined types just need to be referenced

      boxedTypeRef.position match {
        case 0 => { //if the boxed type hasn't been written yet, write it next
          TypeRefTpe_generic(thisTpe_scala.position, g.get.position-2 , Position.current + 1 ).writeEntry(myPickleBuffer)
        }
        case i: Int => TypeRefTpe_generic(thisTpe_scala.position, g.get.position - 2 , boxedTypeRef.position).writeEntry(myPickleBuffer)
      }
    }
    else { //if the type hasn't been written yet write it now
      boxedTypeRef.position match {
        case 0 => TypeRefTpe_generic(thisTpe_scala.position, Position.current + 1, Position.current + 3).writeEntry(myPickleBuffer)
        case i => TypeRefTpe_generic(thisTpe_scala.position, Position.current + 1 , boxedTypeRef.position).writeEntry(myPickleBuffer)
      }
      ExtRef_nested(Position.current + 1, scala.position).write(myPickleBuffer)
      TypeName("Option").write(myPickleBuffer)
    }

    //add the new types to the typestore
    val baseOptionTpe = TypeRefTpe_OptionNoBoxed()
    baseOptionTpe.write(myPickleBuffer)
    TypeStore.accept(this)//add the new TypeRefType to the list of types
    TypeStore.accept(baseOptionTpe)//and add the base list type to the list of types

    //finally, write the boxed type 
    if (boxedTypeRef.position == 0) boxedTypeRef.write(myPickleBuffer)
  }
}
