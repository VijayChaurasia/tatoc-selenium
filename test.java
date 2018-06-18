package tatac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	}}
		
		//driver.quit();
		

	
