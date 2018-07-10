package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
	WebDriver driver;
	JavascriptExecutor js;
	public CheckBox(WebDriver driver,JavascriptExecutor js)
	{
		this.driver=driver;
		this.js=js;
	}

	public void ischeckboxpage()
	{
		
	}
	
	public int clickoncheckbox()
	{
		int count=0;
		List<WebElement> boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement box:boxes)
		{
			if(!box.isSelected())
			{
				box.click();
			}
		}
		for(WebElement box:boxes)
		{
			if(box.isSelected())
			{
				count++;
			}
		}
		return count;
		
	}
	
	public Page back()
	{
driver.findElement(By.xpath("//div[@class='row'][2]//a[1]")).click();
		
		return new Page(driver,js);
	}
}
