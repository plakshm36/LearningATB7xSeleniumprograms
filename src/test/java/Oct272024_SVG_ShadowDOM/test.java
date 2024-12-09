package Oct272024_SVG_ShadowDOM;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test {

        @Description("Test to verify login")
        @Test
        public void logintest(){

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximised");

        WebDriver driver = new EdgeDriver(options);

        driver.navigate().to("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        WebElement emailaddress = driver.findElement(By.id("login-username"));
        emailaddress.sendKeys("padmapri10@gmail.com");
        WebElement password =  driver.findElement(By.id("login-password"));
        password.sendKeys("Admin@123");
        WebElement signin = driver.findElement(By.id("js-login-btn"));
        signin.click();
        try
        {
            Thread.sleep(3000);
        }catch(InterruptedException E)
        {
             throw new RuntimeException(E);
        }
                Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/dashboard");
               driver.close();
    }


    }

