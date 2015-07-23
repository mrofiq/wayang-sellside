package wayang.auction

import akka.actor.{ActorRef, Props, Actor}
import wayang.models.{Bid, Imp}

/**
 * Created by rofiq on 5/4/15.
 */
class TradeActor extends Actor {
  val roomMap = scala.collection.mutable.HashMap.empty[String, ActorRef]

  def receive = {
    case imp:Imp =>
      // create auction room when receiving impression
      val room = context.actorOf(Props(classOf[RoomActor], imp), name="room"+imp.id)
      roomMap += (imp.id -> room)

      // todo: notify advertiser

    case bid:Bid =>
      val room = context.actorSelection("room"+bid.impid)
      room ! bid


  }

}
