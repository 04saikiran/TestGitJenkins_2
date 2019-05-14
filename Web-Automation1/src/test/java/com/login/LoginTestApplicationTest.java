package com.login;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LoginTestApplicationTest {

	WebDriver driver;
	public String url = "";
	public String verificationError = "";

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "D:\\PracticeSelenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		url = "http://demo.automationtesting.in/";
	}

	@Test
	public void loginVerification() {
		try {
			driver.get(url);
			driver.findElement(By.id("email")).sendKeys("saikiran@gmail.com");
			driver.findElement(By.id("enterimg")).click();
			String title = driver.getTitle();
			if(title.equals("Register")) {
				System.out.println("Title matched hence pass");
			}else {
				System.out.println("Title not matche failed");
			}	
		}catch(Exception e) {
			System.out.println(e.getMessage());
			verificationError = e.getMessage();
		}
		
	}
	@AfterMethod
	public void tierDown() {
		driver.quit();
		if(!verificationError.equals("")) {
			Assert.fail();
		}
	}
}
