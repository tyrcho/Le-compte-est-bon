package info.daviot.lceb

abstract class Graph {
  def eval: Option[Int]
}

object Op {
  def apply(a: Int, b: Int, op: Operation): Op = Op(Const(a), Const(b), op)
  def apply(a: Int, b: Graph, op: Operation): Op = Op(Const(a), b, op)
  def apply(a: Graph, b: Int, op: Operation): Op = Op(a, Const(b), op)
}

case class Op(a: Graph, b: Graph, operation: Operation) extends Graph {
  def eval = {
    (a.eval, b.eval) match {
      case (None, _) => None
      case (_, None) => None
      case (Some(ar), Some(br)) => operation(ar, br)
    }
  }

  override def toString = format("(%s %s %s) => %s %n", a, operation, b, eval.get)

  override def equals(obj: Any): Boolean = {
    obj match {
      case Op(oa, ob, oop) => oop == operation && (
        (oa == a && ob == b) ||
        (operation.commutative && oa == b && ob == a))
      case _ => false
    }
  }
}

case class Const(i: Int) extends Graph {
  def eval = Some(i)
  override def toString = i.toString
}