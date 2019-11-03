package com.song

class ExtendDemo {

}


class Employee(override val name: String, override val age: Int, var salary: Double)
  //调用父类主构造器
  extends Person(name, age) {

  override val id:Int = 1


  def canEqual(other: Any): Boolean = other.isInstanceOf[Employee]

  override def equals(other: Any): Boolean = other match {
    case that: Employee =>
      (that canEqual this) &&
        id == that.id
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(id)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

abstract class Person(val name: String, val age: Int) {

  def id:Int
}

class TimeM(val time:Int) extends AnyVal{

}

object Test2 {
  def main(args: Array[String]): Unit = {
    val t:TimeM = new TimeM(1)

    println(t.time)
  }
}
