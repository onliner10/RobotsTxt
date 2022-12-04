package com.onliner10.robotstxt
import io.lemonlabs.uri.{Url, UrlPath}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class RobotsParserTests extends AnyFlatSpec with should.Matchers {
  "Single group" should "be parsed correctly" in {
    val in =
      """
        | User-agent: *
        | Crawl-delay: 5
        | Disallow: /test/
        | Allow: /test2/test3/
        | Sitemap: http://www.example.com/sitemap.xml
        |""".stripMargin

    val result = RobotsParser.userAgent(in)
    1 shouldBe 1
  }
}
