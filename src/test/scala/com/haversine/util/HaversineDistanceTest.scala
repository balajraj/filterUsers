import com.haversine.util.HaversineDistance
import org.scalatest.{FlatSpec, Matchers}

class HaversineDistanceTest extends FlatSpec with Matchers {

  "HaversineDistance " should " return the distance between two lat/lng in kms" in {
    val ch_lat = 13.0827;
    val ch_lng = 80.2707;
    val blr_lat = 12.9716;
    val blr_lng = 77.5946;

    val dist = HaversineDistance.getDistanceBtwTwoPoints(ch_lat, ch_lng, blr_lat, blr_lng)
    val expected = 290.1720249530612
    dist should be(expected)

  }


}