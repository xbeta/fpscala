package fpscala.parallelism

import fpscala.parallelism._
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.OptionValues._

class NonblockingSpec extends FlatSpec with Matchers {

  "Summing an indexed seq" should "add all all values" in {
    val a = IndexedSeq(1,2,3)
    assert(Par.sum(a) == 6)
  }
}
