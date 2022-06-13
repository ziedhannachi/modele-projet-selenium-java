package com.e2eTests.automatedTests.buzz.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BuzzPageObjects {

	/* Locators */
	final static String MENU_BUZZ_ID = "menu_buzz_viewBuzz";
	final static String MESSAGE_FIELD_ID = "createPost_content";
	final static String BUTTON_SUBMIT_POST_ID = "postSubmitBtn";
	final static String POST_CLASS_NAME = "postContent";

	/* @FindBy */
	@FindBy(how = How.ID, using = MENU_BUZZ_ID)
	public static WebElement menuBuzz;
	@FindBy(how = How.ID, using = MESSAGE_FIELD_ID)
	public static WebElement myPostField;
	@FindBy(how = How.ID, using = BUTTON_SUBMIT_POST_ID)
	public static WebElement sumbitPost;
	@FindBy(how = How.CLASS_NAME, using = POST_CLASS_NAME)
	public static List<WebElement> listofPosts;

	public void navigateToBuzzMenu() {
		menuBuzz.click();
	}

	public void putMyPostIntheField(String myPost) {
		myPostField.sendKeys(myPost);
	}

	public void submitMyPost() {
		sumbitPost.click();
	}

	public String findMypostInTheListOfPosts(String myPost){
		
			String myPostIntheListOfPosts = null;
		for (WebElement post : listofPosts) {
			if (post.getText().equalsIgnoreCase(myPost)) {
				myPostIntheListOfPosts = post.getText();
				break;
			}
		}
		return myPostIntheListOfPosts;
	}
}
