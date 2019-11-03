package com.song

import java.util.concurrent.Executors

import scala.concurrent._
//import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}



object FutureDemo {

  val pool = Executors.newCachedThreadPool()

  implicit val ec = ExecutionContext.fromExecutor(pool)


  def main(args: Array[String]): Unit = {

    //    test1()

    //    test2()
//    test3()

    test4()

  }


  def test1(): Unit = {
    val f = Future {
      Thread.sleep(1000)
      println("ssss")
      42
    }

    println(f)

    println("bbbbb")

    Thread.sleep(2000)

    println(f)


    val f2 = Future {
      if (math.random > 0.5)
        throw new Exception("error")
      23
    }

    println("------------1 ------------")
    f2.onComplete({
      case Success(v) => println(s"The answer is $v ----------")
      case Failure(ex) => println(ex.getMessage + "------------")
    })


    println("-----------2---------------")

    Thread.sleep(100)
    println(f2)

    f2.value.get match {
      case Success(v) => println(s"The answer is $v")
      case Failure(ex) => println(ex.getMessage)
    }

    println("--------------3--------------------")

    import concurrent.duration._
    val f3 = Future {
      Thread.sleep(5000)
      23
    }


    //    val result = Await.result(f3, 5 seconds)
    val result = Await.ready(f3, 5 seconds)

    println(result)

    val t = f3.value.get

    if (t.isSuccess) println(s"The answer is ${t.get}")
    if (t.isFailure) println(t.failed.get.getMessage)

  }


  def test2(): Unit = {
    val f1 = Future {
      Thread.sleep(1000)
      10
    }

    val f2 = Future {
      Thread.sleep(1000)
      13
    }


    f1.map(n => {
      println(n)
      n
    })

    val combined = f1.map(n1 => f2.map(n2 => n1 + n2))

    val combined2 = f1.flatMap(n1 => f2.map(n2 => n1 + n2))

    val combined3 = for (n1 <- f1; n2 <- f2 if n1 != n2) yield n1 + n2


    Thread.sleep(3000)

    println(combined)
    println(combined2)
    println(combined3)


  }


  def test3(): Unit = {
    def f1 = Future {
      Thread.sleep(1000)
      10
    } recover {
      case e: Exception => 0
    }

    def f2 = Future {
      Thread.sleep(1000)
      13
    }


    val combined = for (n1 <- f1; n2 <- f2) yield n1 + n2

    f1.fallbackTo(f2)


    combined.foreach(n => println(s"Result: $n"))

    println("-" * 8)
    Thread.sleep(1500)

    println(combined)

    Thread.sleep(1000)
    println(combined)

    val parts = List(1, 2, 3)

    var futures = parts.map(x => Future {
      x * 2
    })
    var result = Future.sequence(futures)

    Thread.sleep(1000)

    println(result)

    var res = Future.traverse(parts)(x => Future {
      x * x
    })
    Thread.sleep(1000)

    println(res)

    var res2 = Future.firstCompletedOf(futures)

    println(res2)

    println(Future.find(futures)(t => t > 2))
    println(Future.successful(2))
    println(Future.failed(new Exception()))


  }

  def test4(): Unit = {


    def computeAnswer(): Future[Int] = {
      val p = Promise[Int]()

      Future {
        Thread.sleep(1000)
        p.success(5)
      }

      p.future
    }

    val res = computeAnswer()
    Thread.sleep(2000)

    println(res)
  }


}
