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
import org.openqa.selenium.support.ui.Duration;



class ProfilePage extends PageBase {
    private By DetailsBy = By.xpath("//*[@id='sso-container']/ul/li[2]/a");
    private By NewsletterBy = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div/div/div/form/div/div[1]/div/div/label/span[1]");
    private By SendBy = By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div/div/div/div/form/div/div[2]/div/input[2]");
    private By ProfileBy = By.xpath("//h2[text()='Profiladatok']");

    
    
    public ProfilePage(WebDriver driver) {
        super(driver);
        //this.driver.get("https://www.startlap.hu/auth/profile");

    }    

    public AccountPage clickAccount(){
        this.waitAndReturnElement(DetailsBy).click();
        return new AccountPage(this.driver);
    }
   public void sendNewsLetterForm(){
        this.waitAndReturnElement(ProfileBy);
        this.waitAndReturnElement(NewsletterBy).click();
        //this.waitAndReturnElement(SendBy).click(); // don't want the newsletter actually :)
   }

       
}