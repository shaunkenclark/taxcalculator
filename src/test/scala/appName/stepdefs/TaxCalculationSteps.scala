package appName.stepdefs

import appName.pages._
import com.sun.webkit.WebPage

/**
  * Created by shaunclark on 15/09/17.
  */
class TaxCalculationSteps extends Steps {

  Given("""^I navigate to the tax calculator page$""") { () =>
    TaxCalcLandingPage.goToPage()
  }
  When("""^I enter an amount and navigate with no to all option$""") { () =>
    TaxCalcLandingPage.getTextBox().sendKeys("10000")
    TaxCalcLandingPage.getYearlyRadio().click()
    TaxCalcLandingPage.getContinueButton().submit()

    PensionInfoPage.shouldBeLoaded()
    PensionInfoPage.getNoRadio().click()
    PensionInfoPage.getContinueButton().submit()

    TaxCodeInfoPage.shouldBeLoaded()
    TaxCodeInfoPage.getNoRadio().click()
    TaxCodeInfoPage.getContinueButton().submit()

    ScottishIncomeTaxPage.shouldBeLoaded()
    ScottishIncomeTaxPage.getNoRadio().click()
    ScottishIncomeTaxPage.getContinueButton().submit()
  }
  And("""^I select get results$""") { () =>
    CheckAnswersPage.shouldBeLoaded()
    val answers: List[String] = CheckAnswersPage.getAnswers()
    answers(0) shouldBe "£10,000 a year"
    answers(1) shouldBe "No"
    answers(2) shouldBe "No - we’ll use the default (1150L)"
    answers(3) shouldBe "No"
    CheckAnswersPage.getResultsButton().click()
  }
  Then("""I get the correct results$""") { () =>
    ResultsPage.shouldBeLoaded()
    ResultsPage.getResult() shouldBe "£9,779.68 a year"
  }
}
