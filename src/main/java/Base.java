import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    private static WebDriver driver;
    private static WebDriverWait driverWait;


    public Base(String url){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1400,960));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void previewElement(String path){
        WebElement element = driver.findElement(By.xpath(path));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
    }

    public static void addToCart() throws InterruptedException {
        Thread.sleep(5000);
        WebElement body = driver.findElement(By.tagName("body"));
        WebElement modal = body.findElement(By.className("fancybox-inner")).findElement(By.tagName("iframe"));
        driver.switchTo().frame(modal);
        WebElement btnWrapper = driver.findElement(By.id("add_to_cart"));
        btnWrapper.findElement(By.tagName("button")).click();
        driver.switchTo().parentFrame();
        //driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add_to_cart\"]/button"))).click();
    }







}
