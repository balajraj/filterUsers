package com.haversine.inputparse


import org.scalatest._

import scala.io.Source

class ParseInputTest extends FlatSpec with Matchers  {

  "ParseInput " should " parse the valid input data in json" in {
    val reader = Source.fromURL(getClass.getResource("/input.json"))
    val pInput =  ParseInput.processInput(reader)
    val expected = "List(UserData(52.986375,-6.043701,12,Christina McArdle), UserData(51.92893,-10.27699,1,Alice Cahill), UserData(51.8856167,-10.4240951,2,Ian McArdle), UserData(52.3191841,-8.5072391,3,Jack Enright), UserData(53.807778,-7.714444,28,Charlie Halligan), UserData(53.4692815,-9.436036,7,Frank Kehoe), UserData(54.0894797,-6.18671,8,Eoin Ahearn), UserData(53.038056,-7.653889,26,Stephen McArdle), UserData(54.1225,-8.143333,27,Enid Gallagher), UserData(53.1229599,-6.2705202,6,Theresa Enright), UserData(52.2559432,-7.1048927,9,Jack Dempsey), UserData(52.240382,-6.972413,10,Georgina Gallagher), UserData(53.2451022,-6.238335,4,Ian Kehoe), UserData(53.1302756,-6.2397222,5,Nora Dempsey), UserData(53.008769,-6.1056711,11,Richard Finnegan), UserData(53.1489345,-6.8422408,31,Alan Behan), UserData(53.0,-7.0,13,Olive Ahearn), UserData(51.999447,-9.742744,14,Helen Cahill), UserData(52.966,-6.463,15,Michael Ahearn), UserData(52.366037,-8.179118,16,Ian Larkin), UserData(54.180238,-5.920898,17,Patricia Cahill), UserData(53.0033946,-6.3877505,39,Lisa Ahearn), UserData(52.228056,-7.915833,18,Bob Larkin), UserData(54.133333,-6.433333,24,Rose Enright), UserData(55.033,-8.112,19,Enid Cahill), UserData(53.521111,-9.831111,20,Enid Enright), UserData(51.802,-9.442,21,David Ahearn), UserData(54.374208,-8.371639,22,Charlie McArdle), UserData(53.74452,-7.11167,29,Oliver Ahearn), UserData(53.761389,-7.2875,30,Nick Enright), UserData(54.080556,-6.361944,23,Eoin Gallagher), UserData(52.833502,-8.522366,25,David Behan))"
    pInput.toString should be (expected)
  }

  "ParseInput " should "throw exception if whole file is invalid json" in {

    intercept[InputInvalidException] {
      val reader = Source.fromURL(getClass.getResource("/invalidinput.json"))
      val pInput =  ParseInput.processInput(reader)
    }

  }

  "ParseInput " should "work with partially correct data" in {
    val reader = Source.fromURL(getClass.getResource("/partial.json"))
    val pInput =  ParseInput.processInput(reader)
    val expected = "List(UserData(52.2559432,-7.1048927,9,Jack Dempsey))"
    pInput.toString should be (expected)
  }
}
