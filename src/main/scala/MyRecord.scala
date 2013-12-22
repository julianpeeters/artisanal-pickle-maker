package models

case class MyRec(x: String)


case class MyRecord_StringListStringUserListUser(mmm4: List[MyRec], mmm5: MyRecord_User)
case class MyRecord_User(myRec: MyRec)


case class MyRecord_ListBoolean(x: List[Boolean])
case class MyRecord_ListUnit(y: List[Unit])
case class MyRecord_ListNull(z: List[Null])

case class MyRecord_ListString(pp: List[String])
case class MyRecord_ListInt(po: List[Int])
case class MyRecord_ListStringString(po1: List[String], po2: String)
case class MyRecord_ListStringListString(p1: List[String], p2: List[String])
case class MyRecord_StringListString(pp1: String, pp2: List[String])

case class MyRecord_UserUser(myRec1: MyRec, myRec2: MyRec)

case class MyRecord_ListUserListUser(lu1: List[MyRecord_User], lu2: List[MyRecord_User])
case class MyRecord_UserListUser(ulu1: MyRec, ulu2: List[MyRec])
case class MyRecord_ListUserUser(luu1: List[MyRecord_User], luu2: MyRecord_User)



case class MyRecord_ListStringListInt(ps1: List[String], pi2: List[Int])
case class MyRecord_IntListInt(pt1: Int, pt2: List[Int])
case class MyRecord_ListIntInt(pu1: List[Int], pu2: Int)

case class MyRecord_ListListUser1(ag: List[List[MyRec]])
case class MyRecord_ListListUser2(ah: List[List[MyRecord_User]])
case class MyRecord_ListListString(p: List[List[String]])
case class MyRecord_ListListInt(ai: List[List[Int]])
