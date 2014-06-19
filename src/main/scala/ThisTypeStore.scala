package artisanal.pickle.maker 

import tags._
import scala.reflect.internal.pickling._
import java.util.concurrent.ConcurrentHashMap

object ThisTypeStore {

   val owners: scala.collection.concurrent.Map[String,  ThisTpe_owner_] = scala.collection.convert.Wrappers.JConcurrentMapWrapper(new ConcurrentHashMap[String,  ThisTpe_owner_]())

  def accept(owner: ThisTpe_owner_) {
    if (!owners.contains(owner.thisTypeName)) {
      owners += owner.thisTypeName -> owner
    }
  }
}
