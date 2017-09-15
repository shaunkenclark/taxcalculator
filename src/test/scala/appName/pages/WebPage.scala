package appName.pages

import appName.stepdefs.Steps
import appName.utils.Configuration
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.openqa.selenium.support.ui.ExpectedConditions._
import org.scalatest.selenium.WebBrowser
import org.scalatest.time.{Seconds, Span}
import org.scalatest.{Assertions, Matchers}

import scala.concurrent.duration.Duration

/**
  * Created by shaunclark on 15/09/17.
  */
trait WebPage extends org.scalatest.selenium.Page with WebBrowser with Assertions with Matchers with Steps {
  val relativeUrl = ""
  val port = 8080

  lazy val envUrl: String = Configuration.settings.url

  implicit val duration: Duration = Span(2, Seconds)

  def waitFor[T](condition: ExpectedCondition[T])(implicit wait: WebDriverWait): T = wait.until(condition)

  def getUrl(port: Int) = if(envUrl.startsWith("http://local")) s"$envUrl:$port" else envUrl

  def goToPage(): Unit = go to url

  def getCurrentUrl()(implicit driver: WebDriver): String = driver.getCurrentUrl

  def getPageContent()(implicit  driver: WebDriver): String = driver.getPageSource

  protected def pageHeader: Query = cssSelector("h1")

  def pageHeaderText() = {
    pageHeader.element.text
  }

  def waitForPageToLoad: WebElement = {
    waitFor(visibilityOfElementLocated(pageHeader.by))
  }

  def expectedPageTitle: Option[String]
  def expectedPageHeader: Option[String]

  protected def pageHeaderShouldBeCorrect(): Unit = {
    expectedPageHeader.foreach(pageHeaderText() shouldBe _)
  }

  protected def pageTitleShouldBeCorrect(): Unit = {
    expectedPageTitle.foreach(pageTitle shouldBe _)
  }

  def shouldBeLoaded(): Unit = {
    pageTitleShouldBeCorrect()
    pageTitleShouldBeCorrect()
  }

}
