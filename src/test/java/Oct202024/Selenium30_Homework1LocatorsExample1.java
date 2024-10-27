package Oct202024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium30_Homework1LocatorsExample1 {

    @Description("Verify its possible to create account in awesomeQA site")
    @Test
    public void Homework1Ex(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to(" https://awesomeqa.com/ui/index.php?route=account/register");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.getTitle());
        WebElement pageText=driver.findElement(By.xpath("//div[@class='col-sm-9']/h1"));
        Assert.assertEquals(pageText.getText(),"Register Account");

         WebElement firstName = driver.findElement(By.name("firstname"));
         firstName.sendKeys("admin123");

         WebElement lastName = driver.findElement(By.id("input-lastname"));
         lastName.sendKeys("admin");

         WebElement Email = driver.findElement(By.xpath("//input[contains(@placeholder,'E-Mail')]"));
         Email.sendKeys("admin10@admin.com");

         WebElement Telephone = driver.findElement(By.id("input-telephone"));
         Telephone.sendKeys("1234567");

        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys("admin123");

        WebElement passwordConfirm = driver.findElement(By.name("confirm"));
        passwordConfirm.sendKeys("admin123");

        WebElement agreePolicy = driver.findElement(By.xpath("//input[contains(@type,'checkbox')]"));
        agreePolicy.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[contains(@value,'Continue')]"));
        continueButton.click();

        try
        {
            Thread.sleep(3000);
        }catch (InterruptedException e)
        {
            throw new  RuntimeException(e);
        }
        WebElement continueText = driver.findElement(By.xpath("//div[@id='content']/h1"));
        Assert.assertEquals(continueText.getText(),"Your Account Has Been Created!");

//*[@id="content"]/h1

         driver.quit();



    }
}
