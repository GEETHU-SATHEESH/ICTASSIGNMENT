import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class TC4 extends Reports  {

    @Test(dataProvider = "searchdataprovider",dataProviderClass = CustomData.class)
    public void Deleteincart(String browser,String url,String Item) throws IOException
    {          reports.attachReporter(extentSparkReporter);
            extentTest=reports.createTest("TC4");
            WebDriver driver=Driver.openBrowser(browser, url);
            LoginPage navigatetopage=new LoginPage(driver);
            navigatetopage.Deletefromcart(Item);
            extentTest.log(Status.PASS,"Deletefromcart");
            extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
            Driver.closeBrowser();


    }


}
