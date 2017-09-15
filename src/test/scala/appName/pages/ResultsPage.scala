package appName.pages

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by shaunclark on 15/09/17.
  */
object ResultsPage extends WebPage{
  override val url: String = getUrl(7788) + "/estimate-paye-take-home-pay/state-pension"

  override def expectedPageHeader: Option[String] = Some("Your estimated take-home pay")
  override def expectedPageTitle: Option[String] = Some("Your estimated take-home pay")

  def getResult()(implicit driver: WebDriver): String = {
    driver.findElement(By.id("your-take-home-pay-Year")).getText
  }
}
