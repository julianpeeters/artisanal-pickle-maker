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
package tags
import scala.reflect.internal.pickling._

case class TermName (name: String){
  def write(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(1)
  //len
    myPickleBuffer.writeNat(name.length)
  //data {
    //write the bytes of the string to the pickle buffer                 
      name.getBytes.foreach(b => myPickleBuffer.writeNat(b))
  //}
      Position.current += 1
  }
}