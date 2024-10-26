package Oct192024;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium24_VWONegative {
    // Locators - Find the Web elements
    // Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
    //Find the Email id** and enter the email as admin@admin.com
    //Find the pass inputbox** and enter passwrod as admin.
    //Find and Click on the submit button
    //Verify that the error message is shown "Your email, password, IP address or location did not match"



    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void VWONegative(){
        // How to find the elements
        // Selenium
        // ID, NAME, CLASS NAME, TAGName,
        // Advance -> Css Selector, Xpath

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.navigate().to("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        // 1. Find the email inputbox and enter the email
        WebElement emailinputbox = driver.findElement(By.id("login-username"));
        emailinputbox.sendKeys("admin@admin.com");

        WebElement passwordinputbox = driver.findElement(By.name("password"));
        passwordinputbox.sendKeys("admin");


        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        // After 3 seconds error comes
        try
        {
            Thread.sleep(1000);

        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");


        driver.quit();

    }



}
