package artisanal.pickle.maker 
package stores
import tags._
import scala.reflect.internal.pickling._
import java.util.concurrent.ConcurrentHashMap

case class ExtModClassRefStore {

   val owners: scala.collection.concurrent.Map[String,  ExtModClassRef_topLevel] = scala.collection.convert.Wrappers.JConcurrentMapWrapper(new ConcurrentHashMap[String,  ExtModClassRef_topLevel]())

  def accept(owner: ExtModClassRef_topLevel) {
    if (!owners.contains(owner.ownerName)) {
      owners += owner.ownerName -> owner
    }
  }
}
