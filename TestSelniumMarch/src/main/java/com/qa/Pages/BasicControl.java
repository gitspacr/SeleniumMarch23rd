package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBaseClass;

public class BasicControl extends TestBaseClass {

	WebDriver driver;

	@FindBy(id = "firstName")
	WebElement firstname;

	@FindBy(name = "lName")
	WebElement lastname;

	@FindBy(id = "femalerb")
	WebElement femalerdbtn;

	@FindBy(id = "chinesechbx")
	WebElement chCheckBox;

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(name = "psw")
	WebElement password;

	@FindBy(id = "clearbtn")
	WebElement clearBtn;
	
	@FindBy (id="navigateHome")
	WebElement linktext;
	
	@FindBy (xpath="//h1[@itemprop='name']")
	WebElement txtVal;
	

	public BasicControl(WebDriver ldriver) {
		
		driver=ldriver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void registrationForm() throws Exception {
		firstname.sendKeys("Peter");
		Thread.sleep(3000);
		lastname.sendKeys("Sam");
		femalerdbtn.click();
		chCheckBox.click();
		Thread.sleep(3000);
		emailId.sendKeys("abc@test.com");
		password.sendKeys("password1");
		screenshot(driver, "ClearRegisterForm");
		Thread.sleep(3000);
		clearBtn.click();

	}
	
	
	public void validateLinkText() {
		linktext.click();
		
	}
	
	public void validateHeaderText() {
		String val=txtVal.getText();
		log.info(val);
		
	}

}
