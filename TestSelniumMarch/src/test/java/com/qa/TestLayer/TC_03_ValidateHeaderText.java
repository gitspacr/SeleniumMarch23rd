package com.qa.TestLayer;

import org.testng.annotations.Test;

import com.qa.Pages.BasicControl;
import com.qa.TestBase.TestBaseClass;

public class TC_03_ValidateHeaderText extends TestBaseClass{
	
	@Test
	public void validateRegisterForm() throws Exception {
		
		BasicControl bc=new BasicControl(driver);
		bc.validateHeaderText();
		screenshot(driver, "headerText");
		log.info("registration form is cleared");
		
	}
	

}
