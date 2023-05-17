package mytests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CallTracking  extends BaseClass{



    public CallTracking(){
      super();

    }

    @AfterClass public static void closeBrowser(){
     driver.quit();

      driver=null;
    }


    @Test(dataProvider ="testdata")

    public static void openBrowser(String name,String mail,String phone){
       navigateToURL("https://www.calltracking.ru");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/nav[1]/div[2]/div[1]/button[1]")).click();
        driver.findElement(By.className("demo_access_form")).findElement(By.id("first_step_name")).click();
        driver.findElement(By.className("demo_access_form")).findElement(By.id("first_step_name")).sendKeys(name);

        driver.findElement(By.className("demo_access_form")).findElement(By.className("email_validation")).click();
        driver.findElement(By.className("demo_access_form")).findElement(By.className("email_validation")).sendKeys(mail);

        driver.findElement(By.className("demo_access_form")).findElement(By.className("phone_validation")).click();
        driver.findElement(By.className("demo_access_form")).findElement(By.className("phone_validation")).sendKeys(phone);

        driver.findElement(By.className("demo_access_form")).findElement(By.className("btn-white")).click();

    }

    @DataProvider(name="testdata")
    public Object[][] TestDataFeed(){

// Create object array with 2 rows and 2 column- first parameter is row and second is //column
        Object [][] calltrackingdata=new Object[2][3];

// Enter data to row 0 column 0
        calltrackingdata[0][0]="Тест";
// Enter data to row 0 column 1
        calltrackingdata[0][1]="test@i.ru";
// Enter data to row 1 column 0
        calltrackingdata[0][2]="9623923920";


        calltrackingdata[1][0]="Тест";
// Enter data to row 1 column 0
        calltrackingdata[1][1]="test@i.ru";
// return arrayobject to testscript
        calltrackingdata[1][2]="9623923921";
        return calltrackingdata;
    }
}


