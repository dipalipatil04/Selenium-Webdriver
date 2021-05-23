import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		List<WebElement> conlist = driver.findElements(By.xpath("//select[@id='continents']/option"));
		for (int i = 0; i < conlist.size();)

			if (conlist.get(i).getText().equals("Africa")) {
				conlist.get(i).click();
				break;
			}
			else 
			{
				i++;
			}
		
		
		//Filter commands starting from 'W' & Print it in output
		List<String> selCommand = driver.findElements(By.xpath("//select[@id='selenium_commands']/option")).stream()
				.filter(s -> s.getText().startsWith("W")).map(s -> s.getText()).collect(Collectors.toList());
		System.out.println("Selected Selenium Command: " + selCommand);
		
		//Select commands starting from 'W'
		List<WebElement> selCommandd = driver.findElements(By.xpath("//select[@id='selenium_commands']/option"))
				.stream().filter(s -> s.getText().startsWith("W")).collect(Collectors.toList());
		selCommandd.get(0).click();
		selCommandd.get(1).click();
	}

}
