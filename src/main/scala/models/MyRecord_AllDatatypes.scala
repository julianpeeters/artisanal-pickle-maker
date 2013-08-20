package models

case class MyRecord_AllDatatypes(
  a: Byte,
  b: Short,
  c: Int,
  d: Long,
  e: Float,
  f: Double,
  g: Char,
  h: String,
  i: Boolean,
  j: Unit,
  k: Null,
  l: Nothing,
  m: Any,
  n: AnyRef
)

case class MyRecord_Byte(a: Byte)
case class MyRecord_Short(b: Short)
case class MyRecord_Int(c: Int)
case class MyRecord_Long(d: Long)
case class MyRecord_Float(e: Float)
case class MyRecord_Double(f: Double)
case class MyRecord_Char(g: Char)
case class MyRecord_String(h: String)
case class MyRecord_Boolean(i: Boolean)
case class MyRecord_Unit(j: Unit)
case class MyRecord_Null(k: Null)
case class MyRecord_Nothing(l: Nothing)
case class MyRecord_Any(m: Any)
case class MyRecord_AnyRef(n: AnyRef)
