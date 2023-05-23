import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  

import java.net.URL;
import java.net.MalformedURLException;


public class StartlapTest {
    public WebDriver driver;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }
    /*
    @Test
    public void Titletest() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.acceptCookies();
        String title = this.driver.getTitle();
        Assert.assertTrue(title.contains("Startlap"));

    }
    
    
    @Test
    public void testClick() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.acceptCookies();
        mainPage.clickMenu();
        mainPage.clickAllow();
        String bodyText = mainPage.getBodyText();
        Assert.assertFalse(bodyText.contains("Kedves Nyilas"));
        mainPage.clickMenu2();
        mainPage.waitforWindow();
        String bodyText2 = mainPage.getBodyText();
        //wait for slow loading
        Assert.assertTrue(bodyText2.contains("Kedves Nyilas"));

    }
    
    @Test
    public void testLogin() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.acceptCookies();
        LoginPage loginPage = mainPage.clickLogin();
        loginPage.clickEmailandFill();
        // See if login was successful
        mainPage.acceptCookies();
        String bodyText = mainPage.getBodyText();
        Assert.assertTrue(bodyText.contains("mkwhimpi@gmail.com"));
        mainPage.logOut();

    }
    
    @Test
    public void testWeather() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.acceptCookies();
        WeatherPage weatherPage = mainPage.clickWeather();
        weatherPage.acceptCookies();
        weatherPage.fillWaterRadioButton();
    }
    
    
    */
   
    @Test
    public void ChangeUsername(){
        MainPage mainPage = new MainPage(this.driver);
        
        mainPage.acceptCookies();
        
        LoginPage loginPage = mainPage.clickLogin();
        
        loginPage.clickEmailandFill();
        
        mainPage.acceptCookies();
        
        ProfilePage profilepage = mainPage.clickProfile();
        
        profilepage.sendNewsLetterForm();
        /*
        AccountPage accountpage = profilepage.clickAccount();
        
        accountpage.fillFirstname();
        */
        
        
    }
    
    /*
    @Test
    public void HoverTest(){
    }
    */
    

    

    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
