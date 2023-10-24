package org.stepdefinition;

import org.bas.BaseClass;
import org.poj.FlipkartPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlipkartLogin extends BaseClass {
		 

		@Given("To Launch the Chrome Browser and maximize the window")
		public void to_Launch_the_Chrome_Browser_and_maximize_the_window() {
		    launchBrowser();
		    windowMaxi();
		}

		@When("To Launch the url of the Flipkart application")
		public void to_Launch_the_url_of_the_Flipkart_application() {
		    launchUrl("https://www.flipkart.com/");
		}

		@When("To pass user email id in email field")
		public void to_pass_user_email_id_in_email_field() throws InterruptedException {
			FlipkartPojo f = new FlipkartPojo();
			f.getClick();
			Thread.sleep(3000);
			passText("aarthi1399@gmail.com", f.getEmail());
		    
		}

		@When("To click the Send OTP button")
		public void to_click_the_Send_OTP_button() {
			FlipkartPojo f = new FlipkartPojo();
			f.getOtp();
		    
		}

		@When("To check whether it navigates to homepage or not")
		public void to_check_whether_it_navigates_to_homepage_or_not() {
		    System.out.println("Enter your otp to login");
		}

		@Then("To close the browser")
		public void to_close_the_browser() {
		   closeEntirebrowser();
		}


}
