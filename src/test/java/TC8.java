import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetAddress;

public class TC8 {
    public ExtentReports reports;
    ExtentSparkReporter extentSparkReporter;
    public ExtentTest extentTest;
    @Test(dataProvider = "searchdataprovider",dataProviderClass = CustomData.class)
    public void Navigatetocart(String browser,String url,String Item)throws IOException {
        String path=System.getProperty("user.dir");
        reports=new ExtentReports();
        extentSparkReporter=new ExtentSparkReporter(path+"\\report\\report.html");
        reports.setSystemInfo("Machine Name", InetAddress.getLocalHost().getHostName());
        reports.attachReporter(extentSparkReporter);
        WebDriver driver=Driver.openBrowser(browser, url);
        LoginPage navigatetopage=new LoginPage(driver);
        navigatetopage.Navigatetocart(Item);
        extentTest.log(Status.PASS,"Navigated to cart");
        extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
        Driver.closeBrowser();


    }
}
