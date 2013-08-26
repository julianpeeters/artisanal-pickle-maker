package avocet
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._


class ModuleMethods(sigResources: SigResources, valueMembers: List[ValueMember], initMethod: Init, toStringMethod: ToString) {
/*
  myPickleBuffer: PickleBuffer, 
  valueMembers: List[ValueMember], 
  initMethod: Init, 
  toStringMethod: ToString, 
  moduleClass: TypeRefTpe_moduleClass, 
  thisTpes_scala: ThisTpe_scala, 
  typeRefTpes_option: TypeRefTpe_Option, 
  extModClassRefs_scala: ExtModClassRef_scala, 
  typeRefTpes_obj: TypeRefTpe_Object, 
  typeRefTpes_objectReadResolve: TypeRefTpe_ObjectReadResolve
  ) {

    val initMethod_Module = Init_Module(myPickleBuffer, initMethod, moduleClass)
    val toStringMethod_Module = ToString_Module(myPickleBuffer, valueMembers, toStringMethod)
    val applyMethod = Apply(myPickleBuffer, valueMembers, initMethod)
    val UnapplyMethod = Unapply()myPickleBuffer, valueMembers, initMethod, thisTpes_scala, typeRefTpes_option, extModClassRefs_scala)
    val readResolveMethod = ReadResolve(myPickleBuffer, typeRefTpes_obj, typeRefTpes_objectReadResolve)
*/

    val initMethod_Module = Init_Module(sigResources, initMethod)//, sigResources.typeRefTpes.moduleClass)
    val toStringMethod_Module = ToString_Module(sigResources, valueMembers, toStringMethod)
    val applyMethod = Apply(sigResources, valueMembers, initMethod)
    val UnapplyMethod = Unapply(sigResources, valueMembers, initMethod)//myPickleBuffer, valueMembers, initMethod, thisTpes_scala, typeRefTpes_option, extModClassRefs_scala)
    val readResolveMethod = ReadResolve(sigResources)//, typeRefTpes_obj, typeRefTpes_objectReadResolve)
}


