package HeroApp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDataTablesTest extends BaseTest {

  @Test
  public void checkSortTable(){
    driver.get("https://the-internet.herokuapp.com/tables");
    List<WebElement>webElementList = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr/td[1]"));

    List<String>unsortedLastName = new ArrayList<>();
    unsortedLastName.add(webElementList.get(0).getText());
    unsortedLastName.add(webElementList.get(1).getText());
    unsortedLastName.add(webElementList.get(2).getText());
    unsortedLastName.add(webElementList.get(3).getText());
    Collections.sort(unsortedLastName);

    driver.findElement(By.xpath("//table[@id = 'table1']/thead/tr/th[1]/span")).click();

    List<WebElement>webElementListSorted = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr/td[1]"));

    List<String> sortedLastName = new ArrayList<>();
    sortedLastName.add(webElementListSorted.get(0).getText());
    sortedLastName.add(webElementListSorted.get(1).getText());
    sortedLastName.add(webElementListSorted.get(2).getText());
    sortedLastName.add(webElementListSorted.get(3).getText());

    Assert.assertEquals(sortedLastName,unsortedLastName,"Массивы не равны или не отсортированны");
  }



}