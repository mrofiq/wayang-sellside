package wayang.models

/**
 * Created by rofiq on 4/16/15.
 */
case class Content(
                  id:Option[String],
                  episode:Option[Int],
                  title:Option[String],
                  series:Option[String],
                  season:Option[String],
                  producer:Option[Producer],
                  url:Option[String],
                  cat:Option[List[String]],
                  videoquality:Option[Int],
                  context:Option[Int],
                  contentrating:Option[String],
                  userrating:Option[String],
                  qagmediarating:Option[Int],
                  keywords:Option[String],
                  livestream:Option[Int],
                  sourcerelationship:Option[Int],
                  len:Option[Int],
                  language:Option[String],
                  embeddable:Option[Int],
                  ext:Option[Ext]
                    )

case class Device (
                  ua:Option[String],
                  geo:Option[Geo],
                  dnt:Option[Int],
                  lmt:Option[Int],
                  ip:Option[String],
                  ipv6:Option[String],
                  devicetype:Option[Int],
                  make:Option[String],
                  model:Option[String],
                  os:Option[String],
                  osv:Option[String],
                  hwv:Option[String],
                  h:Option[Int],
                  w:Option[Int],
                  ppi:Option[Int],
                  pxratio:Option[Float],
                  js:Option[Int],
                  flashver:Option[String],
                  language:Option[String],
                  carrier:Option[String],
                  connectiontype:Option[Int],
                  ifa:Option[String],
                  didsha1:Option[String],
                  didmd5:Option[String],
                  dpidsha1:Option[String],
                  dpidmd5:Option[String],
                  macsha1:Option[String],
                  madmd5:Option[String],
                  ext:Option[Ext]
                    )

case class Geo(
              lat:Option[Float],
              lon:Option[Float],
              _type:Option[Int],
country:Option[String],
              region:Option[String],
              regionfips104:Option[String],
              metro:Option[String],
              city:Option[String],
              zip:Option[String],
              utcoffset:Option[Int],
ext:Option[Ext]
                )

case class User(
               id:Option[String],
               buyerid:Option[String],
               yob:Option[Int],
               gender:Option[String],
               keywords:Option[String],
               customdata:Option[String],
               geo:Option[Geo],
               data:Option[List[Data]],
               ext:Option[Ext]
                 )
case class Segment(
                  id:Option[String],
                  name:Option[String],
                  value:Option[String],
                  ext:Option[Ext]
                    )
case class Regs(
               coppa:Option[Int],
               ext:Option[Ext]
                 )
case class Pmp(
                private_auction:Option[Int],
              deals:Option[List[Deal]],
              ext:Option[Ext]
                )
case class Deal(
               id:String,
               bidfloor:Float = 0.0,
               bidfloorcur:String = "USD",
               at:Option[Int],
               wseat:Option[List[String]],
               wadomain:Option[List[String]],
               ext:Option[Ext]
                 )
case class Data(
               id:Option[String],
               name:Option[String],
               segment:Option[List[Segment]],
               ext:Option[Ext]
                 )

case class Producer(
                      id:Option[String],
                      name:Option[String],
                      cat:Option[List[String]],
                      domain:Option[String],
                      ext:Option[Ext]
                      )

case class Publisher(
                    id:Option[String],
                    name:Option[String],
                    cat:Option[List[String]],
                    domain:Option[String],
                    ext:Option[Ext]
                      )
case class App(
              id:Option[String],
              name:Option[String],
              bundle:Option[String],
              domain:Option[String],
              storeurl:Option[String],
              cat:Option[List[String]],
              sectioncat:Option[List[String]],
              pagecat:Option[List[String]],
              ver:Option[String],
              privacypolicy:Option[Int],
              paid:Option[Int],
              publisher:Option[Publisher],
              content:Option[Content],
              keywords:Option[String],
              ext:Option[Ext]
                )
case class Site(
               id:Option[String],
               name:Option[String],
               domain:Option[String],
               cat:Option[List[String]],
               sectioncat:Option[List[String]],
               pagecat:Option[List[String]],
               page:Option[String],
               ref:Option[String],
               search:Option[String],
               mobile:Option[Int],
               privacypolicy:Option[Int],
               publisher:Option[Publisher],
               content:Option[Content],
               keywords:Option[String],
               ext:Option[Ext]
                 )
case class Native(
                 request:String,
                 ver:Option[String],
                 api:Option[List[Int]],
                 battr:Option[List[Int]],
                 ext:Option[Ext]
                   )
case class Video(
                mimes:List[String],
                minduration:Option[Int],
                maxduration:Option[Int],
                protocol:Option[Int],
                protocols:Option[List[Int]],
                w:Option[Int],
                h:Option[Int],
                startdelay:Option[Int],
                linearity:Option[Int],
                sequence:Option[Int],
                battr:Option[List[Int]],
                maxextended:Option[Int],
                minbitrate:Option[Int],
                maxbitrate:Option[Int],
                boxingallowed:Int = 1,
                playbackmethod:Option[List[Int]],
                delivery:Option[List[Int]],
                pos:Option[Int],
                companionad:Option[List[Banner]],
                api:Option[List[Int]],
                companiontype:Option[List[Int]],
                ext:Option[Ext]
                  )
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
                tagid:Option[String],
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
case class BidRequest(
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
