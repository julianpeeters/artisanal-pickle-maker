package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.internal.pickling._

case class CopyDefault(myPickleBuffer: PickleBuffer, valueMembers: List[ValueMember], UncheckedVariance: TypeRefTpe_UncheckedVariance, annotInfo: AnnotInfo) {

  val valSymPosition = Position.current

  valueMembers.length match {
    case 1 => {
      ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(myPickleBuffer)
      TermName("copy$default$1").write(myPickleBuffer)
      PolyTpe(Annotation(valueMembers(0), annotInfo)).write(myPickleBuffer)
      Annotation(valueMembers(0), annotInfo).write(myPickleBuffer)
      UncheckedVariance.write(myPickleBuffer)
    }

    case x if x > 1 => {
      ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(myPickleBuffer)
      TermName("copy$default$1").write(myPickleBuffer)
      PolyTpe(Annotation(valueMembers(0), annotInfo)).write(myPickleBuffer)
      Annotation(valueMembers(0), annotInfo).write(myPickleBuffer)
      UncheckedVariance.write(myPickleBuffer)
      (2 to valueMembers.length).foreach(member => CopyDefault_plural(member))
    }
    case _ => println("what, no value members?")
  }

  def CopyDefault_plural(member: Int) = {
    ValSym(Position.current + 1, ClassSym.position, 35652096L, Position.current + 2).write(myPickleBuffer)
    TermName("copy$default$" + member).write(myPickleBuffer)
    PolyTpe(Annotation(valueMembers(member-1), annotInfo)).write(myPickleBuffer)
    Annotation(valueMembers(member-1), annotInfo).write(myPickleBuffer)
  }
}
