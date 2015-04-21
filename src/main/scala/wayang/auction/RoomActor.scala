package wayang.auction

import akka.actor.Actor
import wayang.models.RequestBid

/**
 * Created by rofiq on 4/20/15.
 */
class RoomActor extends Actor {
  override def receive = {
    case bid:RequestBid => sender() ! "hello"
    case "timeout" =>
      // pick winner
  }
}
