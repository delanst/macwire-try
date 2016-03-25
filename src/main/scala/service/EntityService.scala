package service

import com.softwaremill.macwire.Macwire
import repository.{DefaulEntityRepository, SpecialEntityRepository}

/**
  * An entity service service injecting an instance of default entity repository and a special entity repository.
  * The wire macro creates a new instance of the specified type.
  */
trait EntityService extends Macwire {

  def entityRepository = wire[DefaulEntityRepository]
  def specialEntityRepository = wire[SpecialEntityRepository]

  def findEntity(id : Int) : String
  def findSpecialEntity(id : Int) : String
}

class DefaultEntityService extends EntityService {

  override def findEntity(id: Int): String = {
    entityRepository.findEntity(id)
  }

  override def findSpecialEntity(id: Int): String = {
    specialEntityRepository.findEntity(id)
  }
}
