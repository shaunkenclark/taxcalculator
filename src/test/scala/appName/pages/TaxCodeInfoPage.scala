package appName.pages

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by shaunclark on 15/09/17.
  */
object TaxCodeInfoPage extends WebPage{
  override val url: String = getUrl(7788) + "/estimate-paye-take-home-pay/tax-code"
  println(url)

  override def expectedPageHeader: Option[String] = Some("Do you want to use your current tax code?")
  override def expectedPageTitle: Option[String] = Some("Do you want to use your current tax code?")

  def getNoRadio()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("tax-code-no"))
  }

  def getYesRadio()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("tax-code-yes"))
  }

  def getContinueButton()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("tc-continue"))
  }
}
