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

class CaseClassMethods(sigResources: SigResources, valueMembers: List[ValueMember]) {
//write class methods that we get for free with a case class
  val copyMethod = Copy(sigResources, valueMembers)

  val copyDefaultMethod = CopyDefault(sigResources, valueMembers)

  val productPrefixMethod = ProductPrefix(sigResources)

  val productArityMethod = ProductArity(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.int)//, 
    //valueMembers)
  val productElementMethod = ProductElement(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.any, 
    sigResources.typeRefTpes.int)
  val productIteratorMethod = ProductIterator(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.iterator)
  val canEqualMethod = CanEqual(
    sigResources.myPickleBuffer, 
    productElementMethod, 
    sigResources.typeRefTpes.boolean, 
    sigResources.typeRefTpes.any)
  val hashCodeMethod = HashCode(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.int)
  val toStringMethod = ToString(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.javaLangString)
  val equalsMethod  = Equals(
    sigResources.myPickleBuffer, 
    productElementMethod, 
    sigResources.typeRefTpes.boolean, 
    sigResources.typeRefTpes.any)
}
