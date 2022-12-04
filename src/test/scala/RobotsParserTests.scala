package com.onliner10.robotstxt
import io.lemonlabs.uri.{Url, UrlPath}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class RobotsParserTests extends AnyFlatSpec with should.Matchers {
  "UserAgentParser" should "parse wildcard" in {
    val in = "User-agent: * \n"

    val result = RobotsParser.userAgentParser.parseAll(in)
    val expected = Right(UserAgent(Wildcard()))

    result shouldBe expected
  }
}
