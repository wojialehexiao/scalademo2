package com.song

object DoNothing extends UndoRedoAction ("do nothing"){
  override def redo(): Unit = {}
  override def undo(): Unit = {}
}


abstract class UndoRedoAction(val describe:String){
  def redo():Unit
  def undo():Unit
}