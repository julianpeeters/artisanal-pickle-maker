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
import tags._
import types._
import scala.reflect.internal.pickling._


class SigResources {
//set up a PickleBuffer to write to
  val myPickleBuffer = new PickleBuffer(new Array[Byte](4096), 0, 0)
//instanstiate our tpes and refs (sets of named objects for use in making the signature)
  val thisTpes = new ThisTpes
  val extModClassRefs = new ExtModClassRefs
  val typeRefTpes = new TypeRefTpes(thisTpes, extModClassRefs)
}