package testing;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Page {
WebDriver driver;
JavascriptExecutor js;
boolean str1,str2;
public Page(WebDriver driver,JavascriptExecutor js)
{
	this.js=js;
	this.driver=driver;
}

public void basic_auth() throws IOException
{
	driver.findElement(By.xpath("//div[@id='content']//ul//li[2]//a")).click();
	Runtime.getRuntime().exec("C:\\Users\\anmol\\OneDrive\\Desktop\\Autoit\\HandleAuthentication.exe");
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

}
