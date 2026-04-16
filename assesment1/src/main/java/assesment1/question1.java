package assesment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class question1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions act = new Actions(driver);

        driver.findElement(By.xpath("//a[@id='login2']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='loginusername']")));

        driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("jeevs");
        driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebElement wel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']")));
        if (wel.getText().contains("Welcome")) {
            System.out.println("Login Successful");
        }
        //Ai 
        WebElement laptops = driver.findElement(By.xpath("//a[text()='Laptops']"));
        act.moveToElement(laptops).click().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']")));

        List<WebElement> products = driver.findElements(By.xpath("//h4[@class='card-title']"));
        List<String> names = new ArrayList<>();

        for (WebElement e : products) {
            names.add(e.getText());
        }

        Collections.sort(names);

        List<String> List1 = new ArrayList<>(names);

        for (String name : List1) {
            System.out.println("Found Laptop: " + name);
        }
        //Ai
        WebElement mac = wait.until(
        	    ExpectedConditions.visibilityOfElementLocated(
        	        By.xpath("//a[text()='MacBook Pro']")
        	    )
        	);
        if (mac.getText().equals("MacBook Pro")) {
            System.out.println("Found Laptop: " + mac.getText());
        }

        mac.click();

        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']")));
        addToCart.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        System.out.println("Product added to cart");
        System.out.println("MacBook Pro added to cart.");

        driver.findElement(By.xpath("//a[@id='cartur']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='MacBook Pro']")));

        String productName = driver.findElement(By.xpath("//td[text()='MacBook Pro']")).getText();
        String productPrice = driver.findElement(By.xpath("//td[text()='MacBook Pro']/following-sibling::td")).getText();

        if (productName.equals("MacBook Pro")) {
            System.out.println("Product Name and Cost verified successfully");
        }

        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Jeev");
        driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Bangalore");
        driver.findElement(By.xpath("//input[@id='card']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@id='month']")).sendKeys("04");
        driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2026");

        driver.findElement(By.xpath("//button[text()='Purchase']")).click();

        WebElement purchase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'sweet-alert')]")));

        String text = purchase.getText();

        if (text.contains("Order Id")) {
            System.out.println("Purchase done Successfully");
            System.out.println(text);
        } else {
            System.out.println("Order is Unsuccessful");
        }

        driver.quit();
    }
}