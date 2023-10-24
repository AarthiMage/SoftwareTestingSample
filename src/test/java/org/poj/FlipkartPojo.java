package org.poj;

import org.bas.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPojo extends BaseClass {

	public FlipkartPojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Sign in']")
	private WebElement click;

	@FindBy(xpath = "//input[@class='_18u87m _3WuvDp']") 
	private WebElement email;
	
	@FindBy(xpath = "//button[@class='_1wGnMD rX1XT4 _2nD2xJ']")
	private WebElement otp;

	public WebElement getClick() {
		return click;
	}

	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getOtp() {
		return otp;
	}

}

