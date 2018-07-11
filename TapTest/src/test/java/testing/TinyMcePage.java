package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TinyMcePage {

	WebDriver driver;JavascriptExecutor js;
	public TinyMcePage(WebDriver driver,JavascriptExecutor js)
	{
		this.driver=driver;
		this.js=js;
	}
	
	public String istinypage() 
	{
		return driver.getCurrentUrl();
	}
	
	public void changeText()
	{ 
	  WebElement ele=driver.findElement(By.id("mce_0_ifr"));
      driver.switchTo().frame(ele);
      System.out.println(js.executeScript("return document.querySelector(\"body[id='tinymce']>p\").textContent").toString());
      js.executeScript("document.querySelector(\"body[id='tinymce']>p\").innerHTML=''");
      js.executeScript("document.querySelector(\"body[id='tinymce']>p\").innerHTML='QA INFOTECH'");
      
	}
}
