package com.song

object ObjectDemo {


  def main(args: Array[String]): Unit = {

    println(Account.getCount())

    val account = Account("aaaa")
    println(account.name)

    DoNothing.redo()
    println(DoNothing.describe)

  }


}
