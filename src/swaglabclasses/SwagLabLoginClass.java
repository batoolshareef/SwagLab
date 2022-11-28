package swaglabclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwagLabLoginClass {

	public WebDriver driver;

	public WebDriverWait wait;

	@BeforeTest
	public void setup_and_Login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Chromedriver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

//		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("problem_user");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

	}

//		@Test (priority = 1, groups="addItem")
//		public void add_first_item () throws InterruptedException {
//			Thread.sleep(3000);
//			
//			driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
//			
//		}
		
	@Test(groups = "addItem")
	public void add_all_items() throws InterruptedException {
		Thread.sleep(3000);

//		 List<WebElement> myitems= driver.findElements(By.xpath("//button[@class='btn_primary']"));

		List<WebElement> myitems = driver.findElements(By.className("btn_primary"));

		int expecteditemestofind = myitems.size();
		for (int i = 0; i < myitems.size(); i++) {
System.out.println(i+1);
			myitems.get(i).click();
			//System.out.println(myitems.get(i).getText()+i);	
		}
		String actualitemsthatfound = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		 int myactual = Integer.parseInt(actualitemsthatfound); 
		 
		 Assert.assertEquals(myactual, expecteditemestofind);
		}

//@Test (priority = 2, groups="removeItem")
//public void remove_first_item () throws InterruptedException {
//	Thread.sleep(5000);
//			
//	driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
//}


//	@Test 
//	public void remove_All_Items () throws InterruptedException {
//		
//		Thread.sleep(3000);
//		
//		
//		List<WebElement> removeElements = driver.findElements(By.className("btn_secondary"));
//		int MyNumber = removeElements.size(); 
//
//		for (int i = 0 ; i <removeElements.size();i++) {
//			Thread.sleep(1000);
//
//			removeElements.get(i).click();
//			System.out.println("item"+"#"+(i+1)+"removed");
//			MyNumber=MyNumber-1; 
//		}
//		int expecteditemsafterremove = 0 ; 
//		
//		int actualnumberafterremove = MyNumber; 
//		
//		Assert.assertEquals(actualnumberafterremove, expecteditemsafterremove);
//	}

	//-----------05/11/2022 lecture
//	@Test
//	public void Sort_Price_Low_High() throws InterruptedException {
//
//		Thread.sleep(3000);
//		driver.manage().window().maximize();
//
//		WebElement mymenuList = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select"));
//
//		Select myselection = new Select(mymenuList);
//		myselection.selectByVisibleText("Price (low to high)");
//
//		Thread.sleep(3000);
//		String low_price_one = driver
//				.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();
//
//		String low_price_two = low_price_one.substring(1);
//
//		Double int_price_low = Double.parseDouble(low_price_two);
//		
//
//		// we have done from the low item --------------------------------------
//
//		// we will start with the high item --------------------------------------
//
//		String high_price_one = driver
//				.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[6]/div[2]/div[2]/div")).getText();
//
//		String high_price_two = high_price_one.substring(1);
//		Double int_price_high = Double.parseDouble(high_price_two);
//
//        Assert.assertEquals(int_price_high>int_price_low, true);
//
//	}
	
	@Test
	public void reset_application_state () throws InterruptedException {
		
		
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
	
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"reset_sidebar_link\"]")).click();
		
		String actualCartNumber = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).getText();
		
		System.out.println(actualCartNumber);
//		int actualCartNumber_int = Integer.parseInt(actualCartNumber);
		
		Assert.assertEquals(actualCartNumber, "");
	}

}
