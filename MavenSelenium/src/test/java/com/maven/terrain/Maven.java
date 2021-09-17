package com.maven.terrain;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Maven {
	   ExtentSparkReporter reporter;
	   ExtentReports extent;
	   
	   @BeforeSuite
	   public void setUp() {
	    reporter = new ExtentSparkReporter("myreport.html");
	    extent = new ExtentReports();
	    extent.attachReporter(reporter);
	}
	     @Test
		 public void TestMethod() {
	    	 ExtentTest test = extent.createTest("My first test");
	    	 test.log(Status.INFO, "This shows info");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\sarfaraja\\eclipse-SeleniumProject\\seleniumProject\\drivers\\geckodriver.exe");
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.google.com");
		 driver.manage().window().maximize();
		 String title = driver.getTitle();
		 System.out.println(title);
		 //driver.findElement(By.xpath(title="//input[@name=\"q\"]").sendKeys("Maveric"))
		 WebElement searchBox = driver.findElement(By.name("q"));
		 searchBox.sendKeys("Maveric");
		 searchBox.submit();
		 //searchBox.click();
		
		 driver.quit();
	 }
	     @AfterSuite
		 public void tearDown() {
		 extent.flush();
		 }
	     
}