import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Duration;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private ConfigFileReader configFileReader= new ConfigFileReader();
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, configFileReader.getWait());
    }
    
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 
    protected WebElement ReturnElementifClickable(By locator) {
        this.wait.until(ExpectedConditions.elementToBeClickable(locator));
        return this.driver.findElement(locator);
    } 
    protected WebElement ReturnElement(By locator) {
        return this.driver.findElement(locator);
    } 
    
    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }

   
}
