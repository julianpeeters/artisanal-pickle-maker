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
import types._
import scala.reflect.internal.pickling._

case class PolyTpe[X <: Tpe](typeRef: X) {
 // val args = List(Position.current + 1, typeRef.position)
  def write(myPickleBuffer: PickleBuffer) {
  //tag
    myPickleBuffer.writeByte(21)
  //len
    //myPickleBuffer.writeNat(1 + args.filter(arg => arg > 127).length)
    if (Position.current + 1 > 127 || typeRef.position > 127) myPickleBuffer.writeNat(2); else myPickleBuffer.writeNat(1)
  //data {
    //reference to the head of the type's typereftype chain             
      typeRef.position match {//TYPEREFs for types not already defined need to be added next
        case 0      => myPickleBuffer.writeNat(Position.current + 1); typeRef.polyTpePosition = Position.current
        case i: Int => myPickleBuffer.writeNat(i); typeRef.polyTpePosition = Position.current
      }
  //}
      Position.current += 1
  }
}