package Sharelane;

import Sharelane.BaseTest;
import org.openqa.selenium.By;
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

        driver.get(BASE_URL + "cgi-bin/register.py");
        driver.findElement(By.name(zipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(continueButtonLocator)).click();
        boolean isDisplayed = driver.findElement(By.cssSelector(registerButtonLocator)).isDisplayed();

        Assert.assertTrue(isDisplayed, "Нужная страница не открылась");
    }
}




  