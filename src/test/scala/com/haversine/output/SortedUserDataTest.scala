package com.haversine.output

import com.haversine.input.UserData

import org.scalatest.{FlatSpec, Matchers}


class SortedUserDataTest extends FlatSpec with Matchers  {

  "SortedUserData " should " should sort the userid based on ascending order" in {
    val list = List(UserData(13.0827,80.2707,10,"Vishwa Balaji"),UserData(53.807778,-7.714444,28,"Charlie Halligan"),
      UserData(53.038056,-7.653889,26,"Stephen McArdle") )
    val sorted = ProcessOutput.sortListByUserId(list)
    val expected = "List(UserData(13.0827,80.2707,10,Vishwa Balaji), UserData(53.038056,-7.653889,26,Stephen McArdle), UserData(53.807778,-7.714444,28,Charlie Halligan))"
    sorted.toString should be (expected)

  }

  "getUserIdAndName " should "return the id and name of users " in {
     val list = List(UserData(13.0827,80.2707,10,"Vishwa Balaji"), UserData(53.038056,-7.653889,26,"Stephen McArdle"))
     val expected = "List((10,Vishwa Balaji), (26,Stephen McArdle))"
     val result = ProcessOutput.getUserIdAndName(list);
     result.toString should be (expected)
  }


}
