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
package methods
package cls

import tags._
import types._
import scala.reflect.internal.pickling._

case class ProductArity(myPickleBuffer: PickleBuffer, intRef: TypeRefTpe_Int, valueMembers: List[ValueMember]) {
  val valSymPosition = Position.current
  intRef.position match {
    case 0      => {
      ValSym(Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write(myPickleBuffer)
      TermName("productArity").write(myPickleBuffer)
      PolyTpe(intRef).write(myPickleBuffer)
      intRef.write(myPickleBuffer)
    }
    case i: Int => { println("productArity found a familiar type" + i);
      val typeNames = valueMembers.map(vm => vm.tpeName)

      if (checkBoxed(typeNames).contains("Int")) { 
        ValSym(Position.current + 1, ClassSym.position, 2097664L, Position.current + 2).write(myPickleBuffer)
        TermName("productArity").write(myPickleBuffer)
        PolyTpe(intRef).write(myPickleBuffer)
      }
      else {
        ValSym(Position.current + 1, ClassSym.position, 2097664L, i - 1).write(myPickleBuffer)
        TermName("productArity").write(myPickleBuffer)
      }
    }
  }

  private def checkBoxed(typeNames: List[String]): List[Any] = {
    typeNames.map( typeName => {
      if (typeName.endsWith("]")) {  
        val boxed = typeName.dropRight(1).split('[')(1).toString//takes the 2nd half of the split
        if (boxed.endsWith("]")) checkBoxed(List(boxed))
        else  boxed
      }  
    })
  }



}
