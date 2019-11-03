package com.song

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object CollectionDemo {

  def main(args: Array[String]): Unit = {

    println(Seq(1, 2, 3) == List(1, 2, 3))
    println(Seq(1, 2, 3) == (1 to 3))

    val l = List(1) ++ List(2, 4, 5, 6)

    println(l)

    println(1 :: List(2))

    println(1 :: 2 :: Nil)

    println(l.head)

    println(l.tail)

    println(Set(1) + 2)

    println(Seq(1) :+ 2)

    println(Vector(1, 2, 3) :+ 3)

    val grouped = (1 to 10).grouped(3).toList

    println(grouped)
    val sliding = (1 to 10).sliding(3).toList

    println(sliding)

    val groupBy = (1 to 10).groupBy(_ % 3)

    println(groupBy)

    val buffer = ArrayBuffer("a", "b", "c")

    buffer.transform(_.toUpperCase)

    println(buffer)

    val a = "-4+3".collect {
      case '+' => 1
      case '-' => -1
    }

    println(a)

    //    println(0 /: List(1,2,3,5)(_+_))

    println((1 to 10).scanLeft(0)(_ + _))

    val l2 = List("3", "5")

    println(l2.zipWithIndex)


    def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)

    val tenOrMore = numsFrom(10)

    println(tenOrMore)

    println(tenOrMore.tail.tail)
    println(tenOrMore.take(5))
    println(tenOrMore.take(5).force)

    val palin = (1 to 10000).view.map(x => x * x).filter(x => x.toString == x.toString.reverse)

    println(palin)
    println(palin.take(5).mkString(","))

    val buffer2 = ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)

    buffer2.view(2, 5).transform(x => 0)

    println(buffer2)


    println((1 to 10).par.map(_ * 2).seq)

    val e = (for (i <- 1 to 100000) yield i) == (1 to 100000)

    println(e)

  }

}
