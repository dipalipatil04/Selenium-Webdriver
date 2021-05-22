import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;

public class Practice3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dipali\\Downloads\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/"); // URL'

		// To check if all labels are as expected
		List<String> expected = Arrays.asList("Name", "Email", "Password", "Gender", "Employment Status:",
				"Date of Birth");
		List<String> elements = driver.findElements(By.xpath("//div [@class='form-group']/label")).stream()
				.map(s -> s.getText()).collect(Collectors.toList());

		Assert.assertTrue(elements.equals(expected));
		System.out.println(elements);

		// Fill the form and submit
		String name = "Param";
		driver.findElement(By.xpath("/html/body/app-root/form-comp/div/form/div[1]/input")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys("Param34@g.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234");
		driver.findElement(By.xpath("//div[@class='form-group']/select/option[2]")).click();
		driver.findElement(By.xpath("//input[@value='option2']")).click();
		driver.findElement(By.name("bday")).sendKeys("13/05/1996");
		

		// Take Screenshot after scrolling window
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("C:\\Users\\Dipali\\OneDrive\\Pictures\\Screenshots\\d.png"));

		driver.findElement(By.cssSelector("[type='submit']")).click();

	}

}
