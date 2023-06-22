package mytests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

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
            System.out.println("number is changed 1st");
        }
         else if (text.contains("+7 (499) 558-58-47")) {
            System.out.println("number is changed 2nd");
        }
        else if (text.contains("+7 (499) 406-17-63")) {
            System.out.println("number is changed 3rd");
        }
        else {
          System.out.println(text+"calltracking not working");
        }

        WebElement email= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/aside[1]"));
        String mail= email.getText();
        System.out.println(mail);

        if (mail.contains("test.email.v114+")){
            System.out.println("email is changed");
        }
        else {
            System.out.println(mail+"emailtracking not working");
        }

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://calltracking.ru/testqa/index.php?utm_source=google&utm_medium=organic");

        WebElement phone2= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[2]/a[1]"));
        String text2= phone2.getText();
        System.out.println(text2);


        if (text2.contains("+7 (499) 558-35-93")) {
            System.out.println("number 2 is changed");
        }

        else {
            System.out.println(text2+"calltracking not working");
        }

        WebElement email2= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/aside[1]"));
        String mail2= email2.getText();
        System.out.println(mail2);

        if (mail2.contains("test.email.v114+")){
            System.out.println("email2 is changed");
        }
        else {
            System.out.println(mail2+"emailtracking not working");
        }

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(2));
        driver.get("https://calltracking.ru/testqa/index.php?utm_source=google&utm_medium=anything");

        WebElement phone3= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[2]/a[1]"));
        String text3= phone3.getText();
        System.out.println(text3);


        if (text3.contains("+7 (495) 357-05-96")) {
            System.out.println("number 3 is same");
        }

        else {
            System.out.println(text3+"calltracking is hucked");
        }

        WebElement email3= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/aside[1]"));
        String mail3= email3.getText();
        System.out.println(mail3);

        if (mail3.contains("test.email.v114+")){
            System.out.println("email3 is changed");
        }
        else {
            System.out.println(mail3+"emailtracking not working");
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