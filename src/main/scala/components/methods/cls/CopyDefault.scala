package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.internal.pickling._

case class CopyDefault(sigResources: SigResources, valueMembers: List[ValueMember]) {

  val valSymPosition = Position.current

  valueMembers.length match {
    case 1 => {
      ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
      TermName("copy$default$1").write(sigResources.myPickleBuffer)
      PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
      Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
      sigResources.typeRefTpes.uncheckedVariance.write(sigResources.myPickleBuffer)
    }

    case x if x > 1 => {
      ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
      TermName("copy$default$1").write(sigResources.myPickleBuffer)
      PolyTpe(Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
      val annotation = Annotation(valueMembers(0), sigResources.typeRefTpes.annotInfo)
      annotation.write(sigResources.myPickleBuffer)
      sigResources.typeRefTpes.uncheckedVariance.write(sigResources.myPickleBuffer)
      (2 to valueMembers.length).foreach(member => CopyDefault_plural(member, annotation))
    }
    case _ => println("what, no value members?")
  }

  def CopyDefault_plural(member: Int, annotation: Annotation) = {
    annotation.polyTpePosition match {
      case 0       => {
        ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(sigResources.myPickleBuffer)
        TermName("copy$default$" + member).write(sigResources.myPickleBuffer)
        PolyTpe(Annotation(valueMembers(member-1), sigResources.typeRefTpes.annotInfo)).write(sigResources.myPickleBuffer)
        Annotation(valueMembers(member-1), sigResources.typeRefTpes.annotInfo).write(sigResources.myPickleBuffer)
      } 
      case i: Int =>      
        ValSym(Position.current + 1, ClassSym.position, 35652096L, i).write(sigResources.myPickleBuffer)
        TermName("copy$default$" + member).write(sigResources.myPickleBuffer)
    }
  }
}
