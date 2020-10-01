
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javax.swing.*;

import java.io.IOException;
import java.net.InetAddress;
public class  TC1 extends Reports  {


    @Test(dataProvider = "Logindataprovider",dataProviderClass = CustomData.class)
    public void Loginvalid(String browser,String url,String usn,String pswd) throws IOException {
        reports.attachReporter(extentSparkReporter);
        extentTest=reports.createTest("TC1");
        WebDriver driver=Driver.openBrowser(browser,url);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.Login(usn,pswd);
        extentTest.log(Status.PASS,"Login Passed");
        extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
        Driver.closeBrowser();


    }
}


    