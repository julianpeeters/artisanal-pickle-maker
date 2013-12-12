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
  n: Byte,
  o: Object)

//user-defined
case class MyRec(x: String)
case class MyRecord_User(myRec: MyRec)

//single value member
case class MyRecord_Byte(a: Byte)
case class MyRecord_Short(b: Short)
case class MyRecord_Int(c: Int)
case class MyRecord_I(c: Int)
case class MyRecord_In(c: Int)
case class MyRecord_Ins(c: Int)
case class MyRecord_Ints(c: Int)
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

case class MyRecord_Object(o: Object)

case class MyRecord_ListString(pp: List[String])
case class MyRecord_ListInt(po: List[Int])
case class MyRecord_ListByte(q: List[Byte])
case class MyRecord_ListShort(r: List[Short])
case class MyRecord_ListLong(s: List[Long])
case class MyRecord_ListFloat(t: List[Float])
case class MyRecord_ListDouble(u: List[Double])
case class MyRecord_ListChar(v: List[Char])

case class MyRecord_ListBoolean(x: List[Boolean])
case class MyRecord_ListUnit(y: List[Unit])
case class MyRecord_ListNull(z: List[Null])


//////////////////////////////////////////////////////////TODO TESTS + ALL TEH LIST ONES FOR Double value members
case class MyRecord_ListNothing(aa: List[Nothing])
case class MyRecord_ListAny(ab: List[Any])
case class MyRecord_ListAnyRef(ac: List[AnyRef])

case class MyRecord_ListObject(ad: List[Object])
case class MyRecord_ListUser1(ae: List[MyRec])
case class MyRecord_ListUser2(af: List[MyRecord_User])

case class MyRecord_ListListUser1(ag: List[MyRec])
case class MyRecord_ListListUser2(ah: List[MyRecord_User])
case class MyRecord_ListListString(p: List[List[String]])
case class MyRecord_ListListInt(ai: List[List[Int]])
/////////////////////////////////////////////////////////////////




//double value member
case class MyRecord_ByteByte(a1: Byte, a2: Byte)
case class MyRecord_ShortShort(b1: Short, b2: Short)
case class MyRecord_IntInt(c1: Int, c2: Int)
case class MyRecord_LongLong(d1: Long, d2: Long)
case class MyRecord_FloatFloat(e1: Float, e2: Float)
case class MyRecord_DoubleDouble(f1: Double, f2: Double)
case class MyRecord_CharChar(g1: Char, g2: Char)
case class MyRecord_StringString(h1: String, h2: String)
case class MyRecord_BooleanBoolean(i1: Boolean, i2: Boolean)
case class MyRecord_UnitUnit(j1: Unit, j2: Unit)
case class MyRecord_NullNull(k1: Null, k2: Null)
case class MyRecord_NothingNothing(l1: Nothing, l2: Nothing)
case class MyRecord_AnyAny(m1: Any, m2: Any)
case class MyRecord_AnyRefAnyRef(n1: AnyRef, n2: AnyRef)

case class MyRecord_ObjectObject(o1: Object, o2:Object)

case class MyRecord_ListStringListString(p1: List[String], p2: List[String])
case class MyRecord_StringListString(pp1: String, pp2: List[String])
case class MyRecord_ListStringString(po1: List[String], po2: String)

//triple value member
case class MyRecord_ByteByteByte(a1: Byte, a2: Byte, a3: Byte)
case class MyRecord_ShortShortShort(b1: Short, b2: Short, b3: Short)
case class MyRecord_IntIntInt(c1: Int, c2: Int, c3: Int)
case class MyRecord_LongLongLong(d1: Long, d2: Long, d3: Long)
case class MyRecord_FloatFloatFloat(e1: Float, e2: Float, e3: Float)
case class MyRecord_DoubleDoubleDouble(f1: Double, f2: Double, f3: Double)
case class MyRecord_CharCharChar(g1: Char, g2: Char, g3: Char)
case class MyRecord_StringStringString(h1: String, h2: String, h3: String)
case class MyRecord_BooleanBooleanBoolean(i1: Boolean, i2: Boolean, i3: Boolean)
case class MyRecord_UnitUnitUnit(j1: Unit, j2: Unit, j3: Unit)
case class MyRecord_NullNullNull(k1: Null, k2: Null, k3: Null)
case class MyRecord_NothingNothingNothing(l1: Nothing, l2: Nothing, l3: Nothing)
case class MyRecord_AnyAnyAny(m1: Any, m2: Any, m3: Any)
case class MyRecord_AnyRefAnyRefAnyRef(n1: AnyRef, n2: AnyRef, n3: AnyRef)

case class MyRecord_ObjectObjectObject(o1: Object, o2:Object, o3: Object)

case class MyRecord_StringIntBoolean(x: String, y: Int, z: Boolean)

//quadruple value member
case class MyRecord_ByteByteByteByte(a1: Byte, a2: Byte, a3: Byte, a4: Byte)

//quintuple value member
case class MyRecord_ByteByteByteByteByte(a1: Byte, a2: Byte, a3: Byte, a4: Byte, a5: Byte)
