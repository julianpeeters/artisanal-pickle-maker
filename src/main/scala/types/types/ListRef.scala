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
import java.util.concurrent.ConcurrentHashMap

case class TypeRefTpe_ListNoBoxed extends Tpe{
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  var typeNamePosition = 0

  val typeName = "List"//[" + boxedType.typeName + "]"

  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
  //  TypeStore.accept(this)//add the new TypeRefType to the list of types
  }
}

case class TypeRefTpe_List(noSymbol: NoneSym, scalaExt: ExtModClassRef_scala, thisTpe_scala: ThisTpe_scala, predef: ExtModClassRef_predef, boxedType: Tpe) extends Tpe{
  var position = 0
  var polyTpePosition = 0
  var annotPos = 0
  var typeNamePosition = 0

  val typeName = "List[" + boxedType.typeName + "]"

  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current

    val g = TypeStore.types.get("List")
    if (g.isDefined) { //previously defined types just need to be referenced
      if (boxedType.position == 0) TypeRefTpe_generic(g.get.position -11, g.get.position -3 , Position.current + 1).writeEntry(myPickleBuffer)

      else TypeRefTpe_generic(Position.current + 1, g.get.position -2, boxedType.position).writeEntry(myPickleBuffer)
    }
    else {  

      if (boxedType.position == 0) TypeRefTpe_generic(Position.current + 1, Position.current + 9, Position.current + 12).writeEntry(myPickleBuffer)
      else TypeRefTpe_generic(Position.current + 1, Position.current + 9, boxedType.position).writeEntry(myPickleBuffer) 
    
      SingleTpe(Position.current + 1, Position.current + 6).write(myPickleBuffer)
      SingleTpe(Position.current + 1, Position.current + 4).write(myPickleBuffer)
      val thisTpe_root = ThisTpe_root()
      thisTpe_root.write(myPickleBuffer)
      ExtModClassRef_root.write(myPickleBuffer, noSymbol)
      TermName("<root>").write(myPickleBuffer)
      ExtRef_topLevel(9).write(myPickleBuffer)
      ExtRef_nested(Position.current + 1, scalaExt.position).write(myPickleBuffer)
      TermName("package").write(myPickleBuffer)
      ExtRef_nested(Position.current + 1, Position.current + 2).write(myPickleBuffer)
      TypeName("List").write(myPickleBuffer)
      new ExtModClassRef_nested(Position.current - 3, scalaExt.position).write(myPickleBuffer)
    }
    val baseListTpe = TypeRefTpe_ListNoBoxed()
    baseListTpe.write(myPickleBuffer)
    TypeStore.accept(this)//add the new TypeRefType to the list of types
    TypeStore.accept(baseListTpe)//and add the base list type to the list of types
  }

}
