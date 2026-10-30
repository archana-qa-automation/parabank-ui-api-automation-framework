package src.test.java.com.archana.parabank.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static void takeScreenshot(
	        WebDriver driver, String testName) throws IOException {

	    Path folder = Paths.get("screenshots").toAbsolutePath();
	    Files.createDirectories(folder);

	    System.out.println("Screenshot folder: " + folder);

	    String timestamp = LocalDateTime.now().format(
	            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

	    File source = ((TakesScreenshot) driver)
	            .getScreenshotAs(OutputType.FILE);

	    Path destination = folder.resolve(
	            testName + "_" + timestamp + ".png");

	    Files.copy(source.toPath(), destination);

	    System.out.println("Screenshot saved: " + destination);
	}
}