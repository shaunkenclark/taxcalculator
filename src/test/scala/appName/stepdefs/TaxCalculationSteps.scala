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

    CheckAnswersPage.shouldBeLoaded()
  }
  And("""^I select get results$""") { () =>
    CheckAnswersPage.getResultsButton().click()
  }
  Then("""I get the correct results$""") { () =>
    ResultsPage.shouldBeLoaded()
    ResultsPage.getResult() == "£9,779.68 a year"
  }
}
