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

class ThisTpes {
  val owner = ThisTpe_owner()
  val scala = ThisTpe_scala()
  val lang = ThisTpe_lang()
  val javaLang = ThisTpe_javaLang()
  val collection = ThisTpe_collection()
  val runtime = ThisTpe_runtime()
}