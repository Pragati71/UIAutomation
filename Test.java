package main;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
//import org.openqa.selenium.javascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\software\\Selenium\\browsers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		//Launch goibibo website
		driver.get("https://www.goibibo.com/");
		//click on round trip
		driver.findElement(By.xpath("//span[@id='roundTrip']")).click();
		
		//from and to city
		 WebElement text = driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']"));
		 Actions act = new Actions(driver);
		 act.click(text).perform();
		 act.sendKeys(text, "Bengaluru").perform();
		 act.pause(2000).perform();
		 act.sendKeys(text, Keys.ARROW_DOWN).perform();
		 act.sendKeys(Keys.ENTER).perform();
		 Thread.sleep(5000);
		 WebElement text1 = driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']"));
		 act.click(text1).perform();
		 act.sendKeys(text1, "Delhi").perform();
		 act.pause(2000).perform();
		 act.sendKeys(text1, Keys.ARROW_DOWN).perform();
		 act.sendKeys(Keys.ENTER).perform();
		 Thread.sleep(5000);
		
		//get current date
		 DateFormat dateFormat = new SimpleDateFormat("dd");
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 int i=Integer.parseInt(date1)+10;
		 int j=i+4;
		 
		String startDay = String.valueOf(i);
		String endDay = String.valueOf(j);
		
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='Departure']")).click();
		
		
		// Clicking over the startDay and endDay variable date
		driver.findElement(By.xpath("//div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/div[text()=" + startDay + "]")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/div[text()=" + endDay + "]")).click();
		
		//Traveller
		driver.findElement(By.xpath("//div[@id='pax_link_common']")).click();
		//
		driver.findElement(By.xpath("//button[@id='adultPaxPlus']")).click();
		//clise popup
		driver.findElement(By.xpath("//a[@id='pax_close']")).click();
		//Search
		driver.findElement(By.xpath("//button[@id='gi_search_btn']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		Thread.sleep(5000);
		
		//radio utton 1
		driver.findElement(By.xpath("//label[@for='DOTREZ#:I51324I5315#1']")).click();
		//radio button 2
		driver.findElement(By.xpath("//label[@for='DOTREZ#:I5768I51427#1']")).click();
		//book button
		driver.findElement(By.xpath("//input[@value='BOOK']")).click();
		
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,4000)", "");

		
		//title
	
		Select title = new Select(driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[4]/div[3]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/select[1]")));
		title.selectByVisibleText("Mrs");
		
		//first name and middle name
		driver.findElement(By.xpath("//input[@placeholder='First & Middle Name']")).sendKeys("Pragati");
		//last name
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Patel");
		//next form
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[4]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/*[1]")).click();
		//mrs
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[4]/div[3]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/select[1]")).click();
		//first namr
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[4]/div[3]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys("Raju");
		//Last name
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[4]/div[3]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys("kumar");
		//gmail
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("pragatipatel71@gmail.com");
		//phone
		driver.findElement(By.xpath("//input[@placeholder='Mobile No']")).sendKeys("9480020474");
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[5]/div[1]/button[2]")).click();
		//proceed
	    driver.findElement(By.xpath("//button[normalize-space()='Proceed']")).click();
	}

}
