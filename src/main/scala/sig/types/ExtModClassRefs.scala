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

package avocet
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._

class ExtModClassRefs {
  val scala = ExtModClassRef_scala()
  val runtime = ExtModClassRef_runtime()
  val lang = ExtModClassRef_lang()
  val java = ExtModClassRef_java()
  val owner = ExtModClassRef_owner()
  val unchecked = ExtModClassRef_unchecked()
  val annotation = ExtModClassRef_annotation()
  val collection = ExtModClassRef_collection()
  val predef = ExtModClassRef_predef()
}