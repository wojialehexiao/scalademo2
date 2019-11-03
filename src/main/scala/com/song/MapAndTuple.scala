package com.song

import java.awt.Font
import java.awt.font.TextAttribute

object MapAndTuple {

  def main(args: Array[String]): Unit = {

    val scores = collection.mutable.Map("song" -> 20, "bob" -> 4, "wang" -> 30, ("bb", 2))

    scores.put("aa", 222)


    //获取
    println(scores.get("saaong"))
    println(scores("song"))


    //设置默认值
    val scores1 = scores.withDefaultValue(0)

    println(scores1("323sdf"))

    //更新
    scores("song") = 30
    scores("afe") = 10
    scores += ("ss" -> 20, "dd" -> 32)
    scores -= "bob"

    println(scores)

    println(scores.keySet)


    for ((k, v) <- scores) println(s"$k: $v")


    val score2 = collection.mutable.LinkedHashMap()

    // java转scala
    import collection.JavaConversions.propertiesAsScalaMap

    val props: scala.collection.Map[String, String] = System.getProperties()


    // scala转java
    import scala.collection.JavaConversions.mapAsJavaMap
    import java.awt.font.TextAttribute._

    val map = collection.mutable.Map(FAMILY -> "Serif", SIZE -> 12)
    val font = new Font(map)


    val symbols = Array("<", "-", ">")
    val counts = Array(2, 10, 2)
    val pairs = symbols.zip(counts)

    for ((s, n) <- pairs) print(s * n)

    println()
    println(pairs.toMap)

  }

}
