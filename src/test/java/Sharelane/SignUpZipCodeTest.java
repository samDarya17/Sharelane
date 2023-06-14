package Sharelane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class SignUpZipCodeTest extends BaseTest {

    String zipCodeInputLocator = "zip_code";
    String continueButtonLocator = "[value=Continue]";
    String registerButtonLocator = "[value=Register]";
    String errorMessageLocator = "[class='error_message']";


    @Test
    public void zipCodeShouldIdAccept5Digits() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        boolean isDisplayed = driver.findElement(By.cssSelector(registerButtonLocator)).isDisplayed();

        Assert.assertTrue(isDisplayed, "Нужная страница не открылась");


    }

    @Test
    public void zipCodeShouldIdAccept4Digits() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("1234");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");

    }

    @Test
    public void leaveZipCodeFieldEmpty() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        assertEquals(text, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");

    }

    @Test
    public void zipCodeShouldIdAccept6Digits() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("123456");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");

    }

    @Test
    public void zipCodeShouldIdAcceptLatinLetters() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("asdfg");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");

    }

    @Test
    public void zipCodeShouldIdAcceptRussianLetters() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("абвгд");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");

    }

    @Test
    public void zipCodeShouldIdAcceptSpecialCharacters() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("1@8!9");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        String text1 = driver.findElement(By.cssSelector(errorMessageLocator)).getText();

        assertEquals(text1, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");

    }
}
  