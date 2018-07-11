package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class status
{
WebDriver driver;JavascriptExecutor js;

public status(WebDriver driver,JavascriptExecutor js)
{
	this.js=js;this.driver=driver;
}


public String pageisdisplayedwith404()
{
	return driver.findElement(By.xpath("//div[@class='example']//p")).getText();
}

public int statuscodecheck()
{
	Response res=RestAssured.get("http://10.0.31.161:9292/status_codes/404");
	int code=res.getStatusCode();
	return code;
}


public Page back()
{
driver.findElement(By.xpath("//div[@class='row'][2]//a[1]")).click();		
return new Page(driver,js);
}
}
