package com.song

import scala.reflect._

object GenericsDemo {

  class Pair[T <: Comparable[T]](val first: T, val second: T) {
    def smaller = if (first.compareTo(second) < 0) first else second
  }

  case class Pair2[T](first: T, second: T) {
    def replaceFirst[R >: T](f: R) = new Pair2[R](f, second)
  }

  class Pair3[T](val first: T, val second: T)(implicit e: T => Comparable[T]) {
    def smaller = if (first.compareTo(second) < 0) first else second
  }

  class Pair4[T: Ordering](val first: T, val second: T) {
    def smaller(implicit ord: Ordering[T]) = if (ord.compare(first, second) > 0) first else second
  }

  def getMethod[T](arr: Array[T]) = arr.length / 2


  def makePair[T: ClassTag](first: T, second: T) = {
    val r = new Array[T](2)
    r(0) = first
    r(1) = second
    r
  }

  trait Friend[-T]{
    def befriend(someone:T)
  }

  class Person extends Friend[Person] {
    override def befriend(someone: Person): Unit = {

    }
  }

  class Student extends Person


  def makeFriendWith(s:Student, f:Friend[Student]): Unit ={
    f.befriend(s)
  }

  def main(args: Array[String]): Unit = {

    val p = new Pair("e", "d")

    println(p.smaller)

    val p2 = new Pair2("3", "d234")
    println(p2.replaceFirst(3))


    val p3 = new Pair3(1, 3)
    val p4 = new Pair4(1, 3)

    println(getMethod[Int](Array(1, 3, 5, 6)))

    println(p3.smaller)
    println(p4.smaller)


    println(makePair("3", "u"))


    val susan = new Student
    val fred = new Person

    makeFriendWith(susan, fred)
  }

}
