package HeroApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddRemoveElementsTest extends BaseTest{
    @Test
    public void addRemoveElementsTest (){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElemebtButton = driver.findElement(By.cssSelector("[onclick='addElement()']"));
        addElemebtButton.click();
        addElemebtButton.click();

        List<WebElement> deleteButtonList = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        assertEquals(deleteButtonList.size(), 2,"Элемент не 2");

        deleteButtonList.get(0).click();
        deleteButtonList = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        assertEquals(deleteButtonList.size(), 1,"Элемент не 2");

    }

}
