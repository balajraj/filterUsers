package com.haversine.inputparse

/**
  * The exception is thrown for incorrect input data
  */
class InputInvalidException(msg: String) extends Exception {

  override def getMessage : String  = {
    return msg
  }
}
