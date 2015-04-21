package wayang.models

/**
 * Created by rofiq on 4/21/15.
 */
case class BidResponse(
                        id:String,
                      seatbid:Option[List[SeatBid]],
                      bidid:Option[String],
                      cur:String = "USD",
                      customdata:Option[String],
                      nbr:Option[Int],
                      ext:Option[Ext]
                        )

case class SeatBid(
                  bid:List[Bid],
                  seat:Option[String],
                  group:Int = 0,
                  ext:Option[Ext]
                    )

case class Bid(
              id:String,
              impid:String,
              price:BigDecimal,
              adid:Option[String],
              nurl:Option[String],
              adm:Option[String],
              adomain:Option[List[String]],
              bundle:Option[String],
              iurl:Option[String],
              cid:Option[String],
              crid:Option[String],
              cat:Option[List[String]],
              attr:Option[List[Int]],
              dealid:Option[String],
              h:Option[Int],
              w:Option[Int],
              ext:Option[Ext]
                )
extends Ordered[Bid] {
  def compare(that: Bid) = {
    if (this.price == that.price)
      0
    else if (this.price > that.price)
      1
    else
      -1
  }
}
