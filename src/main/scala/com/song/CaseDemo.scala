package com.song

object CaseDemo {

  def main(args: Array[String]): Unit = {

    var sign: Any = '*' match {
      case '+' | '*' => 1
      case '-' => -1
      case _ => 0
    }

    println(sign)

    var ch = 'p'
    sign = ch match {
      //守卫
      case _ if Character.isDigit(ch) => Character.digit(ch, 10)
      case '+' | '*' => 1
      case '-' => -1
      //变量
      case a => a * 2
      case _ => 0
    }

    println(sign)

    var obj: Any = 0

    //类型模式
    sign = obj match {
      case b: Int => 2
      case a: String => 1
      case _: BigInt => 3
    }
    println(sign)


    var arr = Array(0, 9, 8)


    sign = arr match {
      case Array(0) => "0"
      case Array(x, y) => s"$x, $y"
      case Array(0, rest@_*) => "0 ... " + rest.mkString(",")

      case _ => "something else"
    }

    println(sign)


    var lst = List(0, 1, 8)

    sign = lst match {
      case 0 :: Nil => "0"
      case x :: y :: Nil => s"$x, $y"
      case 0 :: tail => s"0..."
      case _ => "something else"
    }

    println(sign)

    var t = (1, 0)

    sign = t match {
      case (0, _) => "0, _"
      case (y, 0) => "y , 0"
      case _ => "neither is 0"
    }

    println(sign)

    val pattern = "([0-9]+) ([a-z]+)".r

    sign = "99 bottles" match {
      case pattern(num, item) => s"$item $num"
    }
    println(sign)

    val (x, y) = (100, 2)
    println(x)

    val (q, r) = BigInt(10) /% 3

    println(s"q: $q, r: $r")

    //    val 2 = 9

    val amt = Currency(29, "EUR")
    var price = amt.copy()

    println(price)

    price = amt.copy(unit = "AMT")

    println(price)

    sign = amt match {
      case a Currency b => s"$a  currency $b"
    }

    println(sign)


    //嵌套匹配
    var b = Bundle(
      "dfsf",
      29,
      Bundle("ddd", 20, Article("dfef", 23), Article("3232", 0))
    )

    sign = b match {
      case Bundle(_, _, Bundle(_, _, art@Article(_, _), Article(x, y))) => s"$x, $y, $art"
    }

    println(sign)


    val f: PartialFunction[Char, Int] = {
      case '+' => 1
      case '-' => -1
    }

    println(f.isDefinedAt(0))

    println(f('+'))

    "-2+3".collect(f)

    val g = f.lift

    println(g)

    val d: PartialFunction[Char, Int] = Function.unlift(g)

    println(d)






    def tryCatch[T](b: => T, catcher: PartialFunction[Throwable, T]) = try {
      b
    } catch  catcher

    val result = tryCatch("dd".toInt, {case  _ :NumberFormatException => -1})

    println(result)



  }

  //密闭类， 所有子类必须在同一个文件中
  sealed abstract class Amount

  case class Dollar(value: Double) extends Amount

  case class Currency(value: Double, unit: String) extends Amount

  case object Nothing extends Amount


  abstract class Item

  case class Article(description: String, price: Double) extends Item

  case class Bundle(description: String, discount: Double, items: Item*) extends Item


}
