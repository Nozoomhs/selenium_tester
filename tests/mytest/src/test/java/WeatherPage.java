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



class WeatherPage extends PageBase {
    private By WaterButtonBy = By.xpath("//*[@id='w-tab-1']/div/div[4]/label");
    private By WaterIconBy = By.xpath("//*[@id='w-tab-1']/div/div[1]/div[13]");
    private By MainIconBy = By.className("navbar-brand");
    private By CookiesBy = By.xpath("//button[@class=' css-1tfx6ee']");




    public WeatherPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://kiderul.startlap.hu/");

    }    


    public void acceptCookies(){
        this.ReturnElementifClickable(CookiesBy).click();
    }
    public void fillWaterRadioButton(){
        this.ReturnElement(MainIconBy);
        /*
        Actions a = new Actions(this.driver);
        a.moveToElement(this.ReturnElement(WaterButtonBy));
        a.perform();
        */
        this.ReturnElement(WaterButtonBy).click();
        this.ReturnElement(WaterIconBy);
    }

       
}