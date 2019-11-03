package com.song

class TraitDemo {

}


trait Logger {

  def log: Unit

  def log(msg: String): Unit = {
    println(msg)
  }
}

class ConsoleLogger extends Logger with Serializable {
  def log: Unit = ???

  override def log(msg: String): Unit = super.log(msg)
}