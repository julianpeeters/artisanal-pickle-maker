package avocet
package tags
import scala.reflect.generic._


case class ExtModClassRef_scala extends ExtModClassRef_topLevel
case class ExtModClassRef_owner extends ExtModClassRef_topLevel
case class ExtModClassRef_java  extends ExtModClassRef_topLevel

case class ExtModClassRef_predef     extends ExtModClassRef_nested_post
case class ExtModClassRef_package    extends ExtModClassRef_nested_post

case class ExtModClassRef_annotation extends ExtModClassRef_nested_annot//(Position.current + 1, ExtModClassRef_scala.position)
case class ExtModClassRef_collection extends ExtModClassRef_nested_annot//(Position.current + 1, ExtModClassRef_scala.position) 
case class ExtModClassRef_runtime    extends ExtModClassRef_nested_annot//(Position.current + 1, ExtModClassRef_scala.position)

case class ExtModClassRef_javaLang   extends ExtModClassRef_nested_javaLang//(Position.current + 1, Position.current + 2)
case class ExtModClassRef_unchecked  extends ExtModClassRef_nested_javaLang//(Position.current + 1, Position.current + 2)
case class ExtModClassRef_lang       extends ExtModClassRef_nested_javaLang//(Position.current + 1, Position.current + 2)

//object ExtModClassRef_root       extends ExtModClassRef_nested_root//(Position.current + 1, NoneSym.position)

class ExtModClassRef_topLevel{
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(10)
  //len
    if (Position.current + 1 > 127) myPickleBuffer.writeNat(2);  else myPickleBuffer.writeNat(1)
  //data {
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(Position.current + 1)
  //}
    Position.current += 1
  }
}

class ExtModClassRef_nested(nestedRef: Int, topLevelRef: Int){
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(10)
  //len
    if (nestedRef > 127 && topLevelRef > 127) myPickleBuffer.writeNat(4);  
    else if (nestedRef > 127 || topLevelRef > 127) myPickleBuffer.writeNat(3);  
    else myPickleBuffer.writeNat(2)
  //data {
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(nestedRef)
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(topLevelRef)
  //}
    Position.current += 1
  }
}

class ExtModClassRef_nested_post{
  var position = 0
  def write(myPickleBuffer: PickleBuffer, scala: ExtModClassRef_scala)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(10)
  //len
    if ((Position.current - 3) > 127 && scala.position > 127) myPickleBuffer.writeNat(4);  
    else if ((Position.current - 3) > 127 || scala.position > 127) myPickleBuffer.writeNat(3);  
    else myPickleBuffer.writeNat(2)
  //data {
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(Position.current - 3)
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(scala.position)
  //}
    Position.current += 1
  }
}

class ExtModClassRef_nested_annot{
  var position = 0
  def write(myPickleBuffer: PickleBuffer, scala: ExtModClassRef_scala)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(10)
  //len
    if ((Position.current + 1) > 127 && scala.position > 127) myPickleBuffer.writeNat(4);  
    else if ((Position.current + 1) > 127 || scala.position > 127) myPickleBuffer.writeNat(3);  
    else myPickleBuffer.writeNat(2)
  //data {
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(Position.current + 1)
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(scala.position)
  //}
    Position.current += 1
  }
}

class ExtModClassRef_nested_javaLang{
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(10)
  //len
    if ((Position.current + 1) > 127 && Position.current + 2 > 127) myPickleBuffer.writeNat(4);  
    else if ((Position.current + 1) > 127 || Position.current + 2 > 127) myPickleBuffer.writeNat(3);  
   else myPickleBuffer.writeNat(2)
  //data {
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(Position.current + 1)
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(Position.current + 2)
  //}
    Position.current += 1
  }
}
case class ExtModClassRef_root {
  var position = 0
  def write(myPickleBuffer: PickleBuffer, noneSym: NoneSym)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(10)
  //len
    if ((Position.current + 1) > 127 && noneSym.position > 127) myPickleBuffer.writeNat(4);  
    else if ((Position.current + 1) > 127 || noneSym.position > 127) myPickleBuffer.writeNat(3);  
    else myPickleBuffer.writeNat(2)
  //data {
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(Position.current + 1)
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(noneSym.position)
  //}
    Position.current += 1
  }
}
class ExtModClassRef_topLevel_class(ref: Int){
  var position = 0
  def write(myPickleBuffer: PickleBuffer)  = {
    position = Position.current
  //tag
    myPickleBuffer.writeByte(10)
  //len
    if (ref > 127) myPickleBuffer.writeNat(2);  else myPickleBuffer.writeNat(1)
  //data {
    //reference to the next entry, TERMname 
    myPickleBuffer.writeNat(ref)
  //}
    Position.current += 1
  }
}
