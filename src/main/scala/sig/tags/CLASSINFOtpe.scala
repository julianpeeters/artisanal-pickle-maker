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
import types._
import scala.reflect.internal.pickling._

case class CaseClassInfoTpe(AnyRef: TypeRefTpe_AnyRef, Product: TypeRefTpe_Product, Serializable: TypeRefTpe_Serializable) {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(19)
  //len
    myPickleBuffer.writeNat(4)
  //data {
    //reference to entry 1, the CLASSsym                 
      myPickleBuffer.writeNat(ClassSym.position)
    //reference to entry 6, AnyRef typereftype
      AnyRef.position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 1)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)
      }
    //reference to entry 12, Product typereftype 
      Product.position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 7)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)
      }
    //reference to entry 15, Serializable typereftype
      Serializable.position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 10)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)
      }

    Position.current += 1
  }
}
case class ClassInfoTpe(AnyRef: TypeRefTpe_AnyRef) {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(19)
  //len
    myPickleBuffer.writeNat(2)
  //data {
    //reference to entry 1, the CLASSsym                 
      myPickleBuffer.writeNat(ClassSym.position)
    //reference to entry 6, AnyRef typereftype
      AnyRef.position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 1)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)
      }


    Position.current += 1
  }
}