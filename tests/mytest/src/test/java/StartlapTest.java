import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import java.net.URL;
import java.net.MalformedURLException;


public class StartlapTest {
    public WebDriver driver;
    private ConfigFileReader configFileReader= new ConfigFileReader();
    public List<String> URLs = configFileReader.getLoadUrls();
    
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable popup blocking");
        driver = new RemoteWebDriver(new URL(configFileReader.getDriverPath()), options);
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
    public void DropdownTest(){
        MainPage mainPage = new MainPage(this.driver);
        mainPage.acceptCookies();
        mainPage.SelectCity();
        
    }
    @Test
    public void LoadTest() {
         for (int i = 0; i < URLs.size(); i++) {
            this.driver.get(URLs.get(i));
        }    

    }
    @Test
    public void HoverTest(){
        MainPage mainPage = new MainPage(this.driver);
        mainPage.acceptCookies();
        mainPage.HoverandCheck();
    }


    @Test
    public void testWeather() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.acceptCookies();
        WeatherPage weatherPage = mainPage.clickWeather();
        weatherPage.acceptCookies();
        weatherPage.fillWaterRadioButton();
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
        Assert.assertTrue(mainPage.isLoggedout());

    }
    */
    @Test
    public void SendForm(){
        MainPage mainPage = new MainPage(this.driver);
        
        mainPage.acceptCookies();
        
        LoginPage loginPage = mainPage.clickLogin();
        
        loginPage.clickEmailandFill();
        
        mainPage.acceptCookies();
        
        ProfilePage profilepage = mainPage.clickProfile();
        
        profilepage.sendNewsLetterForm();
        
        AccountPage accountpage = profilepage.clickAccount();
        accountpage.fillFirstname();
        
    }


 
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
