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
              adid: Option[String] = None,
              nurl: Option[String] = None,
              adm: Option[String] = None,
              adomain: Option[List[String]] = None,
              bundle: Option[String] = None,
              iurl: Option[String] = None,
              cid: Option[String] = None,
              crid: Option[String] = None,
              cat: Option[List[String]] = None,
              attr: Option[List[Int]] = None,
              dealid: Option[String] = None,
              h: Option[Int] = None,
              w: Option[Int] = None,
              ext: Option[Ext] = None
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
