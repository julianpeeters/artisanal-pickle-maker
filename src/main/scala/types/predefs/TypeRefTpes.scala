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
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._
class TypeRefTpes(position: Position, classSym: ClassSym, thisTpes: ThisTpes, extModClassRefs: ExtModClassRefs) {

//basic scala datatypes
  val byte = TypeRefTpe_Byte(position, thisTpes.scala, extModClassRefs.scala)
  val short = TypeRefTpe_Short(position, thisTpes.scala, extModClassRefs.scala)
  val int = TypeRefTpe_Int(position, thisTpes.scala, extModClassRefs.scala)
  val long = TypeRefTpe_Long(position, thisTpes.scala, extModClassRefs.scala)
  val float = TypeRefTpe_Float(position, thisTpes.scala, extModClassRefs.scala)
  val double = TypeRefTpe_Double(position, thisTpes.scala, extModClassRefs.scala)
  val char = TypeRefTpe_Char(position, thisTpes.scala, extModClassRefs.scala)
  val string = TypeRefTpe_String(position, thisTpes.scala, extModClassRefs.scala, extModClassRefs.predef)
  val boolean = TypeRefTpe_Boolean(position, thisTpes.scala, extModClassRefs.scala)
  val unit = TypeRefTpe_Unit(position, thisTpes.scala, extModClassRefs.scala)
  val nul = TypeRefTpe_Null(position, thisTpes.scala, extModClassRefs.scala)
  val nothing = TypeRefTpe_Nothing(position, thisTpes.scala, extModClassRefs.scala)
  val any = TypeRefTpe_Any(position, thisTpes.scala, extModClassRefs.scala)
  val anyRef = TypeRefTpe_AnyRef(position, thisTpes.scala, extModClassRefs.scala)

//more datatypes
  val obj = TypeRefTpe_Object(position, thisTpes.scala, thisTpes.lang, extModClassRefs.lang, extModClassRefs.java)
  val javaLangString = TypeRefTpe_javaLangString(position, thisTpes)
  val objectReadResolve = TypeRefTpe_ObjectReadResolve(position, thisTpes.javaLang, extModClassRefs.lang)
  val product = TypeRefTpe_Product(position, thisTpes.scala, extModClassRefs.scala)
  val serializable = TypeRefTpe_Serializable(position, thisTpes.scala, extModClassRefs.scala)
  val uncheckedVariance = TypeRefTpe_UncheckedVariance(position, extModClassRefs.unchecked, extModClassRefs.annotation, extModClassRefs.scala)

//misc
  val noneSym = NoneSym()
  val annotInfo = AnnotInfo(position)

//this class
  val modelsMyRecord = TypeRefTpe_modelsMyRecord(position, classSym, thisTpes.owner)
  val moduleClass = TypeRefTpe_moduleClass(position, thisTpes.owner)

//generics
  def optionNoBoxed          =  TypeRefTpe_OptionNoBoxed(position)
  def option(boxedType: Tpe) = TypeRefTpe_Option(position, thisTpes.scala, extModClassRefs.scala, boxedType)

  def stream(boxedType: Tpe) = TypeRefTpe_Stream(position, extModClassRefs.scala)
  val iterator = TypeRefTpe_Iterator(position, thisTpes.collection, any, extModClassRefs.collection, extModClassRefs.scala)

  def listNoBoxed            =  TypeRefTpe_ListNoBoxed(position)//to keep track of the first list written, indepenent of the boxed type
  def list(valueMemberName: String, boxedType: Tpe) = TypeRefTpe_List(position, noneSym, extModClassRefs.scala, thisTpes.scala, extModClassRefs.predef, valueMemberName, boxedType)

//user-defined classes
  def userDefined(typeName: String, ownerName: String) = TypeRefTpe_userDefined(position, typeName, ownerName, thisTpes.owner, extModClassRefs )





}
