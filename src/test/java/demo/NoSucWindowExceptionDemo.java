package demo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSucWindowExceptionDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = WebDriverManager.chromedriver().create();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		//1.NoSuchWindowException
		
		driver.get("https://demoqa.com/browser-windows");
		// Open new child window within the main window
		WebElement NewWin = driver.findElement(By.xpath("//button[@id='windowButton']"));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		NewWin.click();
		// Get handles of the windows
		String parentWindow = driver.getWindowHandle();
		Set<String> allwindowHandle = driver.getWindowHandles();
		Iterator<String> iterator = allwindowHandle.iterator();

		// Here we will check if child window has other child windows and will fetch the
		// heading of the child window

		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement childwinText = driver.findElement(By.id("sampleHeading"));
				System.out.println("Heading of child window is " + childwinText.getText());

			}
			// Closing the child window
			Thread.sleep(3000);
			driver.switchTo().window(parentWindow).close();

		}

		Thread.sleep(3000);
		// Clicking on New Tab
		WebElement NewTab = driver.findElement(By.xpath("//button[@id='tabButton']"));
		// Again trying to close the parent window from the new opened window. 
		//  But this time it will throw NoSuchWindowException
		// because the window which we are trying to close is not exist
		NewTab.click();
		driver.switchTo().window(parentWindow).close();

	}

}
