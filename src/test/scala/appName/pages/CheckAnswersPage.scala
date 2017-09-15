package appName.pages

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by shaunclark on 15/09/17.
  */
object CheckAnswersPage extends WebPage{
  override val url: String = getUrl(7788) + "/estimate-paye-take-home-pay/your-answers"

  override def expectedPageHeader: Option[String] = Some("Check your answers")
  override def expectedPageTitle: Option[String] = Some("Check your answers")

  def getResultsButton()(implicit driver: WebDriver): WebElement = {
    driver.findElement(By.id("get-results"))
  }
  def getAnswers()(implicit driver: WebDriver): List[String] = {
    List(driver.findElement(By.id("value-income")).getText,
      driver.findElement(By.id("value-pension-state")).getText,
      driver.findElement(By.id("value-tax-code")).getText,
      driver.findElement(By.id("value-scottish_rate")).getText)
  }
}
