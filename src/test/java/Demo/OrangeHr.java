package Demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.time.Duration;


public class OrangeHr {
	
	public static void main(String[] args) throws InterruptedException { 
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.get("https://www.google.com");
		Thread.sleep(3000) ;

		driver.get("https://mockdev.maxlifeinsurance.com");
		Thread.sleep(10000);
		
	
		driver.close();
	}

}
