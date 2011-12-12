package info.daviot.lceb

/**
 * Symetric trees (left,right) is same as (right,left)
 */
abstract class BinaryTree[T]
case class Tree[T](left: BinaryTree[T], right: BinaryTree[T]) extends BinaryTree[T] {
  override def equals(a: Any): Boolean = {
    a match {
      case Tree(l, r) => (left == l && right == r) || (left == r && right == l)
      case _ => false
    }
  }
}
case class Value[T](value: T) extends BinaryTree[T]

object Tree {
  def apply[T](a: T, b: T): BinaryTree[T] = Tree(Value(a), Value(b))
  def apply[T](a: BinaryTree[T], b: T): BinaryTree[T] = Tree(a, Value(b))
  def apply[T](a: T, b: BinaryTree[T]): BinaryTree[T] = Tree(Value(a), b)
}

object BinaryTree {
  def allCombinaisons[T](values: Seq[T]): Set[BinaryTree[T]] = {
    values.toList match {
      case Nil => Set.empty
      case head :: tail => combine(allCombinaisons(tail), head)
    }
  }

  private def combine[T](trees: Set[BinaryTree[T]], value: T): Set[BinaryTree[T]] = {
    trees.size match {
      case 0 => Set(Value(value))
      case _ => trees map {
        _ match {
          case v: Value[T] => Set(Tree(value, v))
          case Tree(a, b) =>
            val l1 = combine(Set(a), value) map (Tree(_, b))
            val l2 = combine(Set(b), value) map (Tree(a, _))
            l1 ++ l2 + Tree(Tree(a, b), Value(value))
        }
      } flatten
    }
  }

}