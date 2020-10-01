import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC6 extends Reports{

    @Test(dataProvider = "searchdataprovider",dataProviderClass = CustomData.class)
    public void Filter(String browser,String url,String Item) throws IOException {
        extentTest=reports.createTest("TC6");
        WebDriver driver=Driver.openBrowser(browser,url);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.filter(Item);
     extentTest.log(Status.PASS,"Filtered");
        extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
        Driver.closeBrowser();


    }}
