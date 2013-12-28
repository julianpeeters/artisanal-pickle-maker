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
import scala.math._
import scala.reflect.internal.pickling._

case class ValSym(termNamePos: Int, classSymPos: Int, flags: Long, typeRefPos: Int) {
  val args = List(termNamePos, classSymPos, flags, typeRefPos)
  def write(myPickleBuffer: PickleBuffer)  = {

  //tag
    myPickleBuffer.writeByte(8)
  //len
    val byteBoundaries = (1 to 10).map(power => pow(128,power))//for filtering values that will require more than one byte to write,
    val extraLength = byteBoundaries.map(byteBoundary => args.filter(arg => arg > byteBoundary-1).length).sum//sums the lengths of each filter
    myPickleBuffer.writeNat(4 + extraLength)
  //data {
    //reference 
      myPickleBuffer.writeNat(termNamePos)
    //reference 
      myPickleBuffer.writeNat(classSymPos)
    //reference 
      myPickleBuffer.writeLongNat(flags)
    //reference 
      myPickleBuffer.writeNat(typeRefPos)
    Position.current += 1


  }
}