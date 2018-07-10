package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Dynamiccontrol {
	WebDriver driver;JavascriptExecutor js;
	public Dynamiccontrol(WebDriver driver,JavascriptExecutor js)
	{
		this.driver=driver;
		this.js=js;
	}
	
	public boolean removeandaddbox()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//button")).isDisplayed());
		driver.findElement(By.xpath("//button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//button")).isDisplayed());
		driver.findElement(By.xpath("//button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
		return true;
	}
	
	public Page back()
	{
        driver.findElement(By.xpath("//div[@class='row'][2]//a[1]")).click();
		
		return new Page(driver,js);
	}

}
