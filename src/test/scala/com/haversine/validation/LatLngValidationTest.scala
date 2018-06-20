package com.haversine.validation

import com.haversine.input.UserData
import com.haversine.inputparse.ParseInput
import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source


class LatLngValidationTest extends FlatSpec with Matchers  {

  "LatLngValidation " should " filter out userdata with invalid lat/lng" in {

    val list = List ( UserData(52.2559432,-7.1048927,9,"Jack Dempsey"),
      UserData(152.2559432,-7.1048927,10,"Savitha Krishnan"),UserData(52.2559432,-1777.1048927,11,"Krish Raja"))

    val pLatLng = LatLngValidation.validateLatLng(list)
    val expected = "List(UserData(52.2559432,-7.1048927,9,Jack Dempsey))"
    pLatLng.toString should be (expected)
  }
}