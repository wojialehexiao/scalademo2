package com.song

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object ArrayDemo {

  def main(args: Array[String]): Unit = {
    val a = new Array[String](5)
    a(0) = "hello"

    println(a(0))

    val s = Array("Hello", "world")

    val arrayBuffer = ArrayBuffer[Int]()

    arrayBuffer += 1

    arrayBuffer += (2, 3, 4, 5, 6)

    arrayBuffer ++= Array(7, 8, 9)

    arrayBuffer.insert(2, 33)

    arrayBuffer.insert(2, 33, 44, 55)

    arrayBuffer.remove(2)

    arrayBuffer.remove(2, 3)

    arrayBuffer.toArray

    for (i <- arrayBuffer) println(i)

    for (i <- 0 until arrayBuffer.length by 2) {
      println(s"$i: ${arrayBuffer(i)}")
    }

    for (i <- 10 until 1 by -1) println(i)

    for (i <- arrayBuffer.indices) println(s"$i: ${arrayBuffer(i)}")


    println(ArrayBuffer("a", "b", "c", "d").max)


    val b = ArrayBuffer(1, 7, 2, 9)

    val bSorted = b.sorted

    println(bSorted)

    val bDescending = b.sortWith(_ > _)

    println(bDescending)

    val a1 = Array(1, 7, 2, 9)

    scala.util.Sorting.quickSort(a1)

    println(a1.mkString(" and "))

    println(b.mkString("<", " and ", ">"))

    val i = java.util.Arrays.binarySearch(a1, 7)
    println(i)

    import scala.collection.Searching._

    println(s.search("world"))


    val command = ArrayBuffer("ls", "-al", "/Users/")

    import collection.JavaConversions.bufferAsJavaList

    val pb = new ProcessBuilder(command)

    println(pb)

    import collection.JavaConversions.asScalaBuffer

    val cmd: mutable.Buffer[String] = pb.command()

    println(cmd)



  }
}
