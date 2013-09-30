package avocet
import tags._
import types._
import scala.reflect.generic._

case class ClassInfo(sigResources: SigResources, flags: List[String], names: List[String]) {
//entry 0 CLASSsym 
  ClassSym.write(sigResources.myPickleBuffer)
//entry 1
  TypeName(names(1)).write(sigResources.myPickleBuffer)
//entry 2 EXTMODCLASSref: the immediate enclosing package 
  sigResources.extModClassRefs.owner.write(sigResources.myPickleBuffer)
//entry 3 TERMname of Ext Mod: the immediate owner's name, i.e. the name of the immediate enclosing package
  names.length match {
    case 1          =>  TermName("<empty>").write(sigResources.myPickleBuffer)        //if there is only one name in the fullName list
    case x if x > 1 =>  TermName(names(0)).write(sigResources.myPickleBuffer)   
    case _          =>  println("whoops, no class name?")
  }
//entry 4 NONEsym
  sigResources.typeRefTpes.noneSym.write(sigResources.myPickleBuffer)
//entry 5 CLASSINFOtpe
  if (flags.contains("case class")) {
    CaseClassInfoTpe(sigResources.typeRefTpes.anyRef, sigResources.typeRefTpes.product, sigResources.typeRefTpes.serializable).write(sigResources.myPickleBuffer)
  //entry 6 TYPEREFtpe
    sigResources.typeRefTpes.anyRef.write(sigResources.myPickleBuffer)
  //entry 12 TYPEREFtpe: Product
    sigResources.typeRefTpes.product.write(sigResources.myPickleBuffer)
  //entry 15 TYPEREFtpe: Serializable
    sigResources.typeRefTpes.serializable.write(sigResources.myPickleBuffer)
  }
  else {
    ClassInfoTpe(sigResources.typeRefTpes.anyRef).write(sigResources.myPickleBuffer)
  //entry 6 TYPEREFtpe
    sigResources.typeRefTpes.anyRef.write(sigResources.myPickleBuffer)
  //entry 12 TYPEREFtpe: Product
  }
}
