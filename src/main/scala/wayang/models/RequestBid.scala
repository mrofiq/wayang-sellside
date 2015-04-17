package wayang.models

/**
 * Created by rofiq on 4/16/15.
 */
case class Banner(
                 w:Int,
                 h:Int,
                 wmax:Int,
                 hmax:Int,
                 wmin:Int,
                 hmin:Int,
                 id:String,
                 btype:Option[List[Int]],
                 battr:Option[List[Int]],
                 pos:Option[Int],
                 mimes:Option[List[String]],
                 topframe:Option[Int],
                 expdir:Option[List[Int]],
                 api:Option[List[Int]],
                 ext:Option[Ext]
                   )
case class Imp(id:String,
                banner:Option[Banner],
                video:Option[Video],
                native:Option[Native],
                displaymanager:Option[String],
               displaymanagerver:Option[String],
                instl:Int = 0,
                tagid:String,
                bidfloor:Float = 0,
                bidfloorcur:String = "USD",
                secure:Option[Int],
                iframebuster:Option[List[String]],
                pmp:Option[Pmp],
                ext:Option[Ext])
case class Device(id:String)
case class User(id:String)
case class App(id:String)
case class Regs(id:String)
case class Ext(id:String)
case class RequestBid(
                       id:String,
                       imp:List[Imp],
                       site:Option[App],
                       app:Option[App],
                       device:Option[Device],
                     user:Option[User],
                     test:Int = 0,
                     at:Int = 2,
                     tmax:Int,
                     wset:String,
                     allimps:Int = 0,
                     cur:Option[List[String]],
                     bcat:Option[List[String]],
                     badv:Option[List[String]],
                     regs:Option[Regs],
                     ext:Option[Ext]
                       )
