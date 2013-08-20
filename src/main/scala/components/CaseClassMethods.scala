package avocet
import methods.cls._
import methods.module._
import scala.reflect.internal.pickling._

import tags._
import types._

class CaseClassMethods(sigResources: SigResources, valueMembers: List[ValueMember]) {
//write class methods that we get for free with a case class
  val copyMethod = Copy(
    sigResources.myPickleBuffer, 
    valueMembers, 
    sigResources.typeRefTpes.modelsMyRecord)
  val copyDefaultMethod = CopyDefault(
    sigResources.myPickleBuffer, 
    valueMembers, 
    sigResources.typeRefTpes.uncheckedVariance, 
    sigResources.typeRefTpes.annotInfo)
  val productPrefixMethod = ProductPrefix(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.javaLangString, 
    sigResources.thisTpes.javaLang, 
    sigResources.typeRefTpes.string, 
    sigResources.extModClassRefs.lang, 
    sigResources.extModClassRefs.java)
  val productArityMethod = ProductArity(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.int)
  val productElementMethod = ProductElement(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.any, 
    sigResources.typeRefTpes.int)
  val productIteratorMethod = ProductIterator(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.iterator)
  val canEqualMethod = CanEqual(
    sigResources.myPickleBuffer, 
    productElementMethod, 
    sigResources.typeRefTpes.boolean, 
    sigResources.typeRefTpes.any)
  val hashCodeMethod = HashCode(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.int)
  val toStringMethod = ToString(
    sigResources.myPickleBuffer, 
    sigResources.typeRefTpes.javaLangString)
  val equalsMethod  = Equals(
    sigResources.myPickleBuffer, 
    productElementMethod, 
    sigResources.typeRefTpes.boolean, 
    sigResources.typeRefTpes.any)
}
