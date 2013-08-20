package avocet
package methods
package module


import tags._
import types._
import scala.reflect.internal.pickling._

case class ReadResolve(myPickleBuffer: PickleBuffer, Object: TypeRefTpe_Object, ObjectReadResolve: TypeRefTpe_ObjectReadResolve){
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym_Module.position, 2097668L, Position.current + 2).write(myPickleBuffer)
  TermName("readResolve").write(myPickleBuffer)

  Object.position match {
    case 0      => MethodTpe(List(Position.current + 1)).write(myPickleBuffer); ObjectReadResolve.write(myPickleBuffer)
    case i: Int => MethodTpe(List(i)).write(myPickleBuffer)
  }



}
