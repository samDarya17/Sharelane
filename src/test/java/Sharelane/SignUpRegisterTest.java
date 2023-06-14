package Sharelane;

import Sharelane.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpRegisterTest extends BaseTest {

    @Test
    public void registerUserWithValeDate() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Dasha");
        driver.findElement(By.name("last_name")).sendKeys("Sam");
        driver.findElement(By.name("email")).sendKeys("dasam@mail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value='Register']")).click();
        boolean confermationMessage = driver.findElement(By.cssSelector("[class='confirmation_message']")).isDisplayed();

        Assert.assertTrue(confermationMessage, "Пользователь не перешел на страницу confirmation_message");

    }

    @Test
    public void leaveAllRegistrationFieldsEmpty() {
        driver.get(BASE_URL + "cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("firstnameInputLocator")).sendKeys("");
        driver.findElement(By.name("lastnameInputLocator")).sendKeys("");
        driver.findElement(By.name("emailInputLocator")).sendKeys("");
        driver.findElement(By.name("passwordInputLocatorOne")).sendKeys("");
        driver.findElement(By.name("passwordInputLocatorTwo")).sendKeys("");
        driver.findElement(By.cssSelector("registerButtonLocator")).click();
        String text1 = driver.findElement(By.cssSelector("errorMessageLocator")).getText();

        Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Пользователь не зарегистрировался");

    }

    @Test
    public void leaveFirstNameFieldEmpty() {
        driver.get(BASE_URL + "cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("firstnameInputLocator")).sendKeys("");
        driver.findElement(By.name("lastnameInputLocator")).sendKeys("Sam");
        driver.findElement(By.name("emailInputLocator")).sendKeys("dasam@mail.com");
        driver.findElement(By.name("passwordInputLocatorOne")).sendKeys("12345");
        driver.findElement(By.name("passwordInputLocatorTwo")).sendKeys("12345");
        driver.findElement(By.cssSelector("registerButtonLocator")).click();
        String text1 = driver.findElement(By.cssSelector("errorMessageLocator")).getText();

        Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Пользователь не зарегистрировался");

    }

    @Test
    public void leaveLastNameFieldEmpty() {
        driver.get(BASE_URL + "cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("firstnameInputLocator")).sendKeys("Dasha");
        driver.findElement(By.name("lastnameInputLocator")).sendKeys("");
        driver.findElement(By.name("emailInputLocator")).sendKeys("dasam@mail.com");
        driver.findElement(By.name("passwordInputLocatorOne")).sendKeys("12345");
        driver.findElement(By.name("passwordInputLocatorTwo")).sendKeys("12345");
        driver.findElement(By.cssSelector("registerButtonLocator")).click();
        String text1 = driver.findElement(By.cssSelector("errorMessageLocator")).getText();

        Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Пользователь не зарегистрировался");

    }

    @Test
    public void leaveEmailFieldEmpty() {
        driver.get(BASE_URL + "cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("firstnameInputLocator")).sendKeys("Dasha");
        driver.findElement(By.name("lastnameInputLocator")).sendKeys("Sam");
        driver.findElement(By.name("emailInputLocator")).sendKeys("");
        driver.findElement(By.name("passwordInputLocatorOne")).sendKeys("12345");
        driver.findElement(By.name("passwordInputLocatorTwo")).sendKeys("12345");
        driver.findElement(By.cssSelector("registerButtonLocator")).click();
        String text1 = driver.findElement(By.cssSelector("errorMessageLocator")).getText();

        Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Пользователь не зарегистрировался");
    }

    @Test
    public void leavePasswordOneFieldEmpty() {
        driver.get(BASE_URL + "cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("firstnameInputLocator")).sendKeys("Dasha");
        driver.findElement(By.name("lastnameInputLocator")).sendKeys("Sam");
        driver.findElement(By.name("emailInputLocator")).sendKeys("dasam@mail.com");
        driver.findElement(By.name("passwordInputLocatorOne")).sendKeys("");
        driver.findElement(By.name("passwordInputLocatorTwo")).sendKeys("12345");
        driver.findElement(By.cssSelector("registerButtonLocator")).click();
        String text1 = driver.findElement(By.cssSelector("errorMessageLocator")).getText();

        Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Пользователь не зарегистрировался");
    }

    @Test
    public void leavePasswordTwoFieldEmpty() {
        driver.get(BASE_URL + "cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("firstnameInputLocator")).sendKeys("Dasha");
        driver.findElement(By.name("lastnameInputLocator")).sendKeys("Sam");
        driver.findElement(By.name("emailInputLocator")).sendKeys("dasam@mail.com");
        driver.findElement(By.name("passwordInputLocatorOne")).sendKeys("12345");
        driver.findElement(By.name("passwordInputLocatorTwo")).sendKeys("");
        driver.findElement(By.cssSelector("registerButtonLocator")).click();
        String text1 = driver.findElement(By.cssSelector("errorMessageLocator")).getText();

        Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Пользователь не зарегистрировался");
    }

    @Test
    public void inputSpaceInFirstNameField() {
        driver.get(BASE_URL + "cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("firstnameInputLocator")).sendKeys(" ");
        driver.findElement(By.name("lastnameInputLocator")).sendKeys("Sam");
        driver.findElement(By.name("emailInputLocator")).sendKeys("dasam@mail.com");
        driver.findElement(By.name("passwordInputLocatorOne")).sendKeys("12345");
        driver.findElement(By.name("passwordInputLocatorTwo")).sendKeys("12345");
        driver.findElement(By.cssSelector("registerButtonLocator")).click();
        String text1 = driver.findElement(By.cssSelector("errorMessageLocator")).getText();

        Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Пользователь не зарегистрировался");
    }

    @Test
    public void inputRusiianLettersInFirstNameField() {
        driver.get(BASE_URL + "cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("firstnameInputLocator")).sendKeys("Даша");
        driver.findElement(By.name("lastnameInputLocator")).sendKeys("Sam");
        driver.findElement(By.name("emailInputLocator")).sendKeys("dasam@mail.com");
        driver.findElement(By.name("passwordInputLocatorOne")).sendKeys("12345");
        driver.findElement(By.name("passwordInputLocatorTwo")).sendKeys("12345");
        driver.findElement(By.cssSelector("registerButtonLocator")).click();
        String text1 = driver.findElement(By.cssSelector("errorMessageLocator")).getText();

        Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Пользователь не зарегистрировался");
    }

    @Test
    public void inputRusiianLettersInLastNameField() {
        driver.get(BASE_URL + "cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("firstnameInputLocator")).sendKeys("Даша");
        driver.findElement(By.name("lastnameInputLocator")).sendKeys("Sam");
        driver.findElement(By.name("emailInputLocator")).sendKeys("dasam@mail.com");
        driver.findElement(By.name("passwordInputLocatorOne")).sendKeys("12345");
        driver.findElement(By.name("passwordInputLocatorTwo")).sendKeys("12345");
        driver.findElement(By.cssSelector("registerButtonLocator")).click();
        String text1 = driver.findElement(By.cssSelector("errorMessageLocator")).getText();

        Assert.assertEquals(text1, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Пользователь не зарегистрировался");
    }
}

