package artisanal.pickle.maker 
package parser

import scala.reflect.internal.pickling.ByteCodecs
import scala.tools.scalap.scalax.rules.scalasig._

import com.novus.salat.annotations.util._
import scala.reflect.ScalaSignature



object SigParserHelper {

  def parseByteCodeFromAnnotation(clazz: Class[_]): Option[ByteCode] = {
    clazz.annotation[ScalaSignature] match {
      case Some(sig) if sig != null => {
//println("parsebytecodefromannotatoin real: " + sig.bytes.getBytes("UTF-8").map { byte => (byte & 0xff).toHexString }.mkString("[ ", " ", " ]"))
println("real sig: " + sig)
        val bytes = sig.bytes.getBytes("UTF-8")
println("real bytes:" + bytes)
        val len = ByteCodecs.decode(bytes)
println("real len : " + len)
        Option(ByteCode(bytes.take(len)))
      }
      case _ => None
    }
  }

  def parseByteCodeFromMySig(sig: artisanal.pickle.maker.ScalaSig): Option[ByteCode] = {
println("in the method: " + sig)
    val bytes = sig.bytes.getBytes("UTF-8")
println("in method: " + bytes)
    val len = ByteCodecs.decode(bytes)
println("in method: " + len)
    Option(ByteCode(bytes.take(len)))   
  }

}

