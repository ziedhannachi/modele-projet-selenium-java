package com.e2eTests.automatedTests.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CommonMethods {
	public static String filePath = "C:\\Users\\oussemarebai\\Desktop\\formation\\tunisie.jpg";
	public static String dowloadFolderPath = "C:\\Users\\oussemarebai\\Desktop\\screenshot\\";

	public CommonMethods() {
		driver = Setup.driver;
	}

	public static WebDriver driver;
	public static Properties prop;

	public void readFileConfig() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/configs/config.properties");
		prop.load(fis);
		driver.get(prop.getProperty("url"));
	}

	public void refreshNavigator() {
		driver.navigate().refresh();
	}

	public void uploadFileWithRobot() {
		StringSelection stringSelection = new StringSelection(filePath);
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(stringSelection, null);

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void assertIsDisplayed(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
	}

	public boolean compareTwoPicture(WebElement element) throws IOException {
		boolean compare = false;
		BufferedImage expectedImage = ImageIO.read(new File(filePath));
		Screenshot logoImageScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver, element);
		BufferedImage actualImage = logoImageScreenshot.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		if (diff.hasDiff() == false) {
			compare = true;
		}
		return compare;
	}

	public void downloadImage(List<WebElement> list) {
		URL imageURL;
		int picRef = 0;
		for (WebElement pic : list) {
			try {

				imageURL = new URL(pic.getAttribute("src"));
				System.out.println(imageURL);
				BufferedImage imagedsave = ImageIO.read(imageURL);
				if (imagedsave != null) {
					ImageIO.write(imagedsave, "jpg", new File(dowloadFolderPath + picRef));
					picRef++;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	

	
	public void getImage() throws IOException {
		
		List<WebElement> list = driver.findElements(By.tagName("img"));;
		for(WebElement element : list) {
			String src = element.getAttribute("src");
			System.out.println(src);
			URL imageURL = new URL(src);
			BufferedImage saveImage = ImageIO.read(imageURL);
			
			ImageIO.write(saveImage, "jpg", new File(".jpeg"));
		}
		
	}
}
