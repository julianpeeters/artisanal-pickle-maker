package avocet
package methods
package module

import tags._
import types._
import cls._
import scala.reflect.internal.pickling._

case class Init_Module(sigResources: SigResources, init: Init) {
  val position = Position.current
    
  ValSym(init.termNamePosition , ClassSym_Module.position, 512L, Position.current + 1).write(sigResources.myPickleBuffer)
  MethodTpe(List(sigResources.typeRefTpes.moduleClass.position)).write(sigResources.myPickleBuffer)
}

