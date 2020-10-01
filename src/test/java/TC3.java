import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetAddress;

public class TC3 extends Reports {

    @Test(dataProvider = "BasicSearch",dataProviderClass = CustomData.class)
    public void Search(String browser,String url,String Item) throws IOException {
        reports.attachReporter(extentSparkReporter);
        extentTest = reports.createTest("TC3");
        WebDriver driver = Driver.openBrowser(browser, url);
        LoginPage searchpage = new LoginPage(driver);
        searchpage.SearchItem(Item);
        System.out.println("Name Displayed");
        extentTest.log(Status.PASS,"Search");
        extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
        Driver.closeBrowser();

    }
}

