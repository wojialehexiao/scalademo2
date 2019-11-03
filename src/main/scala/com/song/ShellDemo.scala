package com.song

import java.io.File

import sys.process._

object ShellDemo {

  def main(args: Array[String]): Unit = {

    //直接执行，标准输出会打印出结果，返回值为0-正常， 否则异常
    val res = "ls -al .".!

    println(res)


    val result = "ls -l .".!!

    println(result)

    //管道符
    ("ls -al" #| "grep data").!

    //重定向输出
    ("ls -al" #> new File("data/filelist.txt")).!

    //重定向输入
    ("grep data" #< new File("data/filelist.txt")).!



  }
}
