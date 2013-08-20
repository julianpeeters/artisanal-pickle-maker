package avocet 
package types
import tags._
import scala.reflect.internal.pickling._

case class Annotation(valueMember: ValueMember, annotInfo: AnnotInfo) extends Tpe {
  var position = 0
  var polyTpePosition = 0
  def write(myPickleBuffer: PickleBuffer) = {
    position = Position.current

    AnnotatedTpe(valueMember, annotInfo).write(myPickleBuffer)
    annotInfo.position match {
      case 0 => annotInfo.write(myPickleBuffer)
      case _ =>
    }
  
  }
}

