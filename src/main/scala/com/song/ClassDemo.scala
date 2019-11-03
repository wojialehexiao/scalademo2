package com.song

import scala.beans.BeanProperty

object ClassDemo {

  //主构造器
  class Person private () {

    //生成javaBean方法
    @BeanProperty var name:String = _

    var age = 0

    val sex = "man"

    private[this] var value = 0

    def increment(): Unit = {
      value += 1
    }

    def currentValue = value


    //辅助构造器
    def this(@BeanProperty name2:String)  {
      this()
      this.name= name2
    }
  }

  def main(args: Array[String]): Unit = {
    val person = new Person("name2")

    person.age_=(20)

    println(person.age)

    person.age = 30

    println(person.age)


    println(person.sex)

    person.increment()

    println(person.currentValue)

    person.setName("song")


    println(person.getName)
  }

}
