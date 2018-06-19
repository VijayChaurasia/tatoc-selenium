package tatac;
import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.*;

import org.omg.CORBA.Current;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.host.Set;
public class test {
	public static void main(String args[])
	{
		//System.setProperty("webdriver.chrome.driver", "/home/vijayprakash/Downloads/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.className("greenbox")).click();
		boolean flag=true;
		driver.switchTo().frame("main");
		String s1=driver.findElement(By.xpath("//*[text()[contains(.,'Box 1')]]")).getAttribute("class");
		while(flag)
		{
			driver.switchTo().frame("child");
			String s2=driver.findElement(By.xpath("//*[text()[contains(.,'Box 2')]]")).getAttribute("class");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			if(s1.equals(s2))
			{
				flag=false;
				driver.findElement(By.xpath("//*[text()[contains(.,'Proceed')]]")).click();;
			}
			else
			{
				driver.findElement(By.xpath("//*[text()[contains(.,'Repaint Box 2')]]")).click();
			}
		}
		driver.switchTo().defaultContent();
		WebElement from=driver.findElement(By.id("dragbox"));
		WebElement to=driver.findElement(By.id("dropbox"));
		Actions builder=new Actions(driver);
		builder.clickAndHold(from).moveToElement(to).release(to).build().perform();
		//draganddrop.per
		driver.findElement(By.linkText("Proceed")).click();
		driver.findElement(By.linkText("Launch Popup Window")).click();
		String main=driver.getWindowHandle();
		System.out.println("Current : "+main);
		//ArrayList<String> al=new ArrayList<String>();
		//al.add(driver.get)
		java.util.Set<String> sub= driver.getWindowHandles();
		Iterator<String> i1=sub.iterator();
		while(i1.hasNext())
		{
			String child=i1.next();
			if(!main.equalsIgnoreCase(child))			
	            {    		
	                    driver.switchTo().window(child);	                                                                                                           
	                    driver.findElement(By.id("name")).sendKeys("vijay");                			
	                    
	                    driver.findElement(By.id("submit")).click();			
//	                        driver.close();		
	            }		
		}
		System.out.println("Size : "+driver.getWindowHandles().size());
		driver.switchTo().window(main);
		System.out.println("Current : "+driver.getWindowHandle());
		System.out.println("Before Proceed");
	/*	try
		{
			Thread.sleep(5000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}*/
		//driver.findElement(By.linkText("Launch Popup Window")).click();
		driver.findElement(By.linkText("Proceed")).click();
		
		
		System.out.println("After Proceed");
		driver.findElement(By.linkText("Generate Token")).click();
		String Token = driver.findElement(By.id("token")).getText();
		 System.out.println(Token);
		 String substring1=Token.substring(7);
		 Cookie name = new Cookie("Token", substring1);
		 driver.manage().addCookie(name);
driver.findElement(By.linkText("Proceed")).click(); 
		
		
		
	
		
		
		
	}}
		
		//driver.quit();
		

	
