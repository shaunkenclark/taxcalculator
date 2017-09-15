package appName.pages

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by shaunclark on 15/09/17.
  */
object ScottishIncomeTaxPage extends WebPage{
  override val url: String = "http://localhost:7788/estimate-paye-take-home-pay/scottish-tax"

  override def expectedPageHeader: Option[String] = Some("Do you pay the Scottish Income Tax Rate?")
  override def expectedPageTitle: Option[String] = Some("Do you pay the Scottish Income Tax Rate?")

  def getNoRadio()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("scottish-rate-no"))
  }

  def getYesRadio()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("scottish-rate-yes"))
  }

  def getContinueButton()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("sr-continue"))
  }
}
