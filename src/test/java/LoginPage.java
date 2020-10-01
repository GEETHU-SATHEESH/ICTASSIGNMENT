import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends Driver {
    @FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
    private  WebElement Popupclose;
    @FindBy(xpath = "//img[@title='Flipkart']")
    private WebElement PageTitle;
    @FindBy (xpath="//div/a[text()='Login']")
    private WebElement Loginbtn;
    @FindBy(xpath="//label/span[text()='Enter Email/Mobile number']/../../input")
    private WebElement txtUserName;
    @FindBy(xpath="//label/span[text()='Enter Password']/../../input")
   private WebElement txtPassword;
   @FindBy(xpath="//button[@type='submit' and contains(., 'Login')]")
   private WebElement btnLogin;
   //@FindBy (xpath = "//*[@id=\"container\"]//div[1]/div[1]/div[2]/div[3]/div")
   //private WebElement DisplayedName;
   @FindBy(xpath = "//span[text()='Your username or password is incorrect']")
   private  WebElement Invalidloginid;
   @FindBy(xpath = "//div[text()='Delivery in']")
   private WebElement validpin;
   @FindBy(xpath = "//input[@type='text'  and @title='Search for products, brands and more']")
   private WebElement Search;
   @FindBy(xpath ="//button[@class='vh79eN']")
   private WebElement Searchbtn;
   @FindBy (xpath = "//div[@class='D0YrLF']")
   private WebElement filteroptn;
   @FindBy (xpath = "//label/input[@class='_3uUUD5']")
   private List<WebElement> filtercheckbox;
   @FindBy (xpath = "//div[@class='_3n6o0t']")
   private List<WebElement>Filtercheck;
   @FindBy(xpath = "//div[@class='_3i65ul']")
   private WebElement ItemName;
   @FindBy (xpath = "//div[@class='_3wU53n']")
   private List<WebElement>SelectItems;
    @FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
    private WebElement Addtocart;
    @FindBy(xpath="//div[@class='_2EoEbp']/div")
    private WebElement Cartvalue;
    @FindBy(xpath = "//div[text() ='Remove']")
    private WebElement Remove;
    @FindBy (xpath="//div[text() ='Cancel']/following-sibling::div")
    private WebElement RemoveItem;
    @FindBy(xpath = "//h2[text()='Deals of the Day']/../../following-sibling::div/div/div/div[1]/div/div[1]//a")
    private WebElement Product;
    @FindBy (xpath = "//a[@rel='noopener noreferrer'][2]")
    private List<WebElement>Productselect;
    @FindBy(xpath = "//input[@placeholder='Enter Delivery Pincode']")
    private WebElement Enterpin;
    @FindBy (xpath = "//span[text()='Check']")
    private WebElement check;
    @FindBy(xpath = "//div[text()='Not a valid pincode']")
    private  WebElement invalid;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void Login(String userName, String password) {
        txtUserName.sendKeys(userName);//locating element by using By reference and send
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        txtPassword.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        btnLogin.click();

    }
    public void InvalidLogin(String userName, String password) {
        txtUserName.sendKeys(userName);//locating element by using By reference and send
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        txtPassword.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        btnLogin.click();
        boolean isinvalid=Invalidloginid.isDisplayed();
        Assert.assertTrue(isinvalid,"Invalid Login");

    }
    public void SearchItem(String Item){
        Popupclose.click();
        Search.sendKeys(Item);
        Searchbtn.click();
        boolean isPhoneLogodisplayed=ItemName.isDisplayed();
        Assert.assertTrue(isPhoneLogodisplayed,"Logo is Displayed");

    }
    public void Navigatetocart(String Item){
        Popupclose.click();
        Search.sendKeys(Item);
        Searchbtn.click();
        SelectItems.get(1).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String winhandleBefore=driver.getWindowHandle();
        for(String winhandle : driver.getWindowHandles()){
            driver.switchTo().window(winhandle);}
        Actions actions = new Actions(driver);
        actions.moveToElement(Addtocart).click().perform();
        boolean iscartvalue=Cartvalue.isDisplayed();
       Assert.assertTrue(iscartvalue,"Logo is Displayed");

    }
    public  void Deletefromcart(String Item){
        Popupclose.click();
        Search.sendKeys(Item);
        Searchbtn.click();
        SelectItems.get(1).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String winhandleBefore=driver.getWindowHandle();
        for(String winhandle : driver.getWindowHandles()){
            driver.switchTo().window(winhandle);}
        Actions actions = new Actions(driver);
        actions.moveToElement(Addtocart).click().perform();
        boolean iscartvalue= Cartvalue.isDisplayed();
        Assert.assertTrue(iscartvalue,"Logo is Displayed");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Remove.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RemoveItem.click();
    }
    public  void Pincodeinvalid(int pincode){
        driver.manage().window().maximize();
        Popupclose.click();
        Product.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Productselect.get(0).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       String winhandleBefore=driver.getWindowHandle();
       for(String winhandle : driver.getWindowHandles()){
       driver.switchTo().window(winhandle);}
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        Enterpin.isDisplayed();
        actions.moveToElement(Enterpin).sendKeys(""+pincode).perform();
        //Enterpin.sendKeys(pincode);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        check.click();
        //invalid.isDisplayed();

    }
    public void wishlist(String item){
        Popupclose.click();
        Popupclose.click();
        Search.sendKeys(item);
        Searchbtn.click();
        SelectItems.get(1).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String winhandleBefore=driver.getWindowHandle();
        for(String winhandle : driver.getWindowHandles()){
            driver.switchTo().window(winhandle);}
        Actions actions = new Actions(driver);
        actions.moveToElement(Addtocart).click().perform();
        boolean iscartvalue= Cartvalue.isDisplayed();
        Assert.assertTrue(iscartvalue,"Logo is Displayed");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }
    public  void filter(String item){
        Popupclose.click();
        Search.sendKeys(item);
        Searchbtn.click();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        ((WebElement) filtercheckbox.get(0)).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Filtercheck.get(1).isDisplayed();

    }
    public void pincodevalid(int pincode){
        Popupclose.click();
        Product.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Productselect.get(0).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String winhandleBefore=driver.getWindowHandle();
        for(String winhandle : driver.getWindowHandles()){
            driver.switchTo().window(winhandle);}
        Enterpin.isDisplayed();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Enterpin.sendKeys(""+pincode);
       // Actions actions = new Actions(driver);
       // actions.moveToElement(Enterpin).sendKeys(""+pincode).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //validpin.isDisplayed();
    }

}