package wayang.auction

import akka.actor.{ActorRef, Actor}
import wayang.models.{Imp, Bid, BidRequest}

import scala.collection.SortedSet
import scala.collection.mutable._
import scala.concurrent.duration._
import akka.event.Logging
/**
 * Created by rofiq on 4/20/15.
 */
case class Reject(bid:Bid)

case class Winner(bid: Bid)

class RoomActor(imp:Imp) extends Actor {

  import context._

  val log = Logging(context.system, this)

  val bids: Buffer[(ActorRef, Bid)] = Buffer.empty
  context.system.scheduler.scheduleOnce(200 millis, self, "timeout")

  override def receive = {
    case bid:Bid =>
      log.info("add bid: " + bid)
      if (bid.price >= imp.bidfloor) {
        bids += new Tuple2(sender(), bid)
        log.info(bids.toString())
      }
      else
        sender() ! Reject(bid)
    case "timeout" =>
      log.info("timeout")
      // order bid
      if (!bids.isEmpty) {
        val winner = bids.reduceLeft((x, y) => if (x._2.price > y._2.price) x else y)
        val parent = context.actorSelection("..")
        winner._1 ! Winner(winner._2)
      }
  }
}
