package demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoAlertPrsenetExceptionDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = WebDriverManager.chromedriver().create();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement firstAlert = driver.findElement(By.id("alertButton"));
		firstAlert.click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();

		WebElement AlertTitle = driver.findElement(By.xpath("//h1[text()='Alerts']"));
		AlertTitle.click();
		
		Thread.sleep(4000);

		// Switching to timed alert
		WebElement timedAlert = driver.findElement(By.id("timerAlertButton"));
		Thread.sleep(5000);
		timedAlert.click();
		Alert TimedAlert = driver.switchTo().alert();
		String tmedText = TimedAlert.getText();
		System.out.println("Text of the timed alert is : " + tmedText);
		TimedAlert.dismiss();

		// Again trying to switch the dismissed timed alert
		driver.switchTo().alert().dismiss();

	}

}
