import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TC5 {
    @Test(dataProvider = "Pincodetestdataprovider1", dataProviderClass = CustomData.class)
    public void Pincodevalidations(String browser, String url, int pin) {
        WebDriver driver = Driver.openBrowser(browser, url);
        LoginPage pincode = new LoginPage(driver);
        pincode.Pincodeinvalid(pin);
        System.out.println("Invalid Login");
        // driver.close();
    }
}


