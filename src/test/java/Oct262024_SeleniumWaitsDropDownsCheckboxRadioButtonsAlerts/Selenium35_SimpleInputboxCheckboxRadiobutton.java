package Oct262024_SeleniumWaitsDropDownsCheckboxRadioButtonsAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium35_SimpleInputboxCheckboxRadiobutton {

        public static void main(String[] args) {


            EdgeDriver driver = new EdgeDriver();
            driver.get("https://awesomeqa.com/practice.html");

            driver.findElement(By.name("firstname")).sendKeys("the testing academy");

            // RADIO Box
            driver.findElement(By.id("sex-1")).click();

            // CheckBox
            driver.findElement(By.id("tool-1")).click();








        }
    }


