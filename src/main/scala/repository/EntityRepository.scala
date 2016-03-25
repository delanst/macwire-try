package repository

/**
  * Entity repository that has two implementations (default and special).
  */

trait EntityRepository {

  def findEntity(id : Int) : String

}

class DefaulEntityRepository extends EntityRepository {
  override def findEntity(id: Int): String = {
    println(s"find person with $id")
    id.toString
  }
}

class SpecialEntityRepository extends EntityRepository {
  override def findEntity(id: Int): String = {
    println(s"Special find person with $id")
    id.toString
  }
}
