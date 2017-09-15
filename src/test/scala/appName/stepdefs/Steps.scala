package appName.stepdefs

import cats.syntax.either._
import cucumber.api.scala.{EN, ScalaDsl}
import appName.utils.Driver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.scalatest.Matchers

/**
  * Created by shaunclark on 15/09/17.
  */
trait Steps extends ScalaDsl with EN with Matchers {
  import Steps._

  implicit def getDriverUnsafe: WebDriver = _driver.getOrElse(sys.error("Driver does not exist"))
  implicit def getWaitUnsafe: WebDriverWait = _wait.getOrElse(sys.error("WebDriverWait object does not exist"))

  Before { _ =>
    if(_driver.isEmpty) {
      val d = Driver.newWebDriver().leftMap(e => sys.error(s"Could not find driver: $e")).merge
      _driver = Some(d)
    }

    if(_wait.isEmpty){
      val wdw = new WebDriverWait(_driver.get, 151, 1001)
      _wait = Some(wdw)
    }
  }
  After { _ =>
    _driver.foreach(_.quit())
    _driver = None
  }
}

object Steps {
  private var _driver: Option[WebDriver] = None
  private var _wait: Option[WebDriverWait] = None
}
