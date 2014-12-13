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

case class ExtRef_topLevel(position: Position, ref: Int) {
  //Write entry  EXTref
  def write(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(9)
  //len
    if (ref > 127) myPickleBuffer.writeNat(2)
    else myPickleBuffer.writeNat(1)
  //data {
    //reference               
      myPickleBuffer.writeNat(ref)
  //}
      position.current += 1
  }
}

case class ExtRef_nested(position: Position, nameRef: Int, ownerRef: Int) {
  val args = List(nameRef, ownerRef)
  //Write entry  EXTref
  def write(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(9)
  //len
    myPickleBuffer.writeNat(2 + args.filter(arg => arg > 127).length)
  //data {
    //reference to the next entry,              
     myPickleBuffer.writeNat(nameRef)
    //reference to the next entry,              
     myPickleBuffer.writeNat(ownerRef)
  //}
      position.current += 1
  }
}
