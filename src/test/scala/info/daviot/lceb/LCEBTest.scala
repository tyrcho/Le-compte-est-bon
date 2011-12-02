package info.daviot.lceb
import org.junit.Test
import org.junit.Assert

class LCEBTest {
  @Test
  def twoNumbers() {
    val res = LCEB.solve(Seq(3, 7), 21)
    Assert.assertEquals(Op(3, 7, Prod), res.get)
  }

  @Test
  def threeNumbers() {
    val res = LCEB.solve(Seq(3, 7, 1), 28)
    Assert.assertEquals(Op(Op(3, 1, Add), 7, Prod), res.get)
  }
}