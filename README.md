Artisinal-Pickle-Maker
======================

Make your own Scala pickled signatures. 

Takes class info as strings and gives back a pickled Scala signatures. For use with Java bytecode engineering libraries. 

Why? Because existing Java bytecode-engineering tools can't see or alter a pickled Scala signature, thus the altered classes are incomplete in cases where Scala code has no Java equivalent. Artisinal-Pickle-Maker hopes to solve this by updating an altered class's Scala signtature to reflect changes made to the bytecode.

##Currently supports:##
  _Potential Use Cases_ - 

  1) ASM: Generating Scala Classes? Have an ASMified class template? Pickle your desired signtature and add it to the class generator template. 

  2) Javassist:  Adding value members to an existing class? Use Javassist to alter an existing class, then read and update its Scala signature annotation with with your custom pickled Scala Signature.

  _Classes_ - The generation of Scala sigs for regular and case classes *that have value members only* (signatures will not reflect user-defined defs, i.e., this doesn't yet support classes with defs!).

  _Datatypes_ - All basic Scala datatypes

##In the future:##
  _Pickling_ - currently we only generate an unpickled signature, but pickling is straigtforward.

  _Datatypes_ - Collections, custom classes.

  _Method Members_ - Support for user defined defs(?).

  _Classes_ - Support for flags other than "case class"(?).

  _Integration_ - Javassist(?), ASM for dynamic case class generation.

  _Documentation_ - Better examples.


####PS#### I'm relatively new at all this, so any constructive advice is appreciated!
-Julian
