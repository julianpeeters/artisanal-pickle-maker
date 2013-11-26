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

import models._
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._
import scala.tools.nsc.util.ShowPickled
import java.util.Arrays
import java.io.{PrintStream, File}

//import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._ //using Salat's method for getting a sig simply to ensure this works with Salat
import scala.reflect.ScalaSignature

//case class MyRecord(x: String, y: Int, z: Boolean)
//for debug purposes
object ArtisinalPickleMaker extends App {

  val mySig = new ScalaSig(List("case class"), List("models", "MyRecord"), List(("myRec", "MyRecord")))

  val clz = classOf[MyRecord]




  println("My sig and a real sig share the following traits: ")

//Compare the strings
  val correctSig = parseSigFromAnnotation(clz).get
    println("Same encoded strings: " + (correctSig == mySig.bytes).toString)
    mySig.bytes.diff(correctSig).foreach(println)//

//Compare the decoded bytes (raw, what the Pickle Buffer reads and writes)
  val myBytes = parseBytesFromMySig(mySig).get
  val correctBytes = parseBytes(classSigToBytes(clz).get).get//.dropRight(1)//.map(ScalaSigAttributeParsers.parse(_)).get
    println("Same decoded bytes  : " + (myBytes.sameElements(correctBytes)).toString)

//Compare pre-encoded array, i.e the pickle buffer output bytes before pickling(some of the real sigs have an extra "0")
  println("Same prior to encoding: " + (mySig.array).sameElements(correctBytes).toString)





//Methods for my stuff
  def parseBytesFromMySig(sig: ScalaSig): Option[Array[Byte]] = {
    val bytes = sig.bytes.getBytes("UTF-8")
    val len = ByteCodecs.decode(bytes)
    Option(bytes.take(len))
  }

//Methods for the real stuff
  def parseSigFromAnnotation(clazz: Class[_]): Option[String] = {
    clazz.annotation[ScalaSignature] match {
      case Some(sig) if sig != null => {
        val bytes = sig.bytes
        Option(bytes)
      }
      case _ => None
    }
  }

  def classSigToBytes(clazz: Class[_]): Option[Array[Byte]] = {
    clazz.annotation[ScalaSignature] match {
      case Some(sig) if sig != null => {
        val bytes = sig.bytes.getBytes("UTF-8")
        Option(bytes)
      }
      case _ => None
    }
  }

  def parseBytes(bytes: Array[Byte]): Option[Array[Byte]] = {
    val len = ByteCodecs.decode(bytes)
    Option(bytes.take(len))
  }



//view results
  val pickleBuffer = new PickleBuffer(correctBytes, 0, correctBytes.length)
  val ps = new PrintStream(new File("MyRecord.ShowPickled"))
  ShowPickled.printFile(pickleBuffer, ps)


  //val myPickleBuffer = new PickleBuffer(mySig.array, 0, mySig.array.length)  //pre-, i.e. un- ,encoded array works fine
  val myPickleBuffer = new PickleBuffer(myBytes, 0, myBytes.length)
  val myPs = new PrintStream(new File("myPickleBuffer.ShowPickled"))

 // ShowPickled.printFile(myPickleBuffer, myPs)


}
