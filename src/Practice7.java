import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice7 {

	public static void main(String[] args) {
		// Launch browser and Open URL
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dipali\\Downloads\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

		//fill the form
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Gokul");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("jain");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("5th Nov 1995");
		driver.findElement(By.xpath("//input[@value='Automation Tester']")).click();
		driver.findElement(By.xpath("//input[@value='Selenium Webdriver']")).click();
		
		//Select continent "Africa" from static dropdown
		
		WebElement Drop_Down1 = driver.findElement(By.xpath("//select[@id='continents']"));
		Select s = new Select(Drop_Down1);
		s.selectByVisibleText("Africa");
		
		
		//Select multiple options from static dropdown
		WebElement Drop_Down2 = driver.findElement(By.xpath("//select[@id='selenium_commands']"));
		Select dd2 = new Select(Drop_Down2);
		dd2.selectByVisibleText("WebElement Commands");
		dd2.selectByIndex(3);
		
	}

}
