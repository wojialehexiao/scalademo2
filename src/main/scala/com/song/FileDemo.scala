package com.song

import java.io.PrintWriter

import scala.io.Source

object FileDemo {

  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("data/test.txt")

//    val list = source.getLines().toList
//    println(list)

//    val str = source.mkString

//    println(str)

    //逐个字符打印
    for(c <- source) println(c)



    source.close()


  }

}

@SerialVersionUID(1L) class TestSer extends Serializable{

}
