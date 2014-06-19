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

case class ThisTpe_scala()      extends ThisTpe
case class ThisTpe_package()    extends ThisTpe
case class ThisTpe_lang()       extends ThisTpe
case class ThisTpe_javaLang()   extends ThisTpe
case class ThisTpe_root()       extends ThisTpe
case class ThisTpe_noSymbol()   extends ThisTpe
case class ThisTpe_unchecked()  extends ThisTpe
case class ThisTpe_collection() extends ThisTpe
case class ThisTpe_runtime()    extends ThisTpe 
case class ThisTpe_owner()      extends ThisTpe_owner_

class ThisTpe {
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  =  {
  position = Position.current  
  //tag
    myPickleBuffer.writeByte(13)
  //len
    if (Position.current + 1 > 127) myPickleBuffer.writeNat(2); else myPickleBuffer.writeNat(1)
  //data {
    //reference to the head of the type's typereftype chain             
      Position.current + 1 match {
        case 0      => myPickleBuffer.writeNat(Position.current + 1)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)       
      }
  //}
      Position.current += 1
  }
}

class ThisTpe_owner_ {

var thisTypeName = ""
  var position = 0
  def write(myPickleBuffer: PickleBuffer, owner: ExtModClassRef_owner, ownerName: String)  =  {
thisTypeName = "models"
    position = Position.current  
  //tag
    myPickleBuffer.writeByte(13)
  //len
    owner.position match {
      case 0      => if (Position.current + 1 > 127) myPickleBuffer.writeNat(2); else myPickleBuffer.writeNat(1)//TYPEREFs for types not already defined need to be added next
      case i: Int => if (owner.position > 127) myPickleBuffer.writeNat(2); else myPickleBuffer.writeNat(1)       
    }
  //data {
    //reference to the head of the type's typereftype chain             
      owner.position match {
        case 0      => myPickleBuffer.writeNat(Position.current + 1)//TYPEREFs for types not already defined need to be added next
        case i: Int => myPickleBuffer.writeNat(i)       
      }
  //}

      Position.current += 1
      ThisTypeStore.accept(this)


  }
}


