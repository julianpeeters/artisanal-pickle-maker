package artisanal.pickle.maker 
package stores

case class Stores(
  extModClassRefStore: ExtModClassRefStore, 
  thisTypeStore: ThisTypeStore, 
  typeStore: TypeStore, 
  valueMemberStore: ValueMemberStore)
