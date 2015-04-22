package wayang.auction

import akka.actor.Actor
import wayang.models.{Imp, Bid, BidRequest}

import scala.collection.SortedSet
import scala.collection.mutable._
import scala.concurrent.duration._
/**
 * Created by rofiq on 4/20/15.
 */
case class Reject(bid:Bid)

class RoomActor(imp:Imp) extends Actor {
  val bids:Buffer[Bid] = Buffer.empty
  context.system.scheduler.scheduleOnce(200 millis, self, "timeout")

  override def receive = {
    case bid:Bid =>
      if (bid.price >= imp.bidfloor)
        bids += bid
      else
        sender() ! Reject(bid)
    case "timeout" =>
      // order bid
  }
}
