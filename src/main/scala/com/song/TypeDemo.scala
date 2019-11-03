package com.song

import javax.swing.{JComponent, JFrame}

object TypeDemo {

  object Title

  class Document {
    def setTitle(title: String): this.type = {
      this
    }

    def setAuthor(author: String): this.type = {
      this
    }

    def set(obj: Title.type): this.type = {
      this
    }

    def to(arg: String) = {

    }

  }

  class Book extends Document {
    def addChapter(chapter: String): this.type = {
      this
    }
  }

  trait Logged{
    def log(msg:String)
  }

  trait LoggedException extends Logged {
    this:Exception => def log(): Unit ={
      log(getMessage)
    }
  }

  def main(args: Array[String]): Unit = {

    val book = new Book()
    book.setAuthor("dd").addChapter("dd")

    book set Title to "dddd"


    type |||| [A, B] = (A, B)


//    "this" |||| 12

//    Array[T] fromSome { type T <:JComponent }

//    new Exception() with LoggedException

  }
}
