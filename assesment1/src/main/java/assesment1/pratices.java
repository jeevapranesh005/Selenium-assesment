package assesment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pratices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait =new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		
		driver.get("https://demoblaze.com/");
		driver.findElement(By.xpath("//a[@id='login2']")).click();
		
		WebElement login = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='loginusername']")));
		login.sendKeys("jeevs");
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("1234567890");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		
		WebElement wel = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']")));
		System.out.println(wel.getText());
		
		
		String exp = "Welcome jeevs";
		
		if(wel.equals(exp)) {
			System.out.println("Login Successful");
		}else {
			System.out.println("Login not Successful");
		}
		
		
		
		
		WebElement laptop = driver.findElement(By.xpath("//a[3]"));
		act.moveToElement(laptop).click().perform();
		WebElement item = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='MacBook Pro']")));
		System.out.println(item.getText());
		
		List<WebElement> list = driver.findElements(By.xpath("//h4[@class='card-title']"));
		List<String> list1 = new ArrayList<>();
		
		for(WebElement li: list) {
			list1.add(li.getText());
		}
		for(String ele : list1) {
			System.out.println("Found Laptop : "+ele);
		}
		
		WebElement mac= mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='MacBook Pro']")));
		mac.click();
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Add to cart']"))).click();

		Alert alert = mywait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        System.out.println("Alert handled successfully.");
        
        
		WebElement cart = driver.findElement(By.xpath("//a[@id='cartur']"));
		act.moveToElement(cart).click().perform();
		
		
		System.out.println("Product added to cart");
		System.out.println("MacBook Pro added to cart.");

		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Place Order']"))).click();
		
		
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']"))).sendKeys("Jeeva");
		
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Salem");
		driver.findElement(By.xpath("//input[@id='card']")).sendKeys("12547654");
		driver.findElement(By.xpath("//input[@id='month']")).sendKeys("july");
		driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2026");
		
		driver.findElement(By.xpath("//button[normalize-space()='Purchase']")).click();
		
		WebElement purchase = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'sweet-alert')]")));

        String text = purchase.getText();

        if (text.contains("Thank you for your purchase!")) {
            System.out.println("Order is placed successfully");
         
        } else {
            System.out.println("Order is Unsuccessful");
        }
		
		
		
		
//		
	
		
		

	}

}
