package demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasic_Methods {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = WebDriverManager.chromedriver().create();
//		ChromeOptions options = new ChromeOptions();
//		Duration duration = Duration.of(1, ChronoUnit.MINUTES);
//		options.setScriptTimeout(duration);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		String actTitle = driver.getTitle();
		System.out.println("Title of the webapge is " + actTitle);
		WebElement txtbox = driver.findElement(By.xpath("//input[@id='userName']"));
		Thread.sleep(2000);
		txtbox.sendKeys("Ganesh Nagnath Kanchi");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File dest = new File("./target/screenshots/Sendkeys.jpg");
		FileUtils.copyFile(src,new File("./target/screenshots/Sendkeys.jpg"));
		driver.quit();
	}

}
