import org.testng.annotations.DataProvider;

public class CustomData {
    @DataProvider(name = "Logindataprovider")
    public Object[][] getdata1() {
        Object[][] data = {{"ie","https://www.flipkart.com/account/login?ret=/","gopu121@gmail.com", "31051985"}};
        return data;
    }
    @DataProvider(name="InvalidLoginData")
    public Object[][] getdata2() {
        Object[][] data = {{"ie","https://www.flipkart.com/account/login?ret=/","xyz@gmail.com", "xyz"}};
        return data;
}
    @DataProvider(name = "searchdataprovider")
    public Object[][] getdata4() {
        Object[][] data = {{"ie","https://www.flipkart.com/","Dell laptop"}};
        return data;}

     @DataProvider(name = "Pincodetestdataprovider1")
    public Object[][] getdata5() {
        Object[][] data = {{"ie","https://www.flipkart.com/",123456}};
        return data;
    }
    @DataProvider(name="Pincodetestdataprovider2")
    public Object[][] getdata6() {
        Object[][] data = {{"ie","https://www.flipkart.com/",683511}};
        return data;
    }
@DataProvider (name = "BasicSearch")
    public Object[][] getdata7() {
        Object[][] data = {{"ie","https://www.flipkart.com/","Watches"}};
        return data;
    }

}
