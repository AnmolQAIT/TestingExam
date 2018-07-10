package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Dynamic {
	WebDriver driver;
	JavascriptExecutor js;
	
	public Dynamic(WebDriver driver,JavascriptExecutor js)
    {
	this.driver=driver;this.js=js;
    }
	
	public boolean  refreshdynamic()
	{
	  	String str=driver.findElement(By.xpath("//div[@class=\"example\"]//div//div//div[1]//div//img")).getAttribute("src");
	  	String text1=driver.findElement(By.xpath("//div[@class='example']//div[@id='content']//div[@class='row'][1]//div[2]")).getText();
	  	driver.navigate().refresh();
	  	
	  	String str1=driver.findElement(By.xpath("//div[@class=\"example\"]//div//div//div[1]//div//img")).getAttribute("src");
	  	String text2=driver.findElement(By.xpath("//div[@class='example']//div[@id='content']//div[@class='row'][1]//div[2]")).getText();
	  	if(str!=str1 && text1!=text2)
	  		return true;
	  	else
	  		return false;
	}
	
	public Page back()
	{
        driver.findElement(By.xpath("//div[@class='row'][2]//a[1]")).click();
		
		return new Page(driver,js);
	}
}
