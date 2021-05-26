import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Practice8 {

	public static void main(String[] args) {
		// Open browser and got to URL
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dipali\\Downloads\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		
		//signin/ Enter email adress / submit
		driver.findElement(By.xpath("//a[@class='login']")).click();
		String eid="abcer56@ghi.com";
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(eid);
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		//fill up the from with personal details
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		//WebDriverWait w = new WebDriverWait(driver, 5);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_gender2']")));
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		String uname="abc";
		String lname= "ghi";
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id='email']")).getText().compareTo(eid); //compare if given email id is present here
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("125634");
		
		WebElement dp1 = driver.findElement(By.xpath("//select[@id='days']"));
		Select d1= new Select(dp1);
		d1.selectByValue("15");
		
		WebElement dp2 = driver.findElement(By.xpath("//select[@id='months']"));
		Select d2= new Select(dp2);
		d2.selectByIndex(4);
		
		WebElement dp3 = driver.findElement(By.xpath("//select[@id='years']"));
		Select d3= new Select(dp3);
		d3.selectByValue("2001");
		
		driver.findElement(By.xpath("//input[@id='firstname']")).getText().compareTo(uname);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("strup");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("kjk");
		
		WebElement dp4 = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select d4= new Select(dp4);
		d4.selectByVisibleText("Ohio");
		
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("78994");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("wxyz, 56 ghdj");
		driver.findElement(By.id("submitAccount")).click();
		
		//validate account created
		String userrcvd= driver.findElement(By.xpath("//a[@class='account']")).getText();
		Assert.assertTrue(userrcvd.equals(uname +" " + lname));
	}

}
