package mytests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class CallTracking  extends BaseClass{



    public CallTracking(){
      super();

    }

    @AfterClass public static void closeBrowser(){
     driver.quit();

      driver=null;
    }


    @Test(dataProvider ="testdata")

    public static void openBrowser(String name,String email,String phone,String text){
       navigateToURL("https://calltracking.ru/testqa/index.php?utm_source=google&utm_medium=anything");
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,400)");

        driver.findElement(By.xpath("//body/div[1]/form[1]/input[1]")).click();
        driver.findElement(By.xpath("//body/div[1]/form[1]/input[1]")).sendKeys(name);

        driver.findElement(By.xpath("//body/div[1]/form[1]/input[2]")).click();
        driver.findElement(By.xpath("//body/div[1]/form[1]/input[2]")).sendKeys(email);

        driver.findElement(By.xpath("//body/div[1]/form[1]/input[3]")).click();
        driver.findElement(By.xpath("//body/div[1]/form[1]/input[3]")).sendKeys(phone);

        driver.findElement(By.xpath("//body/div[1]/form[1]/textarea[1]")).click();
        driver.findElement(By.xpath("//body/div[1]/form[1]/textarea[1]")).sendKeys(text);




        driver.findElement (By.xpath ("//body/div[1]/form[1]/input[4]")).click();



    }

    @DataProvider(name="testdata")
    public Object[][] TestDataFeed(){

// Create object array with 2 rows and 2 column- first parameter is row and second is //column
        Object [][] calltrackingdata=new Object[10][4];

// Enter data to row 0 column 0
        calltrackingdata[0][0]="Тест";
// Enter data to row 0 column 1
        calltrackingdata[0][1]="test@i.ru";
// Enter data to row 1 column 0
        calltrackingdata[0][2]="+389623920000";

        calltrackingdata[0][3]="Нет";


        calltrackingdata[1][0]="Тест";
// Enter data to row 1 column 0
        calltrackingdata[1][1]="test@i.ru";
// return arrayobject to testscript
        calltrackingdata[1][2]="+389623923921";

        calltrackingdata[1][3]="Да";


        calltrackingdata[2][0]="Тест";
// Enter data to row 1 column 0
        calltrackingdata[2][1]="test@i.ru";
// return arrayobject to testscript
        calltrackingdata[2][2]="+389623920002";

        calltrackingdata[2][3]="Да";


        calltrackingdata[3][0]="Тест";
// Enter data to row 1 column 0
        calltrackingdata[3][1]="test@i.ru";
// return arrayobject to testscript
        calltrackingdata[3][2]="+389623920003";

        calltrackingdata[3][3]="Да";


        calltrackingdata[4][0]="Тест";
// Enter data to row 1 column 0
        calltrackingdata[4][1]="test@i.ru";
// return arrayobject to testscript
        calltrackingdata[4][2]="+389623920004";

        calltrackingdata[4][3]="Да";


        calltrackingdata[5][0]="Тест";
// Enter data to row 1 column 0
        calltrackingdata[5][1]="test@i.ru";
// return arrayobject to testscript
        calltrackingdata[5][2]="+389623920005";

        calltrackingdata[5][3]="Да";


        calltrackingdata[6][0]="Тест";
// Enter data to row 1 column 0
        calltrackingdata[6][1]="test@i.ru";
// return arrayobject to testscript
        calltrackingdata[6][2]="+389623920006";

        calltrackingdata[6][3]="Да";

        calltrackingdata[7][0]="Тест";
// Enter data to row 1 column 0
        calltrackingdata[7][1]="test@i.ru";
// return arrayobject to testscript
        calltrackingdata[7][2]="+389623920007";

        calltrackingdata[7][3]="Да";


        calltrackingdata[8][0]="Тест";
// Enter data to row 1 column 0
        calltrackingdata[8][1]="test@i.ru";
// return arrayobject to testscript
        calltrackingdata[8][2]="+389623920008";

        calltrackingdata[8][3]="Да";


        calltrackingdata[9][0]="Тест";
// Enter data to row 1 column 0
        calltrackingdata[9][1]="test@i.ru";
// return arrayobject to testscript
        calltrackingdata[9][2]="+389623920009";

        calltrackingdata[9][3]="Да";












        return calltrackingdata;
    }
}


