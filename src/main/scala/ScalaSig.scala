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
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._

//takes a List of flags,  a list of package and class, and a list of value member names and types
class ScalaSig(flags: List[String], names: List[String], args: List[(String, String)]) {

//set up a counter to keep track of the number of entries
  val position = new Position
  
//setup classSym
  val classSym = new ClassSym(position)

//set up resources to supply us with the named objects we'll use to make sig entries
  val sigResources = new SigResources(position, classSym)

//write entries
  val entries = new Entries(position, classSym, sigResources, flags, names, args)

//after writing entries, how many were written?
  val entriesNumber = position.current
println("Pos: " + position.current)

// get the bytes, trimming the excess 0s but leaving one 0. (Header written last so we know # entries)
  val array = Array.concat(new SigHeader(position).bytes, sigResources.myPickleBuffer.bytes).reverse.dropWhile(b => b == 0).reverse:+0.toByte
//val array = sigResources.myPickleBuffer.bytes.reverse.dropWhile(b => b == 0).reverse:+0.toByte


//use NSC's AnnotationInfo code to pickle:
  val mySig = ScalaSigBytes(array)
  val encoded = mySig.sevenBitsMayBeZero
  val bytes =  (new String(encoded, "UTF-8"))
//println("ScalaSig mySig: " + mySig)
//println("ScalaSig encoded: " + encoded)
//println("ScalaSig bytes: " + bytes)

//reset position keeper
 // Position.current = 0

//reset maps of generated types 
  TypeStore.types.clear()
  ValueMemberStore.valueMembers.clear()
  ExtModClassRefStore.owners.clear()
  ThisTypeStore.owners.clear()
}
