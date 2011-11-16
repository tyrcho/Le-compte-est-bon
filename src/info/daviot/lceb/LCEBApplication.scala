package info.daviot.lceb

import com.vaadin.Application
import com.vaadin.ui._

class LCEBApplication extends Application {
  def init(): Unit = {
    setMainWindow(new Window("LCEB - Scala Rocks!"))
    getMainWindow.addComponent(new Label("Hello World!"))
  }
}