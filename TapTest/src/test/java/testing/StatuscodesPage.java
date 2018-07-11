package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class StatuscodesPage
{
WebDriver driver;
JavascriptExecutor js;

public StatuscodesPage(WebDriver driver,JavascriptExecutor js)
{
	this.driver=driver;
	this.js=js;
}

public String isstatuscodespage()
{
	return driver.getCurrentUrl();
}
public status clickon404()
{
	driver.findElement(By.xpath("//a[@href='status_codes/404']")).click();
	return new status(driver,js);
}
}
