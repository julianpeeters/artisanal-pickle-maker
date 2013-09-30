Artisinal-Pickle-Maker
======================

Make your own Scala pickled signatures. 

Takes class info as strings and gives back a pickled Scala signatures. For use with Java bytecode engineering libraries. 

Why? Because existing Java bytecode-engineering tools can't see or alter a pickled Scala signature, thus the altered classes are incomplete in cases where Scala code has no Java equivalent. Artisinal-Pickle-Maker hopes to solve this by updating an altered class's Scala signtature to reflect changes made to the bytecode.

Not yet published anywhere, sorry. You'll have to do `sbt publish-local` to try it out.

##Currently supports:##
  _Potential Use Cases_ - Generating Scala Classes with ASM? Have an ASMified class template? Pickle your desired signtature and add it to the class generator template. 

  _Classes_ - The generation of Scala sigs for regular and case classes *that have value members only* (signatures will not reflect user-defined defs, i.e., this doesn't yet support classes with defs!).

  _Datatypes_ - All basic Scala datatypes (but see the note below on pickling)

  _Scala Version_ - Reproduces a Scala 2.10.2 signature byte-for-byte. May serve as a signature for Scala 2.9.1 depending on how you need to use it, but be warned: some of the signature for a given class does indeed differ between versions.

##In the future:##
  _Pickling_ - Artisinal-Pickle-Maker only generates an unpickled signature, and despite being able to generate the unpickled signature byte-for-byte, pickling succeeds on classes of only a couple fields and only of types Int String and Boolean. Thus this encoding bug needs to be fixed, allowing the number of fields to be increased to the 22-field max for case classes.

  _Datatypes_ - Collections, custom classes.

  _Method Members_ - Support for user defined defs(?).

  _Classes_ - Support for flags other than "case class"(?).

  _Integration_ - Javassist(?), ASM for dynamic case class generation.

  _Documentation_ - Better examples.


####PS#### I'm relatively new at all this, so any constructive advice is appreciated!
-Julian
