package wayang.auction

import akka.actor.Actor
import wayang.models.{Bid, BidRequest}

import scala.collection.SortedSet
import scala.collection.mutable._

/**
 * Created by rofiq on 4/20/15.
 */
class RoomActor(request:BidRequest) extends Actor {
  val bids:Buffer[Bid] = Buffer.empty

  override def receive = {
    case bid:Bid =>
      bids += bid
      sender() ! "hello"
    case "timeout" =>
      // pick winner
  }
}
