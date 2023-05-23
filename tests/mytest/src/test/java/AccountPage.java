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



class AccountPage extends PageBase {
    private By FirstNameBy = By.xpath("//input[@id='firstName']");
    private By SubmitBy = By.xpath("//button[@id='submitAction']");
    private By sg = By.xpath("/html/body/div/div[1]/nav/ul[1]/li[2]");
    
    public AccountPage(WebDriver driver) {
        super(driver);
        //this.driver.get("https://startlogin.hu/auth/realms/StartLogin/account?referrer=startlap-mobil&referrer_uri=https%3A%2F%2Fwww.startlap.hu%2Fauth%2Fprofile");

    }    
    public void fillFirstname(){
        System.out.println(this.driver.getCurrentUrl());
        this.waitAndReturnElement(FirstNameBy).sendKeys("Bela");
    }
   

       
}












