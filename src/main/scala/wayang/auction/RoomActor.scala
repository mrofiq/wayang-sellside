package wayang.auction

import akka.actor.Actor
import wayang.models.{Bid, BidRequest}

import scala.collection.SortedSet

/**
 * Created by rofiq on 4/20/15.
 */
class RoomActor extends Actor {
  val bids = SortedSet()

  override def receive = {
    case bid:Bid =>

      sender() ! "hello"
    case "timeout" =>
      // pick winner
  }
}
