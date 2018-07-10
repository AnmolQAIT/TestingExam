package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Droplist {
	WebDriver driver;JavascriptExecutor js;
	public  Droplist(WebDriver driver,JavascriptExecutor js)
	{
	 this.driver=driver;this.js=js;
	}
	
	public void drop()
	{
		driver.findElement(By.xpath("//select[@id='dropdown']//option[2]")).click();	
	}
	
	public Page back()
	{
    driver.findElement(By.xpath("//div[@class='row'][2]//a[1]")).click();		
	return new Page(driver,js);
	}

}
