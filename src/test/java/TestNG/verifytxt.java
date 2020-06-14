package TestPrj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class verifytxt {
       static  WebDriver driver;
	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http://3.135.223.226/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
  @Test
  public void verifyaddbook() {
	  driver.findElement(By.xpath("//*[@id=\"About Us\"]")).click();
	  String val = "Lorem Ipsum Dipsum is simply dummy";
	  if (verifyTextPresent(val)) {
		System.out.println(val + " Text Present on screen");
//test.log(LogStatus.PASS,  test.addScreenCapture(screenshot.getAbsolutePath())+val + " Text Present on screen");
	}else {
		System.out.println(val + " Text not Present on screen");
//		test.log(LogStatus.FAIL,  test.addScreenCapture(screenshot.getAbsolutePath())+val + " Text not Present on screen");
	}
  }
	public static boolean verifyTextPresent(String value) {
		boolean found = false;
		// String value = "Lorem Ipsum Dipsum is simply dummy";
		if (driver != null) {
			WebElement element = null;
			// try {

			// Wait for the element to be found and visible with the polling interval
			WebDriverWait wait = new WebDriverWait(driver, TimeUnit.MILLISECONDS.toSeconds(50000),
					TimeUnit.SECONDS.toMillis(2));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"PID-ab2-pg\"]"))));
			element = driver.findElement(By.xpath("//*[@id=\"PID-ab2-pg\"]"));

			// Compare the text
			if (element.getText().contains(value)) {
				found = true;
			} else {
				found = false;
			}

		}
		return found;
	}
  
  @AfterMethod
  public void close() {
	  driver.close();
	}
}
