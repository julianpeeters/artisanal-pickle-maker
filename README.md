Artisinal-Pickle-Maker
======================

Make your own Scala pickled signatures. 

Takes class info as strings and gives back a pickled Scala signatures. For use with Java bytecode engineering libraries. 

Why? Because existing Java bytecode-engineering tools can't see or alter a pickled Scala signature, thus the altered classes are incomplete in cases where Scala code has no Java equivalent. Artisinal-Pickle-Maker hopes to solve this by updating an altered class's Scala signtature to reflect changes made to the bytecode.

##Usage:##
Add the following dependency to your `build.sbt` file:
`libraryDependencies += "com.julianpeeters" %% "artisinal-pickle-maker" % "0.3-SNAPSHOT"`

Get an `artisinal.pickle.maker.ScalaSig` with:  
`val scalaSig = new ScalaSig(List("case class"), List("models", "MyRecord"), List(("x", "String"), ("y", "Int"))`

`scalaSig.bytes` gives the encoded bytes as a UTF-8 String. This is the normal storage format of a natural pickled Scala signature.

Thus, `scalaSig.bytes` generates a ScalaSig identical to one that of: 
'package models
case class MyRecord(x: String, y: Int)'

##Currently supports:##
  _Potential Use Cases_ - Are you generating Scala Classes with ASM? Do you have an ASMified class template? Then add desired and make your class whole!

  _Classes_ - The generation of Scala sigs for regular and case classes *that have value members only* (signatures will not reflect user-defined defs, i.e., this doesn't yet support classes with defs!).

  _Datatypes_ - All basic Scala datatypes (but see the note below on pickling)

  _Scala Version_ - Reproduces a Scala 2.10.2 signature byte-for-byte.

( May serve as a signature for Scala 2.9.1 depending on how you need to use it, but be warned: some of the signature for a given class does indeed differ between versions.)

##In the future:##

  _Datatypes_ - Support for collections, custom classes.

  _Method Members_ - Support for user defined defs(?).

  _Classes_ - Support for flags other than "case class"(?).

  _Integration_ - Javassist(?), ASM for dynamic case class generation.


####PS#### I'm relatively new at all this, so any constructive advice is appreciated!
-Julian
