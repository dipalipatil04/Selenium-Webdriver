
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class practice1 {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Dipali\\Downloads\\Selenium\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.edge.driver","C:\\Users\\Dipali\\Downloads\\Selenium\\edgedriver_win64\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();

		driver.get("https://www.cleartrip.com/"); // URL'

		// Check if only "OneWay" is selected, other are deselected
		Assert.assertTrue(driver.findElement(By.id("OneWay")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("RoundTrip")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("MultiCity")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("[id=\"ReturnDate\"]")).isDisplayed());

		// Select 'From' airport as 'Pune' from Autoselect drpdown

		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("Pun");
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-1']/li/a")));
		List<WebElement> from = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
		//List<String> frm = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a")).stream().filter(s->s.getText().contains("Pune")).collect(Collectors.toList());
		for (WebElement f : from) {
			if (f.getText().contains("Pune")) {
				f.click();
				break;
			}
		}

		// Select 'To' airport as 'Delhi' from Autoselect drpdown
		driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("Del");
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-2']/li/a")));

		List<WebElement> to = driver.findElements(By.xpath("//ul[@id='ui-id-2']/li/a"));
		for (WebElement t : to) {
			if (t.getText().contains("Delhi")) {
				t.click();
				break;
			}
		}
		// Select month 'June'
		driver.findElement(By.xpath("//a[@class='nextMonth ']")).click();
		List<WebElement> month = driver.findElements(By.cssSelector(".ui-datepicker-month"));
		int monthcount = month.size();
		for (int i = 0; i < monthcount; i++) {
			String expMonth = month.get(i).getText();

			if (expMonth.equalsIgnoreCase("June")) {
				month.get(i).click();
			}
		}
		// Select date '25'

		List<WebElement> date = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		int dateCount = date.size();
		for (int i = 0; i < dateCount; i++) {
			String expDate = date.get(i).getText();

			if (expDate.equalsIgnoreCase("25")) {
				date.get(i).click();
			}
		}

		// select 3 Adults
		driver.findElement(By.id("Adults")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='Adults']/option[3]")));
		driver.findElement(By.xpath("//select[@id='Adults']/option[3]")).click();
		
		//select 1 child
		driver.findElement(By.id("Childrens")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='Childrens']/option[2]")));
		driver.findElement(By.xpath("//select[@id='Childrens']/option[2]")).click();

	}

}
