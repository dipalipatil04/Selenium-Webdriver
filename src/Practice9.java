import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Practice9 {

	public static void main(String[] args) {

		// Open browser and got to URL
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dipali\\Downloads\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");

		// signin/ Enter email adress / submit
		driver.findElement(By.xpath("//a[@class='login']")).click();
		String eid = "abcd xyz";
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(eid);
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='create_account_error']/ol/li")));

		// Validate error message
		String errorM = "Invalid email address.";
		String rcvdErrorM = driver.findElement(By.xpath("//div[@id='create_account_error']/ol/li")).getText();
		System.out.println(rcvdErrorM);
		Assert.assertTrue(errorM.equals(rcvdErrorM));

	}

}
