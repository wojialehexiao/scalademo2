package com.song

object RegDemo {

  def main(args: Array[String]): Unit = {

    val numPattern = """[0-9]+""".r

    val str = "99 bo and 98 bo"

    val list = numPattern.findAllIn(str).toList

    println(list)


    val firstIn = numPattern.findFirstIn(str)

    println(firstIn)

    val replactAllIn = numPattern.replaceAllIn(str, "xxx")

    println(replactAllIn)

    val replaceSomeIn = numPattern.replaceSomeIn(str, m => if (m.matched.toInt % 2 == 0) Some("xxx") else None)
    println(replaceSomeIn)


    val numitemPattern = "([0-9]+) ([a-z]+)".r("num", "item")

    val allMatchIn = numitemPattern.findAllMatchIn(str)

//    println(allMatchIn.toList)

//    for(m <- allMatchIn) println(m.group(1))
    for(m <- allMatchIn) println(m.group("item"), m.group("num"))
  }

}
