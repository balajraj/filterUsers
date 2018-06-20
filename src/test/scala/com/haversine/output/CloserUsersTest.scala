import com.haversine.input.UserData
import com.haversine.inputparse.ParseInput
import com.haversine.output.CloserUsers
import com.haversine.validation.LatLngValidation
import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source

class CloserUsersTest extends FlatSpec with Matchers  {

  "CloserUsersTest " should " filter out users who are further away by 100 kms" in {

    val input:List[UserData] = List(
      new UserData(52.2559432,-7.1048927,9,"Jack Dempsey"),
      new UserData(13.0827,80.2707,10,"Vishwa Balaji"),
      new UserData(53.038056,-7.653889,26,"Stephen McArdle"))
    val util = new CloserUsers(53.339428, -6.257664,100)
    val dUsers = util.filterUserOnDist(input)
    val expected = "List(UserData(53.038056,-7.653889,26,Stephen McArdle))"
    dUsers.toString should be (expected)

  }

}