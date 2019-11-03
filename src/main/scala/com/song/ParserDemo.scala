package com.song

import scala.util.parsing.combinator.RegexParsers

class ExprParser extends RegexParsers {
  val number = "[0-9]".r

  def expr: Parser[Int] = term ~ opt(("+" | "-") ~ expr) ^^ {
    case t ~ None => t
    case t ~ Some("+" ~ e) => t + e
    case t ~ Some("-" ~ e) => t - e
  }

  def term: Parser[Int] = factor ~ rep("*" ~ factor) ^^ {
    case f ~ r => f * r.map(_._2).product
  }

  def factor: Parser[Int] = number ^^ {
    _.toInt
  } | "(" ~ expr ~ ")" ^^ {
    case _ ~ e ~ _ => e
  }
}

object ParserDemo {


  def main(args: Array[String]): Unit = {
    val parser = new ExprParser

    val result = parser.parseAll(parser.expr, "3-4*5")

    if (result.successful) {
      println(result.get)
    }
  }
}
