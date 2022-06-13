package com.e2eTests.automatedTests.buzz.pageObjects;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.e2eTests.automatedTests.utils.CommonMethods;

public class UploadPicturePageObject {

	/* Locators */
	final static String MENU_UPLOAD_PICTURE_ID = "images-tab-label";
	final static String POST_PICTURE_TEXT_FIELD_ID = "phototext";
	final static String BUTTON_SUBMIT_PICTURE_ID = "imageUploadBtn";
	final static String POST_CLASS_NAME = "postContent";
	final static String PICTURE_CLASS_NAME = "postPhoto";
	final static String BUTTON_UPLOAD_PICTURE_ID = "image-upload-button";

	/* @FindBy */
	@FindBy(how = How.ID, using = MENU_UPLOAD_PICTURE_ID)
	public static WebElement menuUploadPicture;
	@FindBy(how = How.ID, using = POST_PICTURE_TEXT_FIELD_ID)
	public static WebElement myPictureTextField;
	@FindBy(how = How.ID, using = BUTTON_SUBMIT_PICTURE_ID)
	public static WebElement sumbitPicture;
	@FindBy(how = How.CLASS_NAME, using = POST_CLASS_NAME)
	public static List<WebElement> listOfPosts;
	@FindBy(how = How.CLASS_NAME, using = PICTURE_CLASS_NAME)
	public static List<WebElement> listOfPictures;
	@FindBy(how = How.ID, using = BUTTON_UPLOAD_PICTURE_ID)
	public static WebElement uploadPictureButton;

	private CommonMethods common = new CommonMethods();
	//private CompareImage compare = new CompareImage();

	public void navigateToUploadPicture() {
		menuUploadPicture.click();
	}

	public void fillPostPicture(String myPostPictureTxt) {
		myPictureTextField.sendKeys(myPostPictureTxt);
	}

	public void ulpoadPicture() throws Throwable{
		//uploadPictureButton.click();
		//common.uploadFileWithRobot();
		common.downloadImage(listOfPictures);

	}

	public void clickOnPost() {
		sumbitPicture.click();
	}

	/*public boolean verifyMyPictureIsDisplayed() throws IOException {
		boolean pictureDisplay = false;
		for (WebElement pic : listOfPictures) {
			if (common.compareTwoPicture(pic) == true)
				pictureDisplay = true;
			break;
		}
		return pictureDisplay;

	}*/
	

	public String findMypostInTheListOfPosts(String myPost) {

		String myPostIntheListOfPosts = null;
		for (WebElement post : listOfPosts) {
			if (post.getText().equalsIgnoreCase(myPost)) {
				myPostIntheListOfPosts = post.getText();
				break;
			}
		}
		return myPostIntheListOfPosts;
	}
}
