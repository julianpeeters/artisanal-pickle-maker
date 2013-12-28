package artisanal.pickle.maker 
package types
import tags._
import scala.reflect.internal.pickling._
import java.util.concurrent.ConcurrentHashMap

object ValueMemberStore {

   val valueMembers: scala.collection.concurrent.Map[String, ValueMember] = scala.collection.convert.Wrappers.JConcurrentMapWrapper(new ConcurrentHashMap[String, ValueMember]())

  def accept(valueMember: ValueMember) {
    if (!valueMembers.contains(valueMember.tpeName)) {
      valueMembers += valueMember.tpeName -> valueMember
    }
  }
}
