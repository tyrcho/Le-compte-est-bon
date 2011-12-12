package info.daviot.lceb

import java.util.ResourceBundle
import collection.JavaConversions._

object ProblemGenerator {
  lazy val numbers = ResourceBundle.getBundle("numbers")

  def generate(count: Int): (Seq[Int], Int) = {
    val available = util.Random.shuffle(numbers.getKeys.toSeq) take count map (_.toInt)
    val target = util.Random.nextInt(800) + 200
    (available, target)
  }
}