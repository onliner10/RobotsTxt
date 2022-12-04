package com.onliner10.robotstxt

import scala.util.parsing.combinator.RegexParsers

class RobotsParser extends RegexParsers {
  def userAgent: Parser[UserAgent] =
    """\*|[a-z]+""".r       ^^ { UserAgent(_.toString) }
}
