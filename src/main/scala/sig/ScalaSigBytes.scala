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
//copied from:
/* NSC -- new Scala compiler
* Copyright 2007-2013 LAMP/EPFL
* @author Martin Odersky
*/
package avocet
//package scala
//package reflect
//package internal
import scala.reflect.internal._
import pickling.ByteCodecs
import scala.annotation.tailrec
import scala.collection.immutable.ListMap

 case class ScalaSigBytes(bytes: Array[Byte]) {// extends ClassfileAnnotArg {
    override def toString = (bytes map { byte => (byte & 0xff).toHexString }).mkString("[ ", " ", " ]")
    lazy val sevenBitsMayBeZero: Array[Byte] = {
      mapToNextModSevenBits(scala.reflect.internal.pickling.ByteCodecs.encode8to7(bytes))
    }

    /* In order to store a byte array (the pickle) using a bytecode-level annotation,
* the most compact representation is used (which happens to be string-constant and not byte array as one would expect).
* However, a String constant in a classfile annotation is limited to a maximum of 65535 characters.
* Method `fitsInOneString` tells us whether the pickle can be held by a single classfile-annotation of string-type.
* Otherwise an array of strings will be used.
*/
    def fitsInOneString: Boolean = {
      // due to escaping, a zero byte in a classfile-annotation of string-type takes actually two characters.
      val numZeros = (sevenBitsMayBeZero count { b => b == 0 })

      (sevenBitsMayBeZero.length + numZeros) <= 65535
    }
/*
    def sigAnnot: Type =
      if (fitsInOneString)
        definitions.ScalaSignatureAnnotation.tpe
      else
        definitions.ScalaLongSignatureAnnotation.tpe
*/
    private def mapToNextModSevenBits(src: Array[Byte]): Array[Byte] = {
      var i = 0
      val srclen = src.length
      while (i < srclen) {
        val in = src(i)
        src(i) = (if (in == 0x7f) 0.toByte else (in + 1).toByte)
        i += 1
      }
      src
    }
  }