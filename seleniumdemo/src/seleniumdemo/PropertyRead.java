package seleniumdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PropertyRead {
	static WebDriver driver;
	public static String[] eleProperty(String locator) throws IOException
	{
		FileInputStream f=new FileInputStream("raghava.properties");
		Properties pos=new Properties();
		pos.load(f);
		String username=pos.getProperty(locator);
		//System.out.println(username);
		String objRef[]=username.split("#");
		return objRef ;
	}
	public static void main(String[] args) throws IOException {
		//String[] ref=PropertyRead.eleProperty("irctc.login");
		//String[] ref1=PropertyRead.eleProperty("irctc.login.username");
		//String[] ref2=PropertyRead.eleProperty("irctc.login.password");
		
		//System.out.println(b);
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\selenium jar files\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.id((PropertyRead.eleProperty("irctc.login"))[1])).click();
		driver.findElement(By.id(PropertyRead.eleProperty("irctc.login.username")[1])).sendKeys("R55096628r");
		driver.findElement(By.id(PropertyRead.eleProperty("irctc.login.password")[1])).sendKeys("9550966282Aa");
		//driver.findElement(By.id(PropertyRead.eleProperty("irctc.login.checkbox")[1])).click();
		//driver.findElement(By.xpath(PropertyRead.eleProperty("irctc.signin")[1])).click();
		//driver.findElement(By.linkText(""))
		System.out.println("success");
	}
}