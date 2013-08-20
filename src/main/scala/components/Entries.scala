package avocet
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._

class Entries(sigResources: SigResources, flags: List[String], names: List[String], args: List[(String, String)]) {

  val classInfo = ClassInfo(sigResources, flags, names)

  val valueMembers = args.map(arg => new ValueMember(sigResources.myPickleBuffer, arg._1, arg._2, sigResources.typeRefTpes))
  val initMethod = Init(
    sigResources.myPickleBuffer, 
    valueMembers, 
    sigResources.typeRefTpes.modelsMyRecord, 
    sigResources.thisTpes.owner, 
    sigResources.extModClassRefs.owner)

  if (flags.contains("case class")) {
//write the class methods that case classes give us for free
    val caseClassMethods = new CaseClassMethods(sigResources, valueMembers)

//write module  (i.e. companion object methods) that we get for free with a case class
    val moduleSig = new ModuleSig(sigResources, names, valueMembers, initMethod, caseClassMethods)
  }
}

