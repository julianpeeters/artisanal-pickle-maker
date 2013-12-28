package artisanal.pickle.maker 
package types
import tags._
import scala.reflect.internal.pickling._
import java.util.concurrent.ConcurrentHashMap

object TypeStore {

   val types: scala.collection.concurrent.Map[String, Tpe] = scala.collection.convert.Wrappers.JConcurrentMapWrapper(new ConcurrentHashMap[String, Tpe]())

  def accept(tpe: Tpe) {
    if (!types.contains(tpe.typeName)) {
      types += tpe.typeName -> tpe
    }
  }
}
