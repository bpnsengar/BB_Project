package Generic_Component;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.commons.io.FileUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Base_Class {
	public static Process process;
	public  AppiumDriver driver;
	Utility_Class c1 = new Utility_Class();
	public void Start_Server() throws IOException, InterruptedException
	{
		String Start_server="E:\\Appium\\node.exe  E:\\Appium\\node_modules\\appium\\bin\\appium.js";
		
		process = Runtime.getRuntime().exec(Start_server);
		
		if(process!= null)
		{
			System.out.println("Started Appium Server");
		}
		else
		{
			System.out.println("NOT Started the Appium Server");
		}
		
		Thread.sleep(12000);	
		
		
	}
	
	public void Launch_App() throws IOException{
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Lenovo A7020a48");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0");
		
		//App details
		capabilities.setCapability("appPackage", c1.reading_properties("Package_name"));
		capabilities.setCapability("appActivity",c1.reading_properties("Activity_name"));
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 
	}
	
	//Explicit wait
	public void Explicit_Wait(WebElement ele, long T1){
		
		WebDriverWait wait = new WebDriverWait(driver,T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		
	}
	
	
	//Taking ScreenShot
	public void Capture_Screenshot(String TC_ID,String Order) throws IOException{
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		File file = new File(df.format(date)+".png");
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("E:\\BB_Project\\Screenshot\\"+TC_ID+"-"+Order+"-"+file));

	}
	
	
	public void Stop_Server(){
		
		if (process != null){
			
			System.out.println("Appium server killed");
			process.destroy();	
		}
		else {
			System.out.println("Appium server is stopped");
		}
		
	}
}
