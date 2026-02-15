package org.pojos;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagePojo extends BaseClass {

	public HomePagePojo() {

	}

	@FindBy(xpath = "(//button[@class='action-close'])[3]")
	private WebElement freeBanner;
	
	
	
	
	

}
