package soaltest_selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SoalNoTiga {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		

//		inisiasi web driver
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		List<WebElement> JumlahData;
		List<WebElement> Tittle;

//		Open website
		driver.manage().window().maximize();
		String url = "https://www.tokopedia.com/";
		driver.get(url);
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);

//		Melakukan pencarian
		driver.findElement(By.xpath("//input[contains(@placeholder,'Cari')]")).sendKeys("sepatu kulit pria", Keys.ENTER);
		
//		Melakukan scroll
		js.executeScript("window.scrollBy(0,700)");
		
//		Mencari jumlah produk
		JumlahData = driver.findElements(By.xpath("//div[@class='css-974ipl']//a[@class='pcv3__info-content css-gwkf0u']"));
	
		for(WebElement jml : JumlahData) {
			String tittle = jml.getText();
			System.out.println(tittle);
		}
		
		System.out.println("Jumlah Data = " + JumlahData.size());
		
		
		delay(5);
		driver.quit();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(detik * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
