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

case class AnnotatedTpe(valueMember: ValueMember, annotInfo: AnnotInfo) {

  def write(myPickleBuffer: PickleBuffer) = {
    val argsA = List(valueMember.typeRefPosition, Position.current + 1)
    val argsB = List(valueMember.typeRefPosition, annotInfo.position)
    annotInfo.position match {
      case 0      => {
      //tag
        myPickleBuffer.writeByte(42)
      //len

    myPickleBuffer.writeNat(2 + argsA.filter(arg => arg > 127).length)
      //data {
        //reference to the next entry, EXTMODCLASSref                 
          myPickleBuffer.writeNat(valueMember.typeRefPosition)
        //reference to 
          myPickleBuffer.writeNat(Position.current + 1)
      } 
      case i: Int => {
      //tag
        myPickleBuffer.writeByte(42)
      //len

    myPickleBuffer.writeNat(2 + argsB.filter(arg => arg > 127).length)
      //data {
        //reference to the next entry, EXTMODCLASSref                 
          myPickleBuffer.writeNat(valueMember.typeRefPosition)
        //reference to 
          myPickleBuffer.writeNat(annotInfo.position)
      //}
      }
    }
    Position.current += 1 
  } 
}  
