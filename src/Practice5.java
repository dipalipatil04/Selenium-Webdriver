import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice5 {

	public static void main(String[] args) {

		// Launch browser and Open amazon.in
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dipali\\Downloads\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//Validate Page Title
		String expTitle ="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String rcvdTitle = driver.getTitle();
		Assert.assertTrue(expTitle.equals(rcvdTitle));
		
		//Navigate to another page & fetch page title
		driver.findElement(By.linkText("Mobiles")).click();
		System.out.println("Page title is: " + driver.getTitle());
		
		//navigate back & validate home page title
		driver.navigate().back();
		String navRcvdTitle= driver.getTitle();
		Assert.assertTrue(expTitle.equals(navRcvdTitle));
		
		driver.close();
	}

}
