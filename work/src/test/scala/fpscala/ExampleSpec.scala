package fpscala

import fpscala.Example._
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.OptionValues._

class ExampleSpec extends FlatSpec with Matchers {

  "A List" should "append values LTR" in {
    val ex2 = Cons(1, Nil)
    assert(List.append(ex2, ex2) == List(1,1))
    println(ex2)
  }
}
