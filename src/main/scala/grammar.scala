package com.onliner10.robotstxt

case class Wildcard()
case class Identifier(value: String)
type ProductToken = Wildcard | Identifier

case class UserAgent(productToken: ProductToken)
case class AllowRule(specification: String)
