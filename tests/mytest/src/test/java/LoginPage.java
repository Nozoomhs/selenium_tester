import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;



class LoginPage extends PageBase {
    private By EmailButtonBy = By.xpath("//div[@class='login__btn']");
    private By EmailfieldBy = By.xpath("//input[@id='username']");
    private By PassfieldBy = By.xpath("//input[@id='password']");
    private By LoginbuttonBy = By.xpath("//button[@id='kc-login']");
    private ConfigFileReader configFileReader= new ConfigFileReader();
    public LoginPage(WebDriver driver) {
        super(driver);
        //this.driver.get("https://startlogin.hu/auth/realms/StartLogin/protocol/openid-connect/auth?response_type=code&client_id=startlap-mobil&state=8fiwywpJIxUf5zVj-ZGe-omQp3tNLz6M&redirect_uri=https%3A%2F%2Fwww.startlap.hu%2Fauth%2Flogin-callback");
    }    
    public void clickEmailandFill(){
        this.waitAndReturnElement(EmailButtonBy).click();
        this.waitAndReturnElement(EmailfieldBy).sendKeys(configFileReader.getEmail());
        this.waitAndReturnElement(PassfieldBy).sendKeys(configFileReader.getPass());
        this.waitAndReturnElement(LoginbuttonBy).click();

    }

       
}