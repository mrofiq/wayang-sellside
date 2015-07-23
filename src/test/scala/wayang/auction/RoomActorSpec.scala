package wayang.auction

import akka.actor.{ActorRef, Actor, Props, ActorSystem}
import akka.testkit.{TestProbe, ImplicitSender, TestKit}
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

  def createRoom() : (TestProbe, ActorRef) = {
    val proxy = TestProbe()
    val parent = system.actorOf(Props(new Actor {
      val child = context.actorOf(Props(classOf[RoomActor], Imp("123", bidfloor = 10)))

      def receive = {
        case x if sender == child => proxy.ref forward x
        case x => child forward x
      }
    }))
    (proxy, parent)
  }


  "A Auction actor" must {
    "send reject on price lower than imp req" in {
      val (proxy, parent) = createRoom()

      val bid = Bid("123", "123", 9)
      proxy.send(parent, bid)
      proxy.expectMsg(Reject(bid))
    }

    "send winner on highest price" in {
      val (proxy, parent) = createRoom()

      val bid1 = Bid("123", "123", 10.2)
      val bid2 = Bid("123", "123", 10.4)
      proxy.send(parent, bid1)
      proxy.send(parent, bid2)
      proxy.expectMsg(Winner(Some(bid2)))
    }

    "no winner" in {
      val (proxy, parent) = createRoom()

      proxy.expectMsg(Winner(None))
    }
  }
}