package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] geData() throws IOException{
		
		String path=".\\testData\\Opencart_LoginData.xlsx"; //reading data from file 
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrow = xlutil.getRowcount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata [][]=new String [totalrow][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrow;i++) {//1   //read the data from xl storing in two deminsional array
			for(int j=0;j<totalcols;j++)//0    i is rows j is col
			{
				logindata [i-1][j]=xlutil.getCellData("Sheet1", i, j);//1,0
			}
				
		}
		return logindata;
	}
	        //DataProvider 2
	
			//DataProvider 3
			
			//DataProvider 4

}
