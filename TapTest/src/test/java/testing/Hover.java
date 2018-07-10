package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Hover {
WebDriver driver;
JavascriptExecutor js;

public Hover(WebDriver driver, JavascriptExecutor js)
{
	this.driver=driver;
	this.js=js;
}

public boolean ishoverpage()
{
	int counter=0;
	boolean ret=true;
	Assert.assertEquals(driver.getCurrentUrl(),"http://10.0.31.161:9292/hovers");
	List<WebElement> listImages=driver.findElements(By.className("figure"));
	System.out.println("No. of Images: "+listImages.size());
	for(WebElement image:listImages)
    {
        if(image.isDisplayed())
        {
            counter++;         
        }
    }
	if(counter==3)
		ret=true;
	else
		ret= false;
	
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//div[@class='figure'][1]//img"))).perform();
	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='figure'][1]//div//h5")).getText(),"name: user1");
	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='figure'][1]//div//a")).getText(),"View profile");
	
	action.moveToElement(driver.findElement(By.xpath("//div[@class='figure'][2]//img"))).perform();
	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='figure'][2]//div//h5")).getText(),"name: user2");
	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='figure'][2]//div//a")).getText(),"View profile");

	action.moveToElement(driver.findElement(By.xpath("//div[@class='figure'][3]//img"))).perform();
	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='figure'][3]//div//h5")).getText(),"name: user3");
	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='figure'][3]//div//a")).getText(),"View profile");
	return ret;
}


}
