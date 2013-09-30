package avocet 
package types
import scala.reflect.generic._

trait Tpe {
  var polyTpePosition: Int
  var position: Int
  def write(myPickleBuffer: PickleBuffer): Unit
}


