package info.daviot.lceb
import scala.swing._
import BorderPanel.Position._
import scala.swing.event.FocusGained

object UI extends SimpleSwingApplication {
  val inputNumbers = 1 to 6 map inputNumber
  val target = inputField("Cible")
  val solution = new Label

  var solveButton = new Button {
    action = Action("Résoudre") { solve }
  }

  def top = new MainFrame {
    title = "Le compte est bon"
    contents = buildContents
  }

  def solve {
    val res = LCEB.solve(inputNumbers map (_.intValue), target.intValue)
    solution.text = res.toString
  }

  def buildContents: Panel =
    new BorderPanel {
      add(new FlowPanel { inputNumbers foreach (contents += _) }, North)
      add(new FlowPanel {
        contents += target
        contents += solveButton
      }, West)
      add(solution, South)
    }

  def inputNumber(i: Int) = inputField("Nombre " + i)

  def inputField(label: String) = new LabeledField(label)

  class LabeledField(label: String, default: String = "0", columns: Int = 4) extends FlowPanel {
    val field = new TextField(default, columns)

    contents += new Label(label)
    contents += field

    listenTo(field)
    reactions += {
      case FocusGained(_, _, _) => field.selectAll
    }

    def intValue = field.text.toInt
  }
}