package avocet
package methods
package module


import tags._
import types._
import scala.reflect.internal.pickling._

case class ReadResolve(sigResources: SigResources) {
//myPickleBuffer: PickleBuffer, Object: TypeRefTpe_Object, ObjectReadResolve: TypeRefTpe_ObjectReadResolve){
  val valSymPosition = Position.current
  ValSym(Position.current + 1, ClassSym_Module.position, 2097668L, Position.current + 2).write(sigResources.myPickleBuffer)
  TermName("readResolve").write(sigResources.myPickleBuffer)

  sigResources.typeRefTpes.obj.position match {
    case 0      => {
      MethodTpe(List(Position.current + 1)).write(sigResources.myPickleBuffer)
      sigResources.typeRefTpes.objectReadResolve.write(sigResources.myPickleBuffer)
    }
    case i: Int => MethodTpe(List(i)).write(sigResources.myPickleBuffer)
  }



}
