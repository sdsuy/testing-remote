package io.spring.testingremote;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestingConsoleApptimTests {

	WebDriver driver;
	
	@BeforeEach
	void setUp() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Spring\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://console.apptim.com");
		Thread.sleep(3000);  // Let the user actually see something!
	    
	}

	@Test
	void loginTitleTest() {

	    String actualTitle = driver.getTitle();
	    String expectedTitle = "Apptim - Log in";
	    assertThat(actualTitle, equalToIgnoringCase(expectedTitle));
		
	}
	
	@Test
	void signInHeadingTest() {

	    String actualHeading = driver.findElement(By.cssSelector("h2")).getText();
	    String expectedHeading = "Sign in to continue";
	    assertThat(expectedHeading, equalToIgnoringCase(actualHeading));
		
	}
	
	@AfterEach
	void closeUp() {
		
		driver.quit();
		
	}

}
