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
import tags._
import types._
import scala.reflect.internal.pickling._

case class ClassInfo(position: Position, classSym: ClassSym, sigResources: SigResources, flags: List[String], names: List[String]) {
println(position.current)
//entry 0 CLASSsym 
  classSym.write(sigResources.myPickleBuffer)
println(position.current)
//entry 1
  TypeName(position, names(1)).write(sigResources.myPickleBuffer)
println(position.current)
//entry 2 EXTMODCLASSref: the immediate enclosing package 
  sigResources.extModClassRefs.owner.write(position, names.length match {
    case 1          =>  "<empty>"      //if there is only one name in the fullName list
    case x if x > 1 =>  names(0)
    case _          =>  sys.error("whoops, no class name?")
  }, sigResources.myPickleBuffer)
println(position.current)
//entry 3 TERMname of Ext Mod: the immediate owner's name, i.e. the name of the immediate enclosing package
  names.length match {
    case 1          =>  TermName(position, "<empty>").write(sigResources.myPickleBuffer)//if there is only one name in the fullName list
    case x if x > 1 =>  TermName(position, names(0)).write(sigResources.myPickleBuffer)   
    case _          =>  sys.error("whoops, no class name?")
  }
println(position.current)
//entry 4 NONEsym
  sigResources.typeRefTpes.noneSym.write(position, sigResources.myPickleBuffer)
println(position.current)
//entry 5 CLASSINFOtpe
  if (flags.contains("case class")) {
    CaseClassInfoTpe(position, classSym, sigResources.typeRefTpes.anyRef, sigResources.typeRefTpes.product, sigResources.typeRefTpes.serializable).write(sigResources.myPickleBuffer)
println(position.current)
  //entry 6 TYPEREFtpe
    sigResources.typeRefTpes.anyRef.write(sigResources.myPickleBuffer)
println(position.current)
  //entry 12 TYPEREFtpe: Product
    sigResources.typeRefTpes.product.write(sigResources.myPickleBuffer)
println(position.current)
  //entry 15 TYPEREFtpe: Serializable
    sigResources.typeRefTpes.serializable.write(sigResources.myPickleBuffer)
println(position.current)
  }
  else {
    ClassInfoTpe(position, classSym, sigResources.typeRefTpes.anyRef).write(sigResources.myPickleBuffer)
  //entry 6 TYPEREFtpe
    sigResources.typeRefTpes.anyRef.write(sigResources.myPickleBuffer)
  //entry 12 TYPEREFtpe: Product
  }
}
