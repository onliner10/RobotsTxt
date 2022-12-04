package com.onliner10.robotstxt

import cats.parse.{Parser0, Parser => P, Numbers}

object RobotsParser:
  private[this] val whitespace: P[Unit] = P.charIn(" \t").void
  private[this] val whitespaces0: Parser0[Unit] = whitespace.rep0.void

  private[this] val wildcardP: P[Wildcard] =
    P.char('*').map(_ => Wildcard())

  private[this] val identifierP: P[Identifier] =
    val dashP: P[Char] = P.char('-').map(_ => '-')
    val underscoreP: P[Char] = P.char('_') map (_ => '_')
    val uppercaseP: P[Char] = P.charIn('A' to 'Z')
    val lowercaseP: P[Char] = P.charIn('a' to 'z')

    (dashP | underscoreP | uppercaseP | lowercaseP).rep(1).map(_.toList.mkString).map(x => Identifier(x))

  private[this] val productTokenP: P[ProductToken] =
    wildcardP | identifierP

  private[this] val nonControlCharacterP: P[Char] =
    P.charWhere(c => !Character.isISOControl(c))

  private[this] val commentP: P[Unit] =
    val hashP: P[Unit] = P.char('#')
    val allowedCharacters = nonControlCharacterP | whitespace

    (hashP *> allowedCharacters.rep0).void

  private[this] val eolP: P[Unit] =
    (whitespaces0 *> commentP.?).with1 *> P.char('\n')

  val userAgentParser: P[UserAgent] =
    val prefixP: P[Unit] = P.ignoreCase("user-agent").surroundedBy(whitespaces0)
    val separatorP = P.char(':').surroundedBy(whitespaces0)

    (prefixP *> separatorP *> productTokenP.surroundedBy(whitespaces0) <* eolP).map(x => UserAgent(x))

