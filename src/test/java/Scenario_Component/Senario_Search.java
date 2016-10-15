package Scenario_Component;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Senario_Search extends Base_Class {
	
	static Logger log=Logger.getLogger(Senario_Search.class);
	SoftAssert sAssert = new SoftAssert();

	@Test(dataProvider="dp_InValidSearch",dataProviderClass = Data_Provider_Component.DataProvider_Search.class,groups={"smoke"})
	public void invalid_search_test(String TC_ID,String Order,String Search_Item,String Exp_Result) throws IOException, InterruptedException
	{	
		log.info("Executing TEst Case "+ TC_ID + Order);
		Start_Server();
		Launch_App();
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		
		Explicit_Wait(BS_Pob.Search_btn, 25);
		BS_Pob.Click_Searchbtn();
		
		Explicit_Wait(BS_Pob.Search_txtbox, 20);
		BS_Pob.Enter_Searchtxt(Search_Item);
		
		Explicit_Wait(BS_Pob.Invalid_msg,20);
		String Output = BS_Pob.getInvalidmsg();
		
		if(Output.equals(Exp_Result))
		{
			log.info("Passed as Expected Result is " +Exp_Result + " Actual Result is "+Output);
			Capture_Screenshot(TC_ID, Order);
		}
		else
		{
			log.info("Failed as Expected Result is " +Exp_Result + " Actual Result is "+Output);
			sAssert.fail("Failed as Expected Result is " +Exp_Result + " Actual Result is "+Output);
			Capture_Screenshot(TC_ID, Order);
		}
	}
	
		@Test(dataProvider="dp_ValidSearch",dataProviderClass = Data_Provider_Component.DataProvider_Search.class,groups={"smoke"})
		public void valid_search_test(String TC_ID,String Order,String Search_Item,String Exp_Result) throws IOException, InterruptedException
		{	
			log.info("Executing TEst Case "+ TC_ID + Order);
			//Start_Server();
			log.info("Execution of the Testcase " +TC_ID +" Order is   " +Order);
			//Start_Server();
			Launch_App();
			
			PageObject_Search BS_Pob= new PageObject_Search(driver);
			
			Explicit_Wait(BS_Pob.Search_btn, 25);
			BS_Pob.Click_Searchbtn();
			
			Explicit_Wait(BS_Pob.Search_txtbox, 20);
			BS_Pob.Enter_Searchtxt(Search_Item);
			
			Explicit_Wait(BS_Pob.Valid_msg,20);
			String Output = BS_Pob.getValidmsg();
			
			String Actual_Result = Output.replace(" products", "");
			
			if(Actual_Result.equals(Exp_Result))
			{
				log.info("Passed as Expected Result is " +Exp_Result + " Actual Result is "+Actual_Result);
				Capture_Screenshot(TC_ID, Order);
			}
			else
			{
				log.info("Failed as Expected Result is " +Exp_Result + " Actual Result is "+Actual_Result);
				sAssert.fail("Failed as Expected Result is " +Exp_Result + " Actual Result is "+Actual_Result);
				Capture_Screenshot(TC_ID, Order);
			}
		
		
		
		Stop_Server();
		sAssert.assertAll();
	}
	
	
			
	
}
