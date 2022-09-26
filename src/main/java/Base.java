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

    public static void proceedBtn() throws InterruptedException {
        Thread.sleep(5000);
        WebElement body = driver.findElement(By.tagName("body"));
        WebElement row = body.findElement(By.className("button-container")).findElement(By.tagName("span"));
        WebElement btn = row.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span"));
        btn.click();
    }

    public static void goToCart(){
        WebElement cartLink = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(cartLink);
        cartLink.click();
    }

    public static void removeFirstItemFromCart(){
        WebElement firstElement = driver.findElement(By.id("product_1_1_0_0"));
        WebElement removeBtn = firstElement.findElement(By.xpath("//*[@id=\"product_1_1_0_0\"]/td[7]/div/a"));
        removeBtn.click();
    }

    public static void incrementQuantity(){
        WebElement cartElement = driver.findElement(By.id("product_2_7_0_0"));
        WebElement addBtn = cartElement.findElement(By.xpath("//*[@id=\"cart_quantity_up_2_7_0_0\"]"));
        addBtn.click();
    }









}
