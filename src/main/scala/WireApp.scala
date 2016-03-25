import com.softwaremill.macwire.Macwire
import service.DefaultEntityService

/**
  * Here we hav an app that wire a default entity service in the app. This could could be any kind of construction
  * you wish (examples are a akka actor or a play controller).
  */

object WireApp extends App with Macwire {

  def softLinkService = wire[DefaultEntityService]

  softLinkService.findEntity(23)
  softLinkService.findSpecialEntity(24)
}
