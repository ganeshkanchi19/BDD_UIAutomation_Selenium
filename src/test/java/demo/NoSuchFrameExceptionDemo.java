package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchFrameExceptionDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = WebDriverManager.chromedriver().create();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/frames");

		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		String Frame1title = frame1.getText();
		System.out.println("Title of the first frame is : " + Frame1title);

		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		String Frame2title = frame2.getText();
		System.out.println("Title of the second frame is : " + Frame2title);

		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		String Frame3title = frame3.getText();
		System.out.println("Title of the third frame is : " + Frame3title);

	}

}
