Artisinal-Pickle-Maker
======================

Make your own Scala pickled signatures. 

Takes class info as strings and gives back a pickled Scala signatures. For use with Java bytecode engineering libraries. 

##Currently supports:##
  _Classes_ - Both regular and case classes *that have value members only* (signatures will not reflect user-defined defs, i.e., no defs!)

  _Datatypes_ - Basic Scala datatypes //TODO most need tests!


##In the future:##
  _Datatypes_ - Collections, custom classes

  _Method Members_ - Support for user defined defs(?)

  _Classes_ - Support for flags other than "case class"(?)

  _Integration_ - Javassist(?), ASM for dynamic case class generation

  _Documentation_ - Better examples 
