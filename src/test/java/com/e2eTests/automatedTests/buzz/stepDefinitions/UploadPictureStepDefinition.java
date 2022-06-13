package com.e2eTests.automatedTests.buzz.stepDefinitions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.e2eTests.automatedTests.buzz.pageObjects.UploadPicturePageObject;
import com.e2eTests.automatedTests.utils.CommonMethods;
import com.e2eTests.automatedTests.utils.Setup;
import cucumber.api.java.en.*;

public class UploadPictureStepDefinition {
	public WebDriver driver = null;
	private UploadPicturePageObject uploadPage = new UploadPicturePageObject();
	private CommonMethods common = new CommonMethods();

	public UploadPictureStepDefinition() {
		driver = Setup.driver;
		PageFactory.initElements(driver, UploadPicturePageObject.class);
	}

	@When("^Je clique sur le menu Uplaod images$")
	public void jeCliqueSurLeMenuUplaodImages() throws Throwable {
		
		List<WebElement> list = driver.findElements(By.tagName("img"));
		//int count = 1;
		for(WebElement element : list) {
			String src = element.getAttribute("src");
			System.out.println("xxxxxxxxxx  " +src);
			URL imageURL = new URL(src);
			BufferedImage saveImage = ImageIO.read(imageURL);
			
			ImageIO.write(saveImage, "jpg", new File(".jpeg"));
			
			//count ++;
		}
		
		
		//uploadPage.navigateToUploadPicture();
		//Thread.sleep(5000);
	}

	@When("^Je clique sur le boutton Upload images$")
	public void jeCliqueSurLeBouttonUploadImages() throws Throwable {
		uploadPage.ulpoadPicture();
		//Thread.sleep(10000);
	}

	@When("^Je saisis un message \"([^\"]*)\" dans le champ say something about these photos$")
	public void jeSaisisUnMessageDansLeChampSaySomethingAboutThesePhotos(String picturePostText) throws Throwable {
		//Thread.sleep(5000);
		//uploadPage.fillPostPicture(picturePostText);
	}

	@When("^Je clique sur le boutton Post-picture$")
	public void jeCliqueSurLeBouttonPost() throws Throwable {
		//Thread.sleep(5000);
		//uploadPage.clickOnPost();
		//Thread.sleep(5000);
	}

	@Then("^Je verifie si le message \"([^\"]*)\" et l'image sont bien parmis la liste des upload images$")
	public void jeVerifieSiLeMessageEtLImageSontBienParmisLaListeDesUploadImages(String picturePostText) throws Throwable {
		common.refreshNavigator();
		//Assert.assertEquals(picturePostText, uploadPage.findMypostInTheListOfPosts(picturePostText));
		//Assert.assertTrue(uploadPage.verifyMyPictureIsDisplayed());
	}
}
