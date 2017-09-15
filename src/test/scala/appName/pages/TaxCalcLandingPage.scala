package appName.pages

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by shaunclark on 15/09/17.
  */
object TaxCalcLandingPage extends WebPage{
  override val url: String = getUrl(7788) + "/estimate-paye-take-home-pay"

  override def expectedPageHeader: Option[String] = Some("How much do you get paid?")
  override def expectedPageTitle: Option[String] = Some("How much do you get paid?")

  def getTextBox()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("pay-amount"))
  }
  def getHourlyRadio()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("hourly"))
  }
  def getDailyRadio()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("daily"))
  }
  def getWeeklyRadio()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("weekly"))
  }
  def getMonthlyRadio()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("monthly"))
  }
  def getYearlyRadio()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("yearly"))
  }
  def getContinueButton()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("p-continue"))
  }
}
