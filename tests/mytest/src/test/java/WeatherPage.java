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


class WeatherPage extends PageBase {
    private By WaterButtonBy = By.xpath("//*[@id='w-tab-1']/div/div[4]/label");
    private By WaterIconBy = By.xpath("//*[@id='w-tab-1']/div/div[1]/div[13]");
    private By MainIconBy = By.className("navbar-brand");
    private By CookiesBy = By.xpath("//*[@id='qc-cmp2-ui']/div[2]/div/button[2]");
    private By InfoBy = By.xpath("//div[@class='qc-cmp2-summary-info ']");
    

    public WeatherPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://kiderul.startlap.hu/");

    }    


    public void acceptCookies(){
        
        this.waitAndReturnElement(InfoBy);
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView();", waitAndReturnElement(CookiesBy));
        this.ReturnElementifClickable(CookiesBy).click();
    }
    public void fillWaterRadioButton(){
        this.ReturnElement(MainIconBy);
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView();", waitAndReturnElement(WaterButtonBy));
        this.ReturnElement(WaterButtonBy).click();
        this.ReturnElement(WaterIconBy);
    }

       
}