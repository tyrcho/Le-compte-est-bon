package info.daviot.lceb
import util.Random._

object LCEB {
  def solve(numbers: Seq[Int], target: Int): Option[Graph] = {
    val combinaisons = BinaryTree.allCombinaisons(numbers)
    (combinaisons.view map makePossibleGraphs flatten) find (target == _.eval.getOrElse(0))
  }

  def solveAll(numbers: Seq[Int], target: Int): Iterable[Graph] = {
    val combinaisons = BinaryTree.allCombinaisons(numbers)
    (combinaisons.view map makePossibleGraphs flatten) filter (target == _.eval.getOrElse(0)) seq
  }

  private def makePossibleGraphs(tree: BinaryTree[Int]): Seq[Graph] = {
    tree match {
      case Value(i) => Seq(Const(i))
      case Tree(l, r) =>
        for (
          lg <- makePossibleGraphs(l);
          lr <- makePossibleGraphs(r);
          o <- Operation.operations
        ) yield Op(lg, lr, o)
    }
  }

  def generateProblem(size: Int): (Seq[Int], Int) = {
    (1 to size map (_ => nextInt(9) + 1), nextInt(800) + 200)
  }

  def main(args: Array[String]) {
    val (numbers, target) = (Seq(3, 9, 1, 7, 5, 4), 715) //generateProblem(6)
    println(numbers)
    println(target)
    val start = System.currentTimeMillis
    val res = solveAll(numbers, target)
    println(System.currentTimeMillis - start)
    res foreach println
  }
}