
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice6 {

	public static void main(String[] args) {

		// Launch browser and Open techlistic.com
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dipali\\Downloads\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/");
		driver.manage().window().maximize();

		// Click on 'Java' and validate page title
		String expjavaTitle = "Java Tutorial For Beginners - Techlistic";
		driver.findElement(By.linkText("Java")).click();
		String rcvdjavaTitle = driver.getTitle();
		Assert.assertTrue(expjavaTitle.equals(rcvdjavaTitle));

		// Click on 'Selenium' & validate page title
		String expSelTitle = "Selenium Webdriver Tutorial - Techlistic";
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		String rcvdSelTitle = driver.getTitle();
		Assert.assertTrue(expSelTitle.equals(rcvdSelTitle));

		// Click on 'Blogs' & validate page title
		String expBlogTitle = "Best Selenium Blogs";
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Blogs']")).click();
		String rcvdBlogTitle = driver.getTitle();
		Assert.assertTrue(expBlogTitle.equals(rcvdBlogTitle));

		// Click on 'TestNG' & validate page title
		String expTngTitle = "Selenium-TestNG Framework Tutorial";
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='TestNG']")).click();
		String rcvdTngTitle = driver.getTitle();
		Assert.assertTrue(expTngTitle.equals(rcvdTngTitle));

		driver.close();

	}

}
