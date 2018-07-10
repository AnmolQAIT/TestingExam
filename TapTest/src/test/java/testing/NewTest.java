package testing;

import java.io.IOException;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class NewTest {
  DragDrop d;
  Page p;
  Dynamic dy;
 
  Hover h;
  CheckBox c;
  Droplist l;
  Dynamiccontrol dc;
  WebDriver driver;
  JavascriptExecutor js;
  
  @Test(priority=1)
  public void ainvokebrowser()
  {
	  driver=new ChromeDriver();
	  driver.get("http://10.0.31.161:9292/");
	  js= (JavascriptExecutor)driver;
	  p=new Page(driver,js);
  }
  
  @Test(priority=2)
  public void bbasicauth()
  {
	  boolean status=p.broken_image();
	  if(status)
		  Assert.assertTrue(status);
	  driver.get("http://10.0.31.161:9292/");
  }
  
  @Test(priority=3)
  public void checkhover()
  {
	  h=p.hover();
	  Assert.assertTrue(h.ishoverpage());
	  driver.get("http://10.0.31.161:9292/");
  }
  
  @Test(priority=4)
  public void ischeckbox()
  {
	  c=p.checkbox();
	 int  p1=c.clickoncheckbox();
	 Assert.assertEquals(p1,2);
	 p=c.back();
  }
  
  @Test(priority=5)
  public void drag()
  {
	  d=p.box();
//	  boolean status=d.Drag();
//	  Assert.assertTrue(status);
	  p=d.back();
  }
  
  @Test(priority=6)
  public void drop()
  {
	 l=p.dropdown();
	 l.drop();
	 p=l.back();
  }
  
  @Test(priority=7)
  public void dyamic()
  {
	  dy=p.data();
	  boolean status=dy.refreshdynamic();
	  Assert.assertTrue(status);
	  p=dy.back();
  }
  
  @Test(priority=8)
  public void dynamic_control()
  {
	  dc=p.control();
	  Assert.assertTrue(dc.removeandaddbox());
	  p=dc.back();
  }
  	
}
