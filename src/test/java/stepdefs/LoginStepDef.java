package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

	WebDriver driver = Hooks.driver;
	
	@Given("I have launched the application")
	public void i_have_launched_the_application() 
	{
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
	    
	}

	@When("I enter the correct username and password")
	public void i_enter_the_correct_username_and_password() 
	{
	    WebElement username = driver.findElement(By.name("user_login"));
	    username.sendKeys("abc@xyz.com");
	    
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("Test@1234");
	}

	@Then("I should land on the home page")
	public void i_should_land_on_the_home_page() 
	{
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("I enter the incorrect username and password")
	public void i_enter_the_incorrect_username_and_password() 
	{
		WebElement username = driver.findElement(By.name("user_login"));
	    username.sendKeys("abc@xyz.com");
	    
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("Test@1234");
	    
	}

	@Then("I should get the error message {string}")
	public void i_should_get_the_error_message(String expError) 
	{
		WebElement Error = driver.findElement(By.id("msg_box"));
		String ActError = Error.getText();
	    
		Assert.assertEquals(expError, ActError);
	}
	
	@And("I click on the Login Link")
	public void i_click_on_the_Login_Link()
	{
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
	}
	
	@And("I click on the Login Button")
	public void i_click_on_the_Login_Button()
	{
		WebElement loginBtn = driver.findElement(By.name("btn_login"));
		loginBtn.click();
	}
	
	@When("I enter the username as {string} and password as {string}")
	public void i_enter_the_username_as_and_password_as(String usernameVal, String passwordVal) {
		WebElement username = driver.findElement(By.name("user_login"));
	    username.sendKeys(usernameVal);
	    
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys(passwordVal);
	}
}
