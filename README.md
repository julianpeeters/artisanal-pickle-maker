Artisinal-Pickle-Maker
======================

Make your own Scala pickled signatures. 

Takes class info as strings and gives back a pickled Scala signatures. For use with Java bytecode engineering libraries. 

Currently supports:
  Classes - Regular and case classes, *having value members only* (signatures will not reflect user-defined defs, i.e., no defs!).
  Datatypes - Basic Scala datatypes //TODO most need tests!

In the future:
  Datatypes - Collections, custom classes
  Method Members - Support for user defined defs(?)
  Classes - Support for flags other than "case class"(?)
  Integration - Javassist(?), ASM for dynamic case class generation
  Documentation - Better examples 
