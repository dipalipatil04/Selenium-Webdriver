
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dipali\\Downloads\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/"); // URL'

		//get Email placeholder & compare to expected placeholder
		String unameReceived = driver.findElement(By.id("email")).getAttribute("placeholder");
		String unameExpected = "Email address or phone number";
		Assert.assertTrue(unameExpected.equals(unameReceived));
		
		//get Password placeholder & compare to expected placeholder
		String pwdReceived = driver.findElement(By.id("pass")).getAttribute("aria-label");
		String pwdExpected = "Password";
		Assert.assertTrue(pwdExpected.equals(pwdReceived));
		
		//Login with invalid data & fetch error message
		driver.findElement(By.id("email")).sendKeys("dipali");
		driver.findElement(By.id("pass")).sendKeys("12334");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		String errorExpected = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		String errorReceived = driver.findElement(By.xpath("//div[@id='email_container']/div[2]")).getText();
		Assert.assertTrue(errorExpected.equals(errorReceived));
		System.out.println("Error message: " + errorReceived);
		driver.close();
		}
	

}
