$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/calculator/calculator.feature");
formatter.feature({
  "name": "Calculate",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Calculate with operator",
  "description": "",
  "keyword": "Scenario"
});
