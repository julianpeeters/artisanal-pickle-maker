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

case class ClassSym(currentPosition: Position) {
  var position = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = currentPosition.current
  //tag
      myPickleBuffer.writeByte(6)
  //len
      myPickleBuffer.writeNat(4)
  //data {
    //reference to entry 1, the class name                 
      myPickleBuffer.writeByte(1)

    //reference to the owner of the class
      new ExtModClassRef_topLevel_class(currentPosition.current + 3).position match {
        case 0      => myPickleBuffer.writeNat(currentPosition.current + 2)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)//should point to "models" if this is for a Salat and Play2 App
      }

    //pickledflags 
      myPickleBuffer.writeNat(64)//(64 represents the "case" modifier)
    //reference to entry 5, the class info 
      myPickleBuffer.writeNat(5)

      currentPosition.current += 1
  }
}

    //optional reference to 2nd level package, i.e., if the immediate owner has a dot, e.g. "com.MyOrg"
      //myPickleBuffer.writeByte()//TODO write immediate as well as top level owners
      //myPickleBuffer.writeByte()//TODO write the TERMname
