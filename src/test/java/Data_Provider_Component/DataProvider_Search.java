package Data_Provider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;


public class DataProvider_Search {

	//For providing valid data
	@DataProvider(name="dp_ValidSearch")
	public static Iterator<String[]> getValidDearchData() throws IOException{
		List<String[]> Obj = flagRowCount("Valid_Search");
		return Obj.iterator();
	}
	
	@DataProvider(name="dp_InValidSearch")
	public static Iterator<String[]> getInvalidSearchData() throws IOException{
		List<String[]> Obj = flagRowCount("Invalid_Search");
		return Obj.iterator();
	}
	//Common Method
	
	public static List<String[]> flagRowCount(String Scriptname) throws IOException{
		ExcelReadWrite xl = new ExcelReadWrite("E:\\BB_Project\\TestData\\TestData.xls");
		HSSFSheet Scenario_Search = xl.Setsheet("Scenario_Search");
		int Row_Count = xl.getrowcount(Scenario_Search);
		List <String[]> List_Search = new ArrayList<String[]>();
		for (int xlrow = 1; xlrow <= Row_Count;xlrow++ ){
			String Execute_Flag = xl.Readvalue(Scenario_Search, xlrow, "Execute_Flag");
			String Script_Name = xl.Readvalue(Scenario_Search, xlrow, "Script_Name");
			
			String [] arr_search = new String[4];
			if ((Execute_Flag.equals("Y")) && (Script_Name.equals(Scriptname))){
				arr_search[0] = xl.Readvalue(Scenario_Search, xlrow, "TC_ID");
				arr_search[1] = xl.Readvalue(Scenario_Search, xlrow, "Order");
				arr_search[2] = xl.Readvalue(Scenario_Search, xlrow, "Search_Item");
				arr_search[3] = xl.Readvalue(Scenario_Search, xlrow, "Exp_result");
				List_Search.add(arr_search);
				System.out.println(arr_search[0]);
			}//enf pf if
			
		}//end of for loop
		return List_Search;
		
		
		
		
	}
}
