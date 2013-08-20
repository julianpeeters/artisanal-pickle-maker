package avocet
package tags
import scala.reflect.internal.pickling._

case class TypeRefTpe_nonGeneric(ownerRef: Int, extRef: Int) {
  val args = List(ownerRef, extRef)
  def writeEntry(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(16)
  //len
    myPickleBuffer.writeNat(2 + args.filter(arg => arg > 127).length)
  //data {
    //refs             
      args.foreach(arg => myPickleBuffer.writeNat(arg))
    //}
      Position.current += 1
  }
}

case class TypeRefTpe_generic(ownerRef: Int, ExtRef: Int, boxedTypeRef: Int) {
  val args = List(ownerRef, ExtRef, boxedTypeRef)
  def writeEntry(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(16)
  //len
    myPickleBuffer.writeNat(3 + args.filter(arg => arg > 127).length)
  //data {
    //ref to type
      args.foreach(arg => myPickleBuffer.writeNat(arg))
  //}
      Position.current += 1
  }
}
 
case class TypeRefTpe_function(runtimeRef: Int, abstractFunctionExtRef: Int, memberTypeRefs: List[Int], modelMyRecordRef: Int) {
  val args = runtimeRef :: abstractFunctionExtRef :: modelMyRecordRef :: memberTypeRefs
  def writeEntry(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(16)
  //len
    myPickleBuffer.writeNat(3 + memberTypeRefs.length + args.filter(arg => arg > 127).length)
  //data {
    //
      myPickleBuffer.writeNat(runtimeRef)
    //
      myPickleBuffer.writeNat(abstractFunctionExtRef)
      memberTypeRefs.foreach(i => myPickleBuffer.writeNat(i))
      myPickleBuffer.writeNat(modelMyRecordRef)
  //}
      Position.current += 1
  }
}

case class TypeRefTpe_tuple(scalaThisTpeRef: Int, tupleExtRefRef: Int, memberTypeRefs: List[Int]) {
  val args = scalaThisTpeRef :: tupleExtRefRef :: memberTypeRefs
  def writeEntry(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(16)
  //len
    myPickleBuffer.writeNat(2 + memberTypeRefs.length + args.filter(arg => arg > 127).length)
  //data {
      args.foreach(arg => myPickleBuffer.writeNat(arg))
  //}
      Position.current += 1
  }
} 
 

case class TypeRefTpe_unapplyOption(scalaRef: Int, optionExtRef: Int, tupledValueMembersRef: Int) {
  val args = List(scalaRef, optionExtRef, tupledValueMembersRef)
  def writeEntry(myPickleBuffer: PickleBuffer)  = {
  //tag
    myPickleBuffer.writeByte(16)
  //len
    myPickleBuffer.writeNat(3 + args.filter(arg => arg > 127).length)
  //data {
    //reference to the owner, e.g. CLASSsym or "scala", an EXTMODCLASS                 
      args.foreach(arg => myPickleBuffer.writeNat(arg))
  //}
      Position.current += 1
  }
} 



