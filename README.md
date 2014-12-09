Artisanal-Pickle-Maker
======================

Make your own Scala pickled signatures. 

Takes class info as strings and gives back pickled Scala signatures. For use with Java bytecode engineering libraries. 

Why? Because existing Java bytecode-engineering tools can't see or alter a pickled Scala signature, thus the altered classes are incomplete in cases where Scala code has no Java equivalent. Artisanal-Pickle-Maker hopes to solve this by updating an altered class's Scala signtature to reflect changes made to the bytecode.

##Usage:##
Available for Scala 2.10 and 2.11 (see branches for other releases).

Add the following dependency to your `build.sbt` file:


`libraryDependencies += "com.julianpeeters" %% "artisanal-pickle-maker" % "0.9.0"`

Get an `artisanal.pickle.maker.ScalaSig` with: 

 
`val scalaSig = new ScalaSig(List("case class"), List("mypackage", "MyRecord"), List(("x", "String"), ("y", "Option[Int]"))`

`scalaSig.bytes` gives the encoded bytes as a UTF-8 String. This is the normal storage format of a natural pickled Scala signature.

Thus, `scalaSig.bytes` is identical to the encoded string that would be found in the `ScalaSignature` annotation of the conventionally defined class:


        `package models`
        `case class MyRecord(x: String, y: Option[Int])`

##Currently supports:##
  Are you generating or modifying Scala classes with ASM or another bytecode engineering library? Then add an updated pickled sig and make your class whole!

  _Classes_ - The generation of Scala sigs for regular and case classes *that have value members only* (signatures will not reflect user-defined defs, i.e., this doesn't yet support classes with defs due to concerns of hygiene).

  _Datatypes_ - 

* Byte
* Short
* Int
* Long
* Float
* Double
* Char
* String
* Boolean
* Null
* Nothing*
* Any
* AnyRef
* List
* Option
* user-defined (i.e. other classes)





##In the future:##

  _Datatypes_ - Support for more collections besides just `List` and `Option`.

  _Extension_ - Support for flags that allow arbitrary extension(?)

  _Classes_ - Support for flags other than "case class"(?).


##Constructive advice is appreciated!##

