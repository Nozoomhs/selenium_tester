import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.Set;

class MainPage extends PageBase {

    private By footerBy = By.className("footer-block");
    private By searchBarTogglerBy = By.xpath("//input[@class='form-control search-input']");
    private By searchBarBy = By.name("search");
    private By MenuBy = By.xpath("//a[@rel='horoszkop']");
    private By CookiesBy = By.className("  css-1tfx6ee");
    private By CookiesBy2 = By.xpath("//button[@mode='primary']");
    private By MenuBy2 = By.xpath("//a[@class='nyilas']");
    private By LoginBy = By.xpath("//a[@href='/auth/login-redirect']");
    private By AllowBy = By.xpath("//button[@id='onesignal-slidedown-allow-button']");
    private By WindowBy = By.xpath("//div[@class='info nyilas clearfix active visible']//parent::div[@class='line horoscope']");
    private By LogoutBy = By.xpath("//*[@id='sso-container']/a[3]");
    private By WeatherBy = By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[3]/div[1]/a[9]/span");
    private By ProfileBy = By.xpath("//a[@href='/auth/profile']");
    private By AllBy = By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[3]/div[1]/a[13]/span");
    private By PodcastBy = By.xpath("//*[contains(text(),'Podcastok')]");
    private By CityBy = By.xpath("//select[@id='citySelector-2']");
    private By BudapestBy = By.xpath("//option[@value='Budapest']//parent::select[@id='citySelector-2']");
    private By DropdownBy = By.xpath("//*[@id='column-544']/div[1]/div[1]/div/div");
    private By SaveBy = By.xpath("//*[@id='column-544']/div[1]/div[4]/button");
    
    private ConfigFileReader configFileReader= new ConfigFileReader();
    
 
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get(configFileReader.getApplicationUrl());
    }    
    
    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }
    
      public void clickMenu() {
        this.waitAndReturnElement(MenuBy).click();

    }
    public void acceptCookies(){
        this.ReturnElementifClickable(CookiesBy).click();
    }
    public void clickMenu2(){
        this.waitAndReturnElement(MenuBy2).click();
        
    }
    public void waitforWindow(){
        this.waitAndReturnElement(WindowBy);
    }
    public LoginPage clickLogin(){
        this.waitAndReturnElement(LoginBy).click();
        return new LoginPage(this.driver);
    }
    
    public void clickAllow(){
        this.ReturnElementifClickable(AllowBy).click();
    }
     public void logOut(){
        this.ReturnElementifClickable(LogoutBy).click();
    }
    public WeatherPage clickWeather(){
        this.waitAndReturnElement(WeatherBy).click();
        return new WeatherPage(this.driver);
    }
    public ProfilePage clickProfile(){
        this.waitAndReturnElement(ProfileBy).click();
        return new ProfilePage(this.driver);
    }
    public Set<Cookie>  GetCookies(){
        Set<Cookie> cookies = this.driver.manage().getCookies();
        System.out.println(cookies);
        return cookies;
       
    }
     public boolean isLoggedout(){
        WebElement login = this.waitAndReturnElement(LoginBy);
        return login.isDisplayed();
    }
    public void HoverandCheck(){
        WebElement podcast = this.ReturnElement(PodcastBy);
        Assert.assertFalse(podcast.isDisplayed());
        Actions actions = new Actions(driver);
        actions.moveToElement(this.waitAndReturnElement(AllBy));
        actions.build().perform();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(podcast.isDisplayed());
        this.driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitWait(), TimeUnit.SECONDS);
        

    }
    public void SelectCity(){
        this.waitAndReturnElement(DropdownBy).click();
        this.waitAndReturnElement(CityBy).click();
        this.waitAndReturnElement(BudapestBy).click();
        this.waitAndReturnElement(SaveBy).click();

    }


    
}
