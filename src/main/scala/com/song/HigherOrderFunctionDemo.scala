package com.song

object HigherOrderFunctionDemo {

  def main(args: Array[String]): Unit = {

    val fun = math.ceil _

    //包对象方法转函数
    val fun2: Double => Double = math.ceil

    println(fun(3.14))
    println(fun2(3.14))

    //类方法转函数
    val f = (_: String).charAt(_: Int)
    println(f("abc", 1))


    val f2: (String, Int) => Char = _.charAt(_)
    println(f2("abc", 1))

    Array(1, 3, 5, 3, 2, 2) map {
      _ * 3
    }


    def valueAtOneQuarter: (Double => Double, Double) => Double =
      (fn: Double => Double, value: Double) => fn(value)


    println(valueAtOneQuarter(math.ceil, 3.14))
    println(valueAtOneQuarter(math.sqrt, 3.14))


    def mulBy(factory: Double): Double => Double =
      (x: Double) => factory * x

    val quintuple = mulBy(5)

    println(quintuple)

    println(quintuple(20))

    val f3 = 3 * (_: Double)

    val f4: Double => Double = 3 * _


    val mul = (x: Int, y: Int) => x * y

    val mul2 = (x: Int) =>
      (y: Int) => x * y


    def mul3(x: Int)(y: Int) = x * y

    println(mul2(10))

    println(mul3(10)(2))


    println(mul3 {
      10
    } {
      2
    })


    val a = Array("Hello", "World")
    val b = Array("hello", "world")

    println(a.corresponds(b)(_.equalsIgnoreCase(_)))

    def runInThread(block: () => Unit) {
      new Thread() {
        override def run(): Unit = {
          block()
        }
      }.start()
    }

    runInThread {
      () => println("Hi"); Thread.sleep(1000); println("Bye")
    }


    //抽象控制 换名( call-by-name )调用
    def runInThread2(block: => Unit): Unit = {
      new Thread() {
        override def run(): Unit = {
          block
        }
      }.start()
    }

    runInThread2 {
      println("Hi2")
      Thread.sleep(1000)
      println("Bye2")
    }


    def until(condition: => Boolean)(block: => Unit): Unit = {
      if (!condition) {
        block
        until(condition)(block)
      }
    }


    var x = 10
    until(x == 0) {
      x -= 1
      println(x)
    }






  }

}
