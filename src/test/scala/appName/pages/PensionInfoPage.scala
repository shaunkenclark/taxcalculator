package appName.pages

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by shaunclark on 15/09/17.
  */
object PensionInfoPage extends WebPage{
  override val url: String = "http://localhost:7788/estimate-paye-take-home-pay/state-pension"

  override def expectedPageHeader: Option[String] = Some("Are you over the State Pension age?")
  override def expectedPageTitle: Option[String] = Some("Are you over the State Pension age?")

  def getNoRadio()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("over-state-pension-age-no"))
  }

  def getYesRadio()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("over-state-pension-age-yes"))
  }

  def getContinueButton()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("sp-continue"))
  }
}
