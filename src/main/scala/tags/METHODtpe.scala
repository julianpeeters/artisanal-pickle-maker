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
package tags
import scala.reflect.internal.pickling._

case class MethodTpe(currentPosition: Position, typeRefs: List[Int]) {
  var position = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = currentPosition.current
  //tag
    myPickleBuffer.writeByte(20)
  //len
    myPickleBuffer.writeNat(typeRefs.length + typeRefs.filter(tr => tr > 127).length)
  //data {
    //write type references
    typeRefs.foreach(tr => myPickleBuffer.writeNat(tr))

    currentPosition.current += 1
  }
}
