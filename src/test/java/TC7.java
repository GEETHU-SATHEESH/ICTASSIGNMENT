import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetAddress;

public class TC7 {
    public ExtentReports reports;
    ExtentSparkReporter extentSparkReporter;
    public ExtentTest extentTest;
    @Test(dataProvider = "Pincodetestdataprovider2", dataProviderClass = CustomData.class)
    public void Pincodevalidations(String browser, String url, int pin)throws IOException {
        String path=System.getProperty("user.dir");
        reports=new ExtentReports();
        extentSparkReporter=new ExtentSparkReporter(path+"\\report\\report.html");
        reports.setSystemInfo("Machine Name", InetAddress.getLocalHost().getHostName());
        reports.attachReporter(extentSparkReporter);
        extentTest=reports.createTest("TC7");
        WebDriver driver = Driver.openBrowser(browser, url);
        LoginPage pincode = new LoginPage(driver);
        pincode.pincodevalid(pin);
        System.out.println("valid pin");
        extentTest.log(Status.PASS,"Valid Pin");
        extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
        Driver.closeBrowser();


    }
}
