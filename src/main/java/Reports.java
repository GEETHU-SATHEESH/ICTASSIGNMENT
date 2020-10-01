
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Reports extends Driver{

    public ExtentReports reports;
    ExtentSparkReporter extentSparkReporter;
    public ExtentTest extentTest;
    @BeforeTest public void Reportgeneration  () throws UnknownHostException {
        String path=System.getProperty("user.dir");
        reports=new ExtentReports();
        extentSparkReporter=new ExtentSparkReporter(path+"\\report\\report.html");
        reports.setSystemInfo("Machine Name", InetAddress.getLocalHost().getHostName());


    }
    @AfterTest
    public void Reportend(){
        System.out.println("Close Report");
    }

}