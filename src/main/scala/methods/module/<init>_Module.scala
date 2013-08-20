package avocet
package methods
package module

import tags._
import types._
import cls._
import scala.reflect.internal.pickling._

case class Init_Module(myPickleBuffer: PickleBuffer, init: Init, moduleClass: TypeRefTpe_moduleClass) {
  val position = Position.current
    
  ValSym(init.termNamePosition , ClassSym_Module.position, 512L, Position.current + 1).write(myPickleBuffer)
  MethodTpe(List(moduleClass.position)).write(myPickleBuffer)
}

