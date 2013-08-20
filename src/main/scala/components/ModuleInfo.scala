package avocet 
import tags._
import types._
import scala.reflect.internal.pickling._

class ModuleInfo(myPickleBuffer: PickleBuffer, names: List[String], valueMembers: List[ValueMember], moduleClass: TypeRefTpe_moduleClass, modelsMyRecord: TypeRefTpe_modelsMyRecord, thisTpe_runtime: ThisTpe_runtime, runtime: ExtModClassRef_runtime, scala: ExtModClassRef_scala) {
  ModuleSym.write(myPickleBuffer)
  names.length match {
    case 1          => TermName(names(0)).write(myPickleBuffer)
    case x if x > 1 => TermName(names(1)).write(myPickleBuffer) 
    case _          => println("whoops, no class name?")
  }
  moduleClass.write(myPickleBuffer)
  ClassSym_Module.write(myPickleBuffer)
  ClassInfoTpe_Module(valueMembers, modelsMyRecord, thisTpe_runtime, runtime, scala).write(myPickleBuffer)
  TypeRefTpe_AbstractFunction(valueMembers, modelsMyRecord, thisTpe_runtime, runtime, scala).write(myPickleBuffer)
}
