package testing;

import java.io.IOException;

import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class NewTest {
  
  Page p;
  Hover h;
  CheckBox C;
  WebDriver driver;
  JavascriptExecutor js;
  
  @Test
  public void ainvokebrowser()
  {
	  driver=new ChromeDriver();
	  driver.get("http://10.0.31.161:9292/");
	  js= (JavascriptExecutor)driver;
	  p=new Page(driver,js);
  }
  
  @Test
  public void bbasicauth()
  {
	  boolean status=p.broken_image();
	  if(status)
		  Assert.assertTrue(status);
	  driver.get("http://10.0.31.161:9292/");
  }
  
 
  
  @Test
  public void checkhover()
  {
	  h=p.hover();
	  Assert.assertTrue(h.ishoverpage());
	  driver.get("http://10.0.31.161:9292/");
  }
  
  @Test
  public void ischeckbox()
  {
	  
  }
}
