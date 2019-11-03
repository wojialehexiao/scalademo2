package com.song


class Fraction(n: Int, d: Int) {
  private val num = n
  private val den = d

  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)

  override def toString: String = s"Fraction($num, $den)"
}

object Fraction {

  def apply(n: Int, d: Int): Fraction = {
    new Fraction(n, d)
  }
}

case class Delimiters(left: String, right: String)

object ImplicitDemo {

  implicit def int2Fraction(n: Int) = {
    println("-" * 20)
    Fraction(n, 1)
  }


  implicit val q = Delimiters("<<", ">>")

  def quote(what: String)(implicit delims: Delimiters) = delims.left + what + delims.right

  //  implicit def d(de:Delimiters):Ordered[Delimiters] = {
  //    new Ordered.
  //  }


  class Pair[T: Ordering](val first: T, val second: T) {
    def smaller = {
      if (implicitly[Ordering[T]].compare(first, second) > 0) first else second
    }
  }

  trait NumberLike[T] {
    def plus(x: T, y: T): T

    def devide(x: T, y: Int): T
  }

  object NumberLike {

    implicit object NumberLikeDouble extends NumberLike[Double] {
      override def plus(x: Double, y: Double): Double = x + y

      override def devide(x: Double, y: Int): Double = x / y
    }

    implicit object NumberLikeBigDecimal extends NumberLike[BigDecimal] {
      override def plus(x: BigDecimal, y: BigDecimal): BigDecimal = x + y

      override def devide(x: BigDecimal, y: Int): BigDecimal = x / y
    }

  }

  def main(args: Array[String]): Unit = {


    val r = Fraction(1, 2) * Fraction(2, 3)
    println(r)

    var result = 3 * Fraction(1, 3)

    val r1 = quote("Bonjour le monde")
    println(r1)


    def smaller[T](first: T, second: T)(implicit order: T => Ordered[T]) = {
      if (first < second) first else second
    }

    //    smaller(Delimiters("e",""), Delimiters("d","e"))


    def average[T: NumberLike](x: T, y: T) = {
      val ev = implicitly[NumberLike[T]]
      ev.devide(ev.plus(x, y), 2)
    }
  }
}
