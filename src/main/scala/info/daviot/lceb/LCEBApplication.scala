package info.daviot.lceb

import com.vaadin.Application
import com.vaadin.ui._

class LCEBApplication extends Application {
  val count = 6
  val inputNumbers = 1 to count map buildInputNumber

  def init(): Unit = {
    setMainWindow(new Window("LCEB"))
    reset
    getMainWindow.addComponent(contents)
  }

  def reset {
    val (numbers, tgt) = ProblemGenerator.generate(6)
    0 until count foreach { i =>
      inputNumbers(i).setValue(numbers(i))
    }
    target.setValue(tgt)
  }

  val target = new LabeledField("Cible")
  val solution = new TextArea {
    setRows(8)
  }

  var solveButton = new Button("Resoudre", new Button.ClickListener {
    def buttonClick(event: Button#ClickEvent) { solve }
  })

  def solve {
    val res = LCEB.solve(inputNumbers map (_.intValue), target.intValue)
    solution.setValue(res.getOrElse("no solution").toString)
  }

  lazy val contents: Panel =
    new Panel {
      addComponent(new Panel {
        inputNumbers foreach { n => addComponent(n) }
      })
      addComponent(new Panel {
        addComponent(target)
        addComponent(solveButton)
      })
      addComponent(solution)
      addComponent(new Button("Reset", new Button.ClickListener {
        def buttonClick(event: Button#ClickEvent) { reset }
      }))
    }

  def buildInputNumber(i: Int) = new LabeledField("Nombre " + i)

  class LabeledField(label: String, default: String = "0") extends TextField(label, default) {
    def intValue = getValue.toString.toInt
  }
}