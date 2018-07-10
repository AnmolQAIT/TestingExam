package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragDrop {
	WebDriver driver;
	JavascriptExecutor js;
	
	public DragDrop(WebDriver driver,JavascriptExecutor js)
	{
		this.driver=driver;this.js=js;
	}
	
	public boolean Drag()
	{
		driver.manage().window().maximize();
		WebElement dragbox = driver.findElement(By.id("column-a"));
		WebElement dropbox = driver.findElement(By.id("column-b"));
		Actions actions  = new Actions(driver);
		actions.dragAndDrop(dragbox, dropbox).build().perform();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='column-a']//header")).getText(),"A");
		return true;
	}
	
	public Page back()
	{
        driver.findElement(By.xpath("//div[@class='row'][2]//a[1]")).click();
		
		return new Page(driver,js);
	}

}
