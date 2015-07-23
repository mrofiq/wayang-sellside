package wayang.auction

import akka.actor.{Props, ActorSystem}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import wayang.models.{Bid, Imp}
import scala.concurrent.duration._

/**
 * Created by rofiq on 5/11/15.
 */
class TradeActorSpec(_system: ActorSystem) extends TestKit(_system) with ImplicitSender
with WordSpecLike with Matchers with BeforeAndAfterAll {

  def this() = this(ActorSystem("MySpec"))

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "A Auction actor" must {
    "send reject on price lower than imp req" in {
      val tradeActor = system.actorOf(Props[TradeActor])
      val imp = Imp(id = "123")
      tradeActor ! imp
      expectMsgClass(10 millis, classOf[RoomActor])
    }

    "send winner on highest price" in {
      val roomActor = system.actorOf(Props(classOf[RoomActor], Imp("123", bidfloor = 10)))
      val bid1 = Bid("123", "123", 10.2)
      val bid2 = Bid("123", "123", 10.4)
      roomActor ! bid1
      roomActor ! bid2
      expectMsg(Winner(Some(bid2)))
    }
  }
}
