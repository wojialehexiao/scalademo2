package com.song

import scala.collection.mutable

import scala.language.dynamics

object OperatorDemo {

  def main(args: Array[String]): Unit = {

    val f = () => {
      println("apply test")
    }


    f.apply()

    f()

    val a = 1.unary_-

    println(s"a: $a")


    val scores = new mutable.HashMap[String, Int]()

    scores("song") = 20

    scores.update("wang", 30)

    println(scores)

    "teacher wang" match {
      case Name(first, last) => println(s"$last ---- $first")
    }


    "teacher middle wang" match {
      case NameSeq(first, last) => println(s"$last ---- $first")
      case NameSeq(first, middle, last) => println(s"$last --$middle-- $first")
    }


    val person = new DynamicPerson()


    person.name = "song"


    println(person)
    println(person.name)
    println(person.age)
    println(person.findByName("name"))

    person.addKey(age=20,gender="man")

    println(person)

  }

  object Name {

    def unapply(name: String): Option[(String, String)] = {
      val s = name.split(" ")
      Some((s(0), s(1)))
    }
  }

  object NameSeq {

    def unapplySeq(name: String): Option[Seq[String]] = {
      Some(name.split(" "))
    }

  }




  class DynamicPerson extends Dynamic {

    val map = new mutable.HashMap[String, Any]()

    def selectDynamic(name:String): Any ={
      map.getOrElse(name,"not defined")
    }

    def updateDynamic(name:String) (newVal: String) {
        map.put(name,newVal)
    }


    def applyDynamic(name:String)(any: Any*): Any ={

      val n = any(0).asInstanceOf[String]
      map.getOrElse(n,"not defined")
    }

    def applyDynamicNamed(name:String)(values:(String, Any) *): Unit ={
      for (elem <- values) {
        map.put(elem._1, elem._2)
      }
    }


    override def toString: String = map.toString
  }

}
