package HeroApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;


public class CheckBoxesTest extends BaseTest {

        @Test
        public void checkCheckboxes(){
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type = 'checkbox'"));
            assertFalse(checkBoxes.get(0).isSelected());

            checkBoxes.get(0).click();
            assertTrue(checkBoxes.get(0).isSelected());

        }


}
