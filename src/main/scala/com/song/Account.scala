package com.song


object Account {

  var value: Int = 0

  def getCount(): Int = {
    value += 1
    value
  }

  def apply: Account = new Account()
  def apply(name:String): Account = new Account(name)
}

class Account{

  var name:String = _

  def this(name:String) = {
    this()
    this.name = name
  }
}