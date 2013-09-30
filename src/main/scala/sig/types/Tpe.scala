package avocet 
package types
import scala.reflect.internal.pickling._

trait Tpe {
  var polyTpePosition: Int
  var position: Int
  def write(myPickleBuffer: PickleBuffer): Unit
}


