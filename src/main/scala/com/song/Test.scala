package com.song

import java.io.IOException
import java.net.{MalformedURLException, URL}
import java.text.MessageFormat

import scala.io.StdIn
import scala.util.Try

object Test {

  def main(args: Array[String]): Unit = {

    println(1.to(10))

    println("Hello".intersect("World"))

    val x: BigInt = 1234567890

    println(x * x * x)

    println(BigInt.probablePrime(100, scala.util.Random))


    println(if (x > 0) 1 else ())

    println(f"x = $x")


    for (i <- 1 to 10) {
      println(i)
    }


    import scala.util.control.Breaks._

    breakable {
      for (i <- 1 to 10) {
        if (x == 7) {
          break
        }
        println(i)
      }
    }


    println("------------------------------------------------")

    for (i <- 1 to 3; j <- 1 to 3) print(f"${10 * i + j}%3d")

    println()

    for (i <- 1 to 3; j <- 1 to 3 if i != j) print(f"${10 * i + j}%3d")

    println()

    for (i <- 1 to 3; from = 4 - i; j <- from to 3) print(f"${10 * i + j}%3d")

    println()

    println(for (i <- 1 to 10) yield i % 3)

    println(for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar)

    println(1 + 'c')

    for {
      i <- 1 to 10
      j <- 1 to 10
    } print(f"${i * j}%3d")


    println()

    def f(name: String) {
      println(name)
    }

    f("song")

    def f2(i: Int*): Unit = {
      println(i.sum)
    }

    f2(1, 2, 3, 4, 5, 6)

    //    println(sum(1, 2,3 ,4))

    val str = MessageFormat.format("The answer to {0} is {1}",
      "everything", 42.asInstanceOf[AnyRef]
    )

    println(str)


    lazy val words = scala.io.Source.fromFile("test.txt")

    def words2 = scala.io.Source.fromFile("test.txt")

    if (x >= 0) {
      math.sqrt(x.toDouble)
    } else {
      throw new IllegalArgumentException("ddd")
    }

    var url = new URL("http://www.baidu.com/index.html")
    try {
      url = new URL("http://www.baidu.com/index.html")
    } catch {
      case _: MalformedURLException => println(s"Bad URL: $url")
      case ex: IOException => ex.printStackTrace()
    } finally {

    }


    val result = for (a <- Try {
      StdIn.readLine("a: ").toInt
    }; b <- Try {
      StdIn.readLine("b: ").toInt
    }) yield a / b

    print(result)


  }

}
