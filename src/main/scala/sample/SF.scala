package sample

import com.softwaremill.macwire.Macwire

/**
  * Sample of Macwire DI from Adam Warski presentation.
  */
object SF extends App with Macwire {

  case class Field()
  case class Digger()
  case class PotatoFarm(field : Field, digger : Digger) {
    println("New potato farm! Rejoice!")
  }

  case class CowPasture(potatoFarm: PotatoFarm)
  case class Meatery(cowPasture: CowPasture)

  case class Restaurant(potatoFarm: PotatoFarm, meatery: Meatery) {
    def orderSteakWithPatatoes() : Unit = {
      println(s"Welcome to $this. Here's your order.")
    }
  }

  trait CropModule {
    lazy val field = wire[Field]
    def potatoFarm = wire[PotatoFarm]
    lazy val digger = wire[Digger]
  }

  trait LifeStockModule {
    lazy val cowPasture = wire[CowPasture]
    lazy val meatery = wire[Meatery]

    def potatoFarm : PotatoFarm
  }

  trait RestaurantModule extends CropModule with LifeStockModule {
    lazy val restaurant = wire[Restaurant]
  }

  val app = new CropModule with LifeStockModule with RestaurantModule
  app.restaurant.orderSteakWithPatatoes()
}
