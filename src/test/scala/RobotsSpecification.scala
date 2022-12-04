package com.onliner10.robotstxt
import io.lemonlabs.uri.{Url, UrlPath}
import org.scalacheck.Gen
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class RobotsSpecification extends AnyFlatSpec with ScalaCheckDrivenPropertyChecks with should.Matchers {
  "Single group" should "be parsed correctly" in {
    1 shouldBe 1
//    forAll { (urlPath: String) =>
//      1 shouldBe 1
//    }
  }
}
