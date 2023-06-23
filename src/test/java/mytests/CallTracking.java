package mytests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CallTracking {


    @Test
    public static void main(String[] args) throws InterruptedException {
       // System.setProperty("webdriver.chrome.driver", ".//driver/chromedriver");

        //  WebDriver driver=new ChromeDriver();

/*
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
*/



         System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        WebDriver driver;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);

        driver.get("https://calltracking.ru/testqa/index.php?utm_source=google&utm_medium=cpc");
        Thread.sleep(3000);
        WebElement phone= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[2]/a[1]"));
        String text= phone.getText();
        System.out.println(text);


        if (text.contains("+7 (495) 367-29-93")) {
            Reporter.log("number is changed 1st");
        }
         else if (text.contains("+7 (499) 558-58-47")) {
            Reporter.log("number is changed 2nd");
        }
        else if (text.contains("+7 (499) 406-17-63")) {
            Reporter.log("number is changed 3rd");
        }
        else {
            Reporter.log(text+"calltracking not working");
        }

        WebElement email= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/aside[1]"));
        String mail= email.getText();
        Reporter.log(mail);

        if (mail.contains("test.email.v114+")){
            Reporter.log("email is changed");
        }
        else {
            Reporter.log(mail+"emailtracking not working");
        }

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://calltracking.ru/testqa/index.php?utm_source=google&utm_medium=organic");

        WebElement phone2= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[2]/a[1]"));
        String text2= phone2.getText();
        Reporter.log(text2);


        if (text2.contains("+7 (499) 558-35-93")) {
            Reporter.log("number 2 is changed");
        }

        else {
            Reporter.log(text2+"calltracking not working");
        }

        WebElement email2= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/aside[1]"));
        String mail2= email2.getText();
        Reporter.log(mail2);

        if (mail2.contains("test.email.v114+")){
            Reporter.log("email2 is changed");
        }
        else {
            Reporter.log(mail2+"emailtracking not working");
        }

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(2));
        driver.get("https://calltracking.ru/testqa/index.php?utm_source=google&utm_medium=anything");

        WebElement phone3= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[2]/a[1]"));
        String text3= phone3.getText();
        Reporter.log(text3);


        if (text3.contains("+7 (495) 357-05-96")) {
            Reporter.log("number 3 is same");
        }

        else {
            Reporter.log(text3+"calltracking is hucked");
        }

        WebElement email3= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/aside[1]"));
        String mail3= email3.getText();
        Reporter.log(mail3);

        if (mail3.contains("test.email.v114+")){
            Reporter.log("email3 is changed");
        }
        else {
            Reporter.log(mail3+"emailtracking not working");
        }

        /*((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://calltracking.ru/testqa/index.php?utm_source=google&utm_medium=organic");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(2));
        driver.get("https://calltracking.ru/testqa/index.php?utm_source=google&utm_medium=cpc"); */


    }


}