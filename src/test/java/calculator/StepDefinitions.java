package calculator;

import calculator.pageobjects.CalculatorPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    CalculatorPage calculatorPage;
    List<String> resultsCal;

    public StepDefinitions() {
        this.driver = Hook.driver;
        this.wait = Hook.wait;
        calculatorPage = new CalculatorPage(this.driver, this.wait);
    }

    @Given("^Open the web page calculator$")
    public void open_the_web_page_calculator() {
        this.driver.get("https://www.desmos.com/scientific");
    }

    @When("^Calculate numbers$")
    public void calculate_numbers(DataTable data) {
        calculatorPage.InitElement();
        List<Map<String, String>> lst = data.asMaps(String.class, String.class);
        resultsCal = new ArrayList<>();
        for (Map<String, String> s: lst) {
            for (String key : s.keySet()) {
                if (key.contains("number")) {
                    calculatorPage.ClickNumber(s.get(key));
                }
                if (key.contains("operator")) {
                    calculatorPage.ClickOperator(s.get(key));
                }
            }
            this.wait.until(ExpectedConditions.elementToBeClickable(calculatorPage.enterButton)).click();
            resultsCal.add(s.get("result"));
        }
    }

    @Then("^Check the result$")
    public void check_the_result() throws Throwable {
        calculatorPage.InitElement();
        Thread.sleep(1000);
        for (int i = 0; i < resultsCal.size(); i++) {
            Assert.assertEquals(resultsCal.get(i), calculatorPage.resultsText.get(i).getText().trim().substring(4).replace("−", "-"));
        }
    }

}
