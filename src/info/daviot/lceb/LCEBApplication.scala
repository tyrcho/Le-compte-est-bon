package info.daviot.lceb

import com.vaadin.Application
import com.vaadin.ui._

class LCEBApplication extends Application {
  def init(): Unit = {
    setMainWindow(new Window("LCEB"))
    getMainWindow.addComponent(buildContents)
  }

  val inputNumbers = 1 to 6 map inputNumber
  val target = new LabeledField("Cible")
  val solution = new TextArea {
    setRows(8)
  }

  var solveButton = new Button("Résoudre", new Button.ClickListener {
    def buttonClick(event: Button#ClickEvent) { solve }
  })

  def solve {
    val res = LCEB.solve(inputNumbers map (_.intValue), target.intValue)
    solution.setValue(res.toString)
  }

  def buildContents: Panel =
    new Panel {
      addComponent(new Panel {
        inputNumbers foreach { n => addComponent(n) }
      })
      addComponent(new Panel {
        addComponent(target)
        addComponent(solveButton)
      })
      addComponent(solution)
    }

  def inputNumber(i: Int) = new LabeledField("Nombre " + i)

  class LabeledField(label: String, default: String = "0") extends TextField(label, default) {
    def intValue = getValue.toString.toInt
  }
}