package com.haversine.inputparse


import com.haversine.input.UserData
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

import scala.io._

import org.slf4j.LoggerFactory

object ParseInput {


  val mapper = new ObjectMapper with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  val logger = LoggerFactory.getLogger("ParseInput")

  /**
    * The routine will parse the json and only well formed json data is allowed to pass through
    * The method will try to do work with valid data, if the whole file data is invalid exception
    * is thrown
    *
    * @param stream is the input json file as stream
    * @return List of userdata
    */
  def processInput(stream: BufferedSource): List[UserData] = {

    val list: List[UserData] = stream.getLines().map(x =>
      try {
        Some(mapper.readValue[UserData](x))
      }
      catch {
        case ex: Exception => logger.info("Ignoring the json parse error.")
          None
      }
    ).filter(_.isDefined).map(y => y.get).toList
    if (list.isEmpty) {
      throw new InputInvalidException("File has no valid json")
    }
    list
  }


}
