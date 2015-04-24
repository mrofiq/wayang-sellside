package wayang.auction

import akka.actor.{Props, ActorSystem}
import akka.testkit.{ImplicitSender, TestKit}
import com.example.{PongActor, PingActor}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import wayang.models.{Imp, Bid}

/**
 * Created by rofiq on 4/24/15.
 */
class RoomActorSpec(_system: ActorSystem) extends TestKit(_system) with ImplicitSender
with WordSpecLike with Matchers with BeforeAndAfterAll {

  def this() = this(ActorSystem("MySpec"))

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "A Auction actor" must {
    "send reject on price lower than imp req" in {
      val roomActor = system.actorOf(Props(classOf[RoomActor], Imp("123", bidfloor = 12)))
      val bid = Bid("123", "123", 10.3)
      roomActor ! bid
      expectMsg(Reject(bid))
    }

    "send winner on highest price" in {
      val roomActor = system.actorOf(Props(classOf[RoomActor], Imp("123", bidfloor = 10)))
      val bid1 = Bid("123", "123", 10.2)
      val bid2 = Bid("123", "123", 10.4)
      roomActor ! bid1
      roomActor ! bid2
      expectMsg(Winner(bid2))
    }
  }

}