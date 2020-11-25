package computerdatabase

import java.io.PrintWriter

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class HistoricalData extends Simulation {

//	val writter = new PrintWriter("src/test/scala/data/log.txt")

	val httpProtocol = http
		.baseUrl("https://5zk9a305a7.execute-api.eu-west-2.amazonaws.com")
	  .proxy(Proxy("io-spes-wcg01.isp-ops.stockex.com", 8082))
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36")

	val httpProtocol2 = http
		.baseUrl("https://5zk9a305a7.execute-api.eu-west-2.amazonaws.com")
		.proxy(Proxy("io-spes-wcg01.isp-ops.stockex.com", 8082))
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36")
	val headers_0 = Map(
		"cache-control" -> "max-age=0",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "none",
		"sec-fetch-user" -> "?1")



	val scn = scenario("Scenario_1")
		/*.exec(http("request_trade")
			.get("/uat/trade?request-id=e3&instrument=72057594042078941&" +
				"source-venue=1&start-time=20200814-00:00:00.000000&" +
				"end-time=20200814-23:59:00.000000")
			.headers(headers_0)
			.check(bodyString.saveAs("Response_trade_request")))

		.exec( session => {
			writter.write(
				"----------------------------------------------------------------------------" + "\n" +
					java.time.LocalDateTime.now() + " Response for trades : ")
			writter.write(session("Response_trade_request").as[String]+"\n")
			session}
		)

		.exec(http("request_instrument")
			.get("/uat/instrument/VOD/?request-id=e3&source-venue=1" +
				"&start-time=20200814-10:31:40.005394&end-time=20200814-21:31:40.005394")
			.headers(headers_0)
			.check(bodyString.saveAs("Response_instrument_request")))
		.exec( session => {
				writter.write(
					"----------------------------------------------------------------------------" + "\n" +
						java.time.LocalDateTime.now() + " Instrument : ")
				writter.write(session("Response_instrument_request").as[String]+"\n")
			session}
		)*/
		.exec(http("request_instruments")
			.get("/uat/instruments?request-id=e3&source-venue=1&date=2020-08-14&time=20200814-10:31:40.005394")
			.headers(headers_0)
			.check(bodyString.saveAs("Response_instruments_request")))/*
		.exec( session => {
			writter.write(
				"----------------------------------------------------------------------------" + "\n" +
					java.time.LocalDateTime.now() + " Instruments : ")
				writter.write(session("Response_instruments_request").as[String]+"\n")
			session}
		)
		.exec(http("request_statistic_snapshots")
			.get("/uat/statistics-snapshots?request-id=1&instrument=72057594038937946&source-venue=" +
				"1&start-time=20200814-01:35:56.130000&end-time=20200814-23:58:23.840000")
			.headers(headers_0)
			.check(bodyString.saveAs("Response_statistics_snapshots")))
		.exec( session => {
			writter.write("----------------------------------------------------------------------------" + "\n" +
				java.time.LocalDateTime.now() + " Statistics snapshot : ")
			writter.write(session("Response_statistics_snapshots").as[String]+"\n")
			session}
		)
		.exec(http("request_order_book_updates")
			.get("/uat/order-book-updates?request-id=e3&source-venue=1&start-time=20200814-01:35:56.130000&end-time=20200814-21:35:56.130000&instrument=72057594038937946")
			.headers(headers_0)
			.check(bodyString.saveAs("Response_order_book_updates")))
		.exec( session => {
			writter.write("----------------------------------------------------------------------------" + "\n" +
				java.time.LocalDateTime.now() + " Order book updates: ")
			writter.write(session("Response_order_book_updates").as[String]+"\n")
			session}
		)
		.exec(http("request_order_book_snapshot")
			.get("/uat/order-book-snapshot?request-id=e3&source-venue=1&time=20200814-14:23:51.946552&instrument=72057594038937946")
			.headers(headers_0)
			.check(bodyString.saveAs("Response_order_book_snapshot")))
		.exec( session => {
			writter.write("----------------------------------------------------------------------------" + "\n" +
				java.time.LocalDateTime.now() + " Order book snapshot : ")
			writter.write(session("Response_order_book_snapshot").as[String]+"\n")
			session}
		)*/

	setUp(scn.inject(rampUsersPerSec(1) to (50) during (600 seconds))).protocols(httpProtocol)
	//setUp(scn.inject(rampUsers (500) during (100 seconds))).protocols(httpProtocol)
	//setUp(scn.inject(constantUsersPerSec(50) during (600 seconds))).protocols(httpProtocol)
	//setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
}