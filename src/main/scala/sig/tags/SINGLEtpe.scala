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
package tags
import scala.reflect.internal.pickling._

case class SingleTpe(scalaRef: Int, modRef: Int) {
  def write(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(14)
  //len
    if (scalaRef > 127 && modRef > 127) myPickleBuffer.writeNat(4);  
    else if (scalaRef > 127 || modRef > 127) myPickleBuffer.writeNat(3);  
    else myPickleBuffer.writeNat(2)
  //data {
    //reference 
    myPickleBuffer.writeNat(scalaRef)
    //reference 
    myPickleBuffer.writeNat(modRef)
  //}
      Position.current += 1
  
}}