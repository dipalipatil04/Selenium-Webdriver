import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice4 {

	public static void main(String[] args) {

		// Launch browser and Open Godaddy.com
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dipali\\Downloads\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.godaddy.com/");

		// maximize browser window
		driver.manage().window().maximize();

		// Validate Page title
		String expTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
		String rcvdTitle = driver.getTitle();
		Assert.assertTrue(expTitle.equals(rcvdTitle));

		// Print current url
		String expUrl = "https://in.godaddy.com/";
		String rcvdUrl = driver.getCurrentUrl();
		Assert.assertTrue(expUrl.equals(rcvdUrl));

		// check if Page source contains page URL
		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains(expUrl));

		driver.close();
	}

}
