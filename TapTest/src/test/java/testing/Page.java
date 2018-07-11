package testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class Page {
WebDriver driver;
JavascriptExecutor js;
boolean str1,str2;

public Page(WebDriver driver,JavascriptExecutor js)
{
	this.js=js;
	this.driver=driver;
}

public Page back()
{
driver.findElement(By.xpath("//div[@class='row'][2]//a[1]")).click();		
return new Page(driver,js);
}

public String basic_auth() 
{
//	driver.findElement(By.xpath("//div[@id='content']//ul//li[2]//a")).click();
//	driver.get("http://admin:admin@10.0.31.161:9292/basic_auth");
//    return driver.getCurrentUrl();
	driver.get("http://10.0.31.161:9292/");
	driver.get("http://admin:admin@10.0.31.161:9292/basic_auth");
	return driver.findElement(By.xpath("//div[@class='example']//p")).getText();
	
}

public boolean image1broken()
{
	driver.get("http://asdf.jpg/");
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='main-message']//h1")).getText(),"This site can’t be reached");
	return true;
}
public boolean image2broken()
{
	driver.get("http://hjkl.jpg/");
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='main-message']//h1")).getText(),"This site can’t be reached");
	return true;
}
public boolean broken_image() 
{
	driver.findElement(By.xpath("//div[@id='content']//ul//li[3]//a")).click();
    str1=image1broken();str2=image2broken();
    if(str1 && str2)
    {
    	return true;
    }
    else 
    	return false;
}

public Hover hover()
{
	driver.findElement(By.xpath("//div[@id='content']//ul//li//child::a[@href='/hovers']")).click();
	return new Hover(driver,js);
}

public CheckBox checkbox()
{
	driver.findElement(By.xpath("//div[@id='content']//ul//li//child::a[@href='/checkboxes']")).click();
	return new CheckBox(driver,js);
}

public DragDrop box()
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//div[@id=\"content\"]//ul//li[8]//a")).click();
	return new DragDrop(driver,js);
}

public Droplist dropdown()
{
	driver.findElement(By.xpath("//div[@id='content']//ul//li[9]//a")).click();
	return new Droplist(driver,js);
}

public Dynamic data()
{
	driver.findElement(By.xpath("//div[@id='content']//ul//li[10]//a")).click();
	return new Dynamic(driver,js);
}

public Dynamiccontrol control()
{
	driver.findElement(By.xpath("//div[@id='content']//ul//li[11]//a")).click();
	return new Dynamiccontrol(driver,js);
}

public StatuscodesPage statuscode()
{
	driver.findElement(By.xpath("//div[@id='content']//ul//child::a[@href='/status_codes']")).click();
	return new StatuscodesPage(driver,js);
//	driver.findElement(By.xpath("////a[@href='status_codes/404']")).click();
//	return new status(driver,js);
}


public TinyMcePage texteditorclick()
{
	driver.findElement(By.xpath("//a[@href='/tinymce']")).click();
	return new TinyMcePage(driver,js);
}
}
