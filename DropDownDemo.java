package demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = WebDriverManager.chromedriver().create();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		Thread.sleep(5000);
		WebElement drp = driver.findElement(By.xpath("//select[@id='course']"));
		Select s = new Select(drp);
		s.selectByVisibleText("Java");
		String firstSeelcted = drp.getText();
		System.out.println("Value of the selected option is : " + firstSeelcted);

		if (drp.getText().equals(firstSeelcted)) {
			System.out.println("Java is selected successfully");
		} else {
			System.out.println("Not seletced any value from dropdown yet");
		}

		Thread.sleep(5000);
		s.selectByIndex(3);
		String expVal = drp.getText();
		if (drp.getText().equals(expVal)) {
			System.out.println("Python is selected successfully");
		} else {
			System.out.println("Python is failedto select");
		}

		// Selecting multiple values from multi select dropdown
		Thread.sleep(5000);
		WebElement multiDrop = driver.findElement(By.xpath("//select[@id='ide']"));

		// Initilize select class
		Select multiSel = new Select(multiDrop);
		// Verify it supports multiple selections
		if (multiSel.isMultiple()) {
			// Get all options
			List<WebElement> allValue = multiSel.getOptions();

			// Hold CTRL and select multiple options using Actions
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).click(allValue.getFirst()).click(allValue.getLast()).keyUp(Keys.CONTROL)
					.build().perform();

			System.out.println("Multiple options selected successfully");
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./target/screenshots/MultiSelectDropDown.jpg"));
			driver.quit();

		} else {
			System.out.println("Dropdown does not support multiple selections");
		}
		// Value to check
		String exValToCheck = "Eclipse";
		boolean isSelected = false;

		// Get all selected options
		List<WebElement> selectedOptions = multiSel.getAllSelectedOptions();
		for (WebElement option : selectedOptions) {
			if (option.getText().equalsIgnoreCase(exValToCheck)) {
				isSelected = true;
				break;
			}

		}

		if (isSelected) {
			System.out.println(exValToCheck + " is selected succssfully");
		} else {
			System.out.println(exValToCheck + " is not selected ");
		}

	}

}
