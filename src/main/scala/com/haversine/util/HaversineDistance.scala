package com.haversine.util

object HaversineDistance {


  val radiusOfEarth = 6371; // kms
  /**
    * The function returns distance in kms between two lat/lng
    * @param lat1 lat of first location
    * @param lng1 lng of first location
    * @param lat2 lat of second location
    * @param lng2 lng of second location
    * @return distance in kms
    */
  def getDistanceBtwTwoPoints(lat1:Double, lng1:Double, lat2:Double, lng2:Double): Double =
  {
    val φ1 = lat1.toRadians;
    val φ2 = lat2.toRadians;
    val Δφ = (lat2-lat1).toRadians;
    val Δλ = (lng2-lng1).toRadians;

    val a = Math.sin(Δφ/2) * Math.sin(Δφ/2) +
      Math.cos(φ1) * Math.cos(φ2) *
        Math.sin(Δλ/2) * Math.sin(Δλ/2);
    val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

    val distance = radiusOfEarth * c;
    distance
  }

}
