package com.haversine


import com.haversine.inputparse.ParseInput
import com.haversine.output.{CloserUsers, ProcessOutput}
import com.haversine.validation.LatLngValidation

import scala.io.Source

object UserFilterApp {


  def main(args: Array[String]): Unit = {

    if (args.length < 4) {
      println("Please pass in radius,lat,lng,inputfile before continuing ")
      System.exit(0)
    }
    val radius: Int = args(0).toInt
    val lat: Double = args(1).toDouble
    val lng: Double = args(2).toDouble
    val util = new CloserUsers(lat, lng, radius)
    val source = Source.fromFile(args(3))
    val input = ParseInput.processInput(source)
    val validated = LatLngValidation.validateLatLng(input)

    val nearBy = util.filterUserOnDist(validated);
    val sorted = ProcessOutput.sortListByUserId(nearBy)
    ProcessOutput.getUserIdAndName(sorted).foreach(x => println(x._1 + " " + x._2))

  }

}
