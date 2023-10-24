package org.stepdefinition;

import java.util.List;

import org.bas.BaseClass;
import org.poj.AmazonPojo;
import io.cucumber.datatable.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonLogin extends BaseClass{
    AmazonPojo a = new AmazonPojo();
	
	
	@Given("To Launch the Chrome Browser and maximize the window")
	public void to_Launch_the_Chrome_Browser_and_maximize_the_window() {
	   launchBrowser();
	   windowMaxi();
	}

	@When("To Launch the url of the Amazon application")
	public void to_Launch_the_url_of_the_Amazon_application() {
	  launchUrl("https://www.amazon.in/");
	}

	@When("To pass user email id in email field")
	public void to_pass_user_email_id_in_email_field() {
		a = new AmazonPojo();
		ClickEle(a.getSignin());
	    passText("aarthi1399@gmail.com", a.getEmail());
	}

	@When("To click the email field")
	public void to_click_the_email_field(DataTable d) throws InterruptedException {
	Thread.sleep(2000);
	List<String> l = d.asList();
	   a = new AmazonPojo();
	   passText(l.get(0), a.getEmail());
	   ClickEle(a.getEclick());
	    
	}

	@When("To pass user password in password field")
	public void to_pass_user_password_in_password_field(DataTable d) {
		List<List<String>> l = d.asLists();
	    a = new AmazonPojo();
	    passText(l.get(0).get(2), a.getPass());
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
	    a  = new AmazonPojo();
	    ClickEle(a.getPassclick());
	}

	@When("To check whether it navigates to home page or not")
	public void to_check_whether_it_navigates_to_home_page_or_not() {
	  System.out.println("Check it moves to home page!");
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
	   closeEntirebrowser();
	}


}
