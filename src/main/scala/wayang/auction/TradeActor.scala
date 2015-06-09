package wayang.auction

import akka.actor.{Props, Actor}
import wayang.models.{Bid, Imp}

/**
 * Created by rofiq on 5/4/15.
 */
class TradeActor extends Actor {
  def receive = {
    // when receive impression
    case imp:Imp =>
      val room = context.actorOf(Props(classOf[RoomActor], imp), name="room"+imp.id)

      // todo: notify advertiser

    case bid:Bid =>
      val room = context.actorSelection("room"+bid.impid)
      room ! bid


  }

}
