package info.daviot.lceb

abstract class Operation {
  def apply(a: Int, b: Int): Option[Int]
  def commutative: Boolean
}

object Operation {
  def operations = Seq(Add, Sub, Prod, Div)
}

case object Add extends Operation {
  def apply(a: Int, b: Int) = Some(a + b)
  def commutative = true
  override def toString = "+"
}
case object Sub extends Operation {
  def apply(a: Int, b: Int) = if (a > b) Some(a - b) else None
  def commutative = false
  override def toString = "-"
}
case object Prod extends Operation {
  def apply(a: Int, b: Int) = Some(a * b)
  def commutative = true
  override def toString = "*"
}
case object Div extends Operation {
  def apply(a: Int, b: Int) = b match {
    case 0 => None
    case _ => if (a % b == 0) Some(a / b) else None
  }
  def commutative = false
  override def toString = "/"
}