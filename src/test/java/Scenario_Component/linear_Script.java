package Scenario_Component;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic_Component.Base_Class;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class linear_Script extends Base_Class{

	
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","GT-I9300I");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");
		
		capabilities.setCapability("appPackage", "com.bigbasket.mobileapp");
		capabilities.setCapability("appActivity", "com.bigbasket.mobileapp.activity.SplashActivity");		
		
		
		AppiumDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver,25);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.bigbasket.mobileapp:id/action_search")));
		driver.findElementById("com.bigbasket.mobileapp:id/action_search").click();
		driver.findElementById("com.bigbasket.mobileapp:id/searchView").sendKeys("nnnnnnnnn"+"\n");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.bigbasket.mobileapp:id/txtEmptyMsg1")));
		String Actual_output = driver.findElementById("com.bigbasket.mobileapp:id/txtEmptyMsg1").getText();
		System.out.println(Actual_output);
		
	}

}
