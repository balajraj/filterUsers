package com.haversine.validation

import com.haversine.input.UserData

object LatLngValidation {

  /**
    * Does validation to check whether the lat/lng is within the given limits
    *
    * @param list input data
    * @return filtered data
    */
  def validateLatLng(list: List[UserData]): List[UserData] = {
    val filtered = list.filter(x => checkLat(x.latitude)).
      filter(y => checkLng(y.longitude))
    filtered
  }

  def checkLat(lat: Double): Boolean = {
    (lat >= -90 && lat <= 90)
  }

  def checkLng(lng: Double): Boolean = {
    (lng >= -180 && lng <= 180)
  }

}
