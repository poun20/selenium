package test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Object_repository.Flight_search_page;
import utility.excel;
import utility.testBase;

public class flight_booking_test extends testBase {
	
		int tc_row; 
		flight_booking_test() throws Exception{
			super();
			// todo auto-generated constructor stub
		}
		@BeforeClass
		public void beforeClass()throws Exception{
			initialize();
			excel.setExcelFile  (Datafile,sheetname);
			tc_row =excel.getRowcontains("flight_booking_test");
		}
		 @Test
		 public void f() throws Exception{
			 try {
				 String from_loc = excel.getCellData(tc_row,"from_loc");
				 String to_loc = excel.getCellData(tc_row,"to_loc");
				 String departure_data = excel.getCellData(tc_row,"date(mm/dd/yyyy)");
				 String Adults_count = excel.getCellData(tc_row,"Adults_count");
				 String Childs_count = excel.getCellData(tc_row,"Childs_count");
				 String infants_count = excel.getCellData(tc_row,"Infants_count");
				 String travel_class = excel.getCellData(tc_row,"travel_class");
				 String non_stop_flight = excel.getCellData(tc_row,"non_stop_flight(Y/N");
				 //driver.switchTo().alert().dismiss();
				 Flight_search_page obj = new Flight_search_page();
				 obj.selectlocation(from_loc, to_loc, departure_data);
				 obj.enter_details(Integer.parseInt(Adults_count),Integer.parseInt(Childs_count), Integer.parseInt(infants_count));
				 obj.select_travel_class(travel_class);
				 if(non_stop_flight.equalsIgnoreCase("Y")) {
					 obj.non_stop_flight.click();
				 }
				 obj.search_btn.click();
				 }
			 catch(Exception e) {
				 System.out.println(e.getMessage());
			 }
		 }
		 @AfterClass
		 public void afterClass() {
			 driver.quit();
		 }
			/*
			 * System.out.println("Inside before method"); // System.setProperty(
			 * "webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe"
			 * ); System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			 * 
			 * 
			 * ChromeDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
			 * driver.get("https://www.yatra.com/"); driver.manage().window().maximize();
			 * Thread.sleep(2000); PageFactory.initElements(driver,
			 * Flight_search_page.class);
			 * Flight_search_page.username.sendKeys("user@phptravels.com");
			 * Flight_search_page.password.sendKeys("demouser");
			 * Flight_search_page.loginButton.click();
			 */
		  
			/*
			 * loginpageobjects.username(driver).sendKeys("user@phptravels.com");
			 * loginpageobjects.password(driver).sendKeys("demouser");
			 * loginpageobjects.loginButton(driver).click();
			 */
		  
		  
		  
		  
		  //THIS normal method
		  //driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		  //driver.findElement(By.name("password")).sendKeys("demouser");
		  //driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/button")).click();
			
		  //driver.quit();
	 }

