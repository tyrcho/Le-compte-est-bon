package info.daviot.lceb
import org.junit.Test
import org.junit.Assert
class BinaryTreeTest {
  @Test
  def empty {
    assertEquals(Set.empty, BinaryTree.allCombinaisons(Seq.empty))
  }

  @Test
  def one {
    assertEquals[BinaryTree[Int]](Set(Value(1)), BinaryTree.allCombinaisons(Seq(1)))
  }

  @Test
  def two {
    assertEquals(Set(Tree(1, 2)), BinaryTree.allCombinaisons(Seq(1, 2)))
  }

  @Test
  def three {
    val res = BinaryTree.allCombinaisons(Seq(1, 2, 3))
    assertEquals(Set(
      Tree(1, Tree(3, 2)),
      Tree(2, Tree(1, 3)),
      Tree(3, Tree(2, 1))), res)
  }

  @Test
  def four {
    Assert.assertEquals(15, BinaryTree.allCombinaisons(Seq(1, 2, 3, 4)).size)
  }

  @Test
  def six {
    Assert.assertEquals(945, BinaryTree.allCombinaisons(Seq(1, 2, 3, 4, 5, 6)).size)
  }

  def assertEquals[T](s1: Set[T], s2: Set[T]) {
    Assert.assertTrue(s2 forall ((s1.contains(_))))
    Assert.assertTrue(s1 forall ((s2.contains(_))))
  }
}