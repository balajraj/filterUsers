package com.haversine.output

import com.haversine.input.UserData
import com.haversine.inputparse.InputInvalidException
import com.haversine.util.HaversineDistance
import com.haversine.validation.LatLngValidation

class CloserUsers(centerLat:Double, centerLng:Double, radius:Int) {

  if ( LatLngValidation.checkLat(centerLat) == false ||
       LatLngValidation.checkLng(centerLng) == false ) {
    throw new InputInvalidException("lat/lng invalid")
  }
  /**
    * Will filter based on given radius and center of the circle lat/lng
    * @param list of UserData to be filtered
    * @return filtered data
    */
  def filterUserOnDist (list:List[UserData]) : List[UserData] ={
    val distFiltered = list.filter( x => HaversineDistance.getDistanceBtwTwoPoints(
      centerLat,centerLng,x.latitude,x.longitude) <= radius)
    distFiltered
  }

}
