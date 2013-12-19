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
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._
class TypeRefTpes(thisTpes: ThisTpes, extModClassRefs: ExtModClassRefs) {

//basic scala datatypes
  val byte = TypeRefTpe_Byte(thisTpes.scala, extModClassRefs.scala)
  val short = TypeRefTpe_Short(thisTpes.scala, extModClassRefs.scala)
  val int = TypeRefTpe_Int(thisTpes.scala, extModClassRefs.scala)
  val long = TypeRefTpe_Long(thisTpes.scala, extModClassRefs.scala)
  val float = TypeRefTpe_Float(thisTpes.scala, extModClassRefs.scala)
  val double = TypeRefTpe_Double(thisTpes.scala, extModClassRefs.scala)
  val char = TypeRefTpe_Char(thisTpes.scala, extModClassRefs.scala)
  val string = TypeRefTpe_String(thisTpes.scala, extModClassRefs.scala, extModClassRefs.predef)
  val boolean = TypeRefTpe_Boolean(thisTpes.scala, extModClassRefs.scala)
  val unit = TypeRefTpe_Unit(thisTpes.scala, extModClassRefs.scala)
  val nul = TypeRefTpe_Null(thisTpes.scala, extModClassRefs.scala)
  val nothing = TypeRefTpe_Nothing(thisTpes.scala, extModClassRefs.scala)
  val any = TypeRefTpe_Any(thisTpes.scala, extModClassRefs.scala)
  val anyRef = TypeRefTpe_AnyRef(thisTpes.scala, extModClassRefs.scala)

//misc
  val noneSym = NoneSym()
  val annotInfo = AnnotInfo()

//more datatypes
  val obj = TypeRefTpe_Object(thisTpes.scala, thisTpes.lang, extModClassRefs.lang, extModClassRefs.java)
  val option = TypeRefTpe_Option(thisTpes.scala, extModClassRefs.scala)
  val iterator = TypeRefTpe_Iterator(thisTpes.collection, any, extModClassRefs.collection, extModClassRefs.scala)
  val javaLangString = TypeRefTpe_javaLangString(thisTpes)
  val objectReadResolve = TypeRefTpe_ObjectReadResolve(thisTpes.javaLang, extModClassRefs.lang)
  val product = TypeRefTpe_Product(thisTpes.scala, extModClassRefs.scala)
  val serializable = TypeRefTpe_Serializable(thisTpes.scala, extModClassRefs.scala)
  val uncheckedVariance = TypeRefTpe_UncheckedVariance(extModClassRefs.unchecked, extModClassRefs.annotation, extModClassRefs.scala)

//collections
  val stream = TypeRefTpe_Stream(extModClassRefs.scala)
  //val list = TypeRefTpe_List(noneSym, extModClassRefs.scala)
//  val list = TypeRefTpe_List(noneSym, extModClassRefs.scala, thisTpes.scala, extModClassRefs.predef, this)
  def list(boxedType: Tpe) =  TypeRefTpe_List(noneSym, extModClassRefs.scala, thisTpes.scala, extModClassRefs.predef, boxedType)


//this class
  val modelsMyRecord = TypeRefTpe_modelsMyRecord(thisTpes.owner)
  val moduleClass = TypeRefTpe_moduleClass(thisTpes.owner)

//user-defined classes
  def userDefined(x: String) = TypeRefTpe_userDefined(x, thisTpes.owner, extModClassRefs )




}
