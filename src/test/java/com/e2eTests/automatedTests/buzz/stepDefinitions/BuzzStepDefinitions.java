package com.e2eTests.automatedTests.buzz.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.e2eTests.automatedTests.buzz.pageObjects.BuzzPageObjects;
import com.e2eTests.automatedTests.utils.CommonMethods;
import com.e2eTests.automatedTests.utils.Setup;
import cucumber.api.java.en.*;

public class BuzzStepDefinitions {

	public WebDriver driver = null;
	private BuzzPageObjects buzzPage = new BuzzPageObjects();
	private CommonMethods common = new CommonMethods();
	public BuzzStepDefinitions() {
		driver = Setup.driver;
		PageFactory.initElements(driver, BuzzPageObjects.class);
	}
	
	@When("^je clique sur le menu buzz$")
	public void jeCliqueSurLeMenuBuzz() throws Throwable {
		buzzPage.navigateToBuzzMenu();
	}

	@When("^je saisis le message \"([^\"]*)\"$")
	public void jeSaisisLeMessage(String myPost) throws Throwable {
		buzzPage.putMyPostIntheField(myPost);
	}

	@When("^je clique sur le boutton post$")
	public void jeCliqueSurLeBouttonPost() throws Throwable {
		buzzPage.submitMyPost();
	}

	@Then("^je verife que mon post est bien afficher \"([^\"]*)\"$")
	public void jeVerifeQueMonPostEstBienAfficher(String myPost) throws Throwable {
		common.refreshNavigator();
		Assert.assertEquals(buzzPage.findMypostInTheListOfPosts(myPost), myPost);
	}
}