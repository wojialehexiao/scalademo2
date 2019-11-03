package com.song

object EnumerationAppDemo {

  def main(args: Array[String]): Unit = {

    println(EnumerationDemo.green.id)

    EnumerationDemo.values.foreach(println)

    def doWatch(enumerationDemo: EnumerationDemo.Value): Unit ={

    }

    def doWatch2(enumerationDemo: EnumerationDemo.EnumerationDemo): Unit ={

    }

    doWatch(EnumerationDemo.green)
    doWatch2(EnumerationDemo.green)

  }
}
