import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetAddress;

public class TC2 extends Reports {

    @Test(dataProvider = "InvalidLoginData",dataProviderClass = CustomData.class)
    public void Loginvalid(String browser,String url,String usn,String pswd)throws IOException {
        reports.attachReporter(extentSparkReporter);
        extentTest=reports.createTest("TC2");
        WebDriver driver=Driver.openBrowser(browser,url);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.InvalidLogin(usn,pswd);
        extentTest.log(Status.PASS,"Login Failed");
        extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
        Driver.closeBrowser();

    }}
