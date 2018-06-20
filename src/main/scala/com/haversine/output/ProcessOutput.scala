package com.haversine.output

import com.haversine.input.UserData

object ProcessOutput {

  /**
    * Sort the userData based on userId
    *
    * @param list unsorted input
    * @return sorted output
    */
  def sortListByUserId(list: List[UserData]): List[UserData] = {
    val sorted = list.sortWith(_.user_id < _.user_id)
    sorted
  }

  /**
    * Return just userid and name from the input list
    *
    * @param list with UserData object
    * @return tuple with id,name
    */
  def getUserIdAndName(list: List[UserData]): List[(Int, String)] = {
    list.map(x => (x.user_id, x.name))
  }

}
