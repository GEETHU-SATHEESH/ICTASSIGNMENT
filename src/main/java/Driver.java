
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Driver {
    public static WebDriver driver;
    @BeforeClass
    public static WebDriver openBrowser(String browser,String url){
        switch (browser.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");
                driver=new ChromeDriver();//launch browser
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "src//main//resources//IEDriverServer.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                InternetExplorerOptions ieoptions = new InternetExplorerOptions(capabilities);
                driver = new InternetExplorerDriver(ieoptions);
                break;
        }
     // driver.manage().window().maximize();//maximize window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.navigate().to(url);//navigate to url
        System.out.println("the title is"+driver.getTitle());
       /* WebDriverWait driverWait=new WebDriverWait(driver,30);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[text()='Login']")));
        WebElement element = driver.findElement(By.xpath("//div/a[text()='Login']"));
        Actions actions = new Actions(driver);
       actions.moveToElement(element).click().perform();**/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.linkText("Login")).click();
        return driver;
    }
    public static void  closeBrowser(){
        driver.close();
    }
    public static String takeScreenshot() throws IOException {

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Random random = new Random();
            String file = "ss" + random.nextInt(1000) + ".png";
            String fileName = System.getProperty("user.dir") + "\\report\\" + file;
            File destinationFile = new File(fileName);
            FileUtils.copyFile(screenshot, destinationFile);
            return file;
        }

}

