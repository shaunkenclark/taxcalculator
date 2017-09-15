$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("TaxCalculation.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# new feature"
    },
    {
      "line": 2,
      "value": "# Tags: optional"
    }
  ],
  "line": 4,
  "name": "Tax Calculator",
  "description": "",
  "id": "tax-calculator",
  "keyword": "Feature"
});
formatter.before({
  "duration": 830442909,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Complete tax calculation",
  "description": "",
  "id": "tax-calculator;complete-tax-calculation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I navigate to the tax calculator page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I enter an amount and navigate with no to all option",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I select get results",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I get the correct results",
  "keyword": "Then "
});
formatter.match({
  "location": "TaxCalculationSteps.scala:11"
});
formatter.result({
  "duration": 764083253,
  "status": "passed"
});
formatter.match({
  "location": "TaxCalculationSteps.scala:14"
});
formatter.result({
  "duration": 1169577365,
  "status": "passed"
});
formatter.match({
  "location": "TaxCalculationSteps.scala:33"
});
formatter.result({
  "duration": 196707498,
  "status": "passed"
});
formatter.match({
  "location": "TaxCalculationSteps.scala:36"
});
formatter.result({
  "duration": 33805203,
  "status": "passed"
});
formatter.after({
  "duration": 70710071,
  "status": "passed"
});
});