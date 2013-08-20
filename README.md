Artisinal-Pickle-Maker
======================

Make your own Scala pickled signatures. 

Takes class info as strings and gives back a pickled Scala signatures. For use with Java bytecode engineering libraries. 

Why? Because existing Java bytecode-engineering tools can't see or alter a pickled Scala signature, and thus leave stuff out.

##Currently supports:##
  _Use Cases_ - 1) Pickle the signtature and add it to an ASMified dynamic class template. 2) Pickle the Signature and use Javassist to alter an existing class and replace its annotation with onen containing the new pickled Scala Signature.

  _Classes_ - The generation of Scala sigs for regular and case classes *that have value members only* (signatures will not reflect user-defined defs, i.e., no defs!).

  _Datatypes_ - All basic Scala datatypes //TODO most need tests!

##In the future:##
  _Pickling_ - currently we only generate an unpickled signature, but pickling is straigtforward.

  _Datatypes_ - Collections, custom classes.

  _Method Members_ - Support for user defined defs(?).

  _Classes_ - Support for flags other than "case class"(?).

  _Integration_ - Javassist(?), ASM for dynamic case class generation.

  _Documentation_ - Better examples.
