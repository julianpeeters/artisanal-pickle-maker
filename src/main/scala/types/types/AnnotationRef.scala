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
package types
import tags._
import scala.reflect.internal.pickling._

case class Annotation(valueMember: ValueMember, annotInfo: AnnotInfo) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current
    polyTpePosition = Position.current - 1
    AnnotatedTpe(valueMember, annotInfo).write(myPickleBuffer)
    annotInfo.position match {
      case 0 => annotInfo.write(myPickleBuffer)
      case _ =>
    }
  
  }
}