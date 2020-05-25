package calculator.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CalculatorPage {
    WebDriver driver;
    WebDriverWait wait;

    public CalculatorPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void InitElement() {
        PageFactory.initElements(driver, this);
    }

    public void ClickNumber(String number) {
        if (number == null || number.equals("")) {
            return;
        }
        for (char ch: number.toCharArray()) {
            if (ch == '.') {
                WebElement decimalButton = this.driver.findElement(By.xpath("//span[@aria-label='Decimal']"));
                this.wait.until(ExpectedConditions.elementToBeClickable(decimalButton)).click();
            } else if (ch == '-') {
                WebElement minusButton = this.driver.findElement(By.xpath("//span[@aria-label='Minus']"));
                this.wait.until(ExpectedConditions.elementToBeClickable(minusButton)).click();
            } else {
                WebElement numberButton = this.driver.findElement(By.xpath("//span[@aria-label='" + ch + "']"));
                this.wait.until(ExpectedConditions.elementToBeClickable(numberButton)).click();
            }
        }
    }

    public void ClickOperator(String operator) {
        if (operator == null || operator.equals("")) {
            return;
        }
        this.InitElement();
        switch (operator) {
            case "+":
                this.wait.until(ExpectedConditions.elementToBeClickable(plusButton)).click();
                break;
            case "-":
                this.wait.until(ExpectedConditions.elementToBeClickable(minusButton)).click();
                break;
            case "*":
                this.wait.until(ExpectedConditions.elementToBeClickable(timesButton)).click();
                break;
            case "/":
                this.wait.until(ExpectedConditions.elementToBeClickable(divideButton)).click();
                break;
            default:
                break;
        }
    }

    @FindBy(xpath = "//span[@aria-label='Plus']")
    public WebElement plusButton;

    @FindBy(xpath = "//span[@aria-label='Minus']")
    public WebElement minusButton;

    @FindBy(xpath = "//span[@aria-label='Times']")
    public WebElement timesButton;

    @FindBy(xpath = "//span[@aria-label='Divide']")
    public WebElement divideButton;

    @FindBys(
            @FindBy(xpath = "//div[@class='dcg-exp-output-container']")
    )
    public List<WebElement> resultsText;

    @FindBy(xpath = "//span[@aria-label='Enter']")
    public WebElement enterButton;

}
