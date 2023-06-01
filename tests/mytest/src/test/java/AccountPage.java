import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Keys;
import java.util.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;



class AccountPage extends PageBase {
    private By FirstNameBy = By.xpath("/html/body/div/div[2]/div/div/form/div[2]/input");
    private By EmailBy = By.xpath("/html/body/div/div[2]/div/div/form");
    private By EmailBy2 = By.xpath("//form[@class='form padding--3']");
    
    private By SubmitBy = By.xpath("//button[@id='submitAction']");
    private By iframeBy = By.xpath("/html/body/noscript[1]/text()");
    private By LogoBy = By.xpath("//*[contains(text(),'Facebook azon')]");
    
    public AccountPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://startlogin.hu/auth/realms/StartLogin/account?referrer=startlap-mobil&referrer_uri=https%3A%2F%2Fwww.startlap.hu%2Fauth%2Fprofile");

    }    
    public void fillFirstname(){
    System.out.println(this.driver.getCurrentUrl());
    this.waitAndReturnElement(LogoBy);
    this.waitAndReturnElement(EmailBy2).sendKeys("Bela");
    }
   

       
}










