package com.qa.TestLayer;

import org.testng.annotations.Test;

import com.qa.Pages.BasicControl;
import com.qa.TestBase.TestBaseClass;

public class TC_01_RegistrationForm extends TestBaseClass{
	
	@Test
	public void validateRegisterForm() throws Exception {
		
		BasicControl bc=new BasicControl(driver);
		bc.validateLinkText();
		screenshot(driver, "LinkTextPage");
		log.info("registration form is cleared");
		
	}
	

}
