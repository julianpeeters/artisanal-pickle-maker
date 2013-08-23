package avocet
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._

class Entries(sigResources: SigResources, flags: List[String], names: List[String], args: List[(String, String)]) {
//write the class info
  val classInfo = ClassInfo(sigResources, flags, names)

//write the value members
  val valueMembers = args.map(arg => new ValueMember(sigResources.myPickleBuffer, arg._1, arg._2, sigResources.typeRefTpes))

//write the <init> method
  val initMethod = Init(sigResources, valueMembers)

//then we're done unless there are flags
  if (flags.contains("case class")) {
//write the class methods that case classes give us for free
    val caseClassMethods = new CaseClassMethods(sigResources, valueMembers)

//write module  (i.e. companion object methods) that we get for free with a case class
    val moduleSig = new ModuleSig(sigResources, names, valueMembers, initMethod, caseClassMethods)
  }
}

