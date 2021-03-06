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
import scala.reflect.internal.pickling._
import PickleFormat._


case class SigHeader(position: Position) {
  val hB = new HB
//write version
  //Version
    hB.headerBuffer.writeNat(PickleFormat.MajorVersion)
    hB.headerBuffer.writeNat(PickleFormat.MinorVersion)

//write # of entries
    hB.headerBuffer.writeNat(position.current)

    val bytes = if (position.current > 127) hB.headerBuffer.bytes.take(4); else hB.headerBuffer.bytes.take(3)
}
