package avocet
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._


class ModuleMethods(sigResources: SigResources, valueMembers: List[ValueMember], initMethod: Init, toStringMethod: ToString) {
  val initMethod_Module = Init_Module(sigResources, initMethod)//, sigResources.typeRefTpes.moduleClass)

  val toStringMethod_Module = ToString_Module(sigResources, valueMembers, toStringMethod)
  val applyMethod = Apply(sigResources, valueMembers, initMethod)
  val UnapplyMethod = Unapply(sigResources, valueMembers, initMethod)//myPickleBuffer, valueMembers, initMethod, thisTpes_scala, typeRefTpes_option, extModClassRefs_scala)
  val readResolveMethod = ReadResolve(sigResources)//, typeRefTpes_obj, typeRefTpes_objectReadResolve)
}


