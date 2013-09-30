package avocet
package methods
package cls

import tags._
import types._
import scala.reflect.generic._

case class Init(sigResources: SigResources, valueMembers: List[ValueMember]) {

  var valSymPosition = 0
  var termNamePosition = 0
  val typeRefTpePosition = Position.current + 3

    valSymPosition = Position.current
    ValSym(Position.current + 1, ClassSym.position, 512L, Position.current + 2).write(sigResources.myPickleBuffer)
    termNamePosition = Position.current
    TermName("<init>").write(sigResources.myPickleBuffer)
   
    
    val paramPositions = (1 to valueMembers.length).toList.map(vm => Position.current + 2 + vm)


    sigResources.thisTpes.owner.position match {//ThisTpe_owner should already have been written if the member's type is custom and local
      case 0      => {
        MethodTpe(Position.current + 1 :: paramPositions).write(sigResources.myPickleBuffer);
        sigResources.typeRefTpes.modelsMyRecord.write(sigResources.myPickleBuffer);
        sigResources.thisTpes.owner.write(sigResources.myPickleBuffer, sigResources.extModClassRefs.owner) 
      }
      case i: Int => { // is already defined, so won't need to be defined next
        MethodTpe(List(Position.current + 1, Position.current + 2)).write(sigResources.myPickleBuffer); 
        sigResources.typeRefTpes.modelsMyRecord.write(sigResources.myPickleBuffer) 
      }
    } 

  valueMembers.foreach(vm => ValSym(vm.termNamePosition, valSymPosition, 8192L, vm.typeRefPosition).write(sigResources.myPickleBuffer))

  
}
