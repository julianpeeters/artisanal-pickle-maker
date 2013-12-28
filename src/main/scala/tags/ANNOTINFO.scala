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

case class AnnotInfo {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(43)
  //len
    if (Position.current + 1 > 127) myPickleBuffer.writeNat(2); else myPickleBuffer.writeNat(1)
  //data {
    //reference to the next entry, EXTMODCLASSref                 
    myPickleBuffer.writeNat(Position.current + 1)
  //}  
    Position.current += 1 
  }  
}  