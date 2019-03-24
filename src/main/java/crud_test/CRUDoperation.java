package crud_test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.dataReader;

public class CRUDoperation {

	public WebDriver driver;
	dataReader datareaderobj;

	@BeforeTest

	public void setup() {

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");

		driver=new ChromeDriver();
		driver.get("https://codepen.io/SedatUygur/pen/jWgJdv");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void CreateRecipe() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		datareaderobj = new dataReader();
		datareaderobj.readData();

		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='result-iframe']")));
		driver.findElement(By.xpath(".//div[@id='button']//button[@id='show']")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("title")).sendKeys(datareaderobj.AddReceipeName);
		driver.findElement(By.id("ingredients")).sendKeys(datareaderobj.AddIngredients);
		driver.findElement(By.id("addButton")).click();
		Thread.sleep(3000);

		String title = driver.findElement(By.xpath(".//div[@role='tablist']//div[4]//a")).getText();
		System.out.println(title);

		Assert.assertEquals(title, datareaderobj.AddReceipeName);

	}

	@Test(priority = 2)
	public void EditRecipe() throws FileNotFoundException, IOException, ParseException, InterruptedException {

		datareaderobj = new dataReader();
		datareaderobj.readData();

		driver.findElement(By.xpath(".//div[@role='tablist']//div[4]//a")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-edit3")));

		driver.findElement(By.id("btn-edit3")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys(datareaderobj.EditReceipeName);
		driver.findElement(By.id("ingredients")).clear();
		driver.findElement(By.id("ingredients")).sendKeys(datareaderobj.EditIngredients);
		driver.findElement(By.id("addButton")).click();
		Thread.sleep(3000);

		String title = driver.findElement(By.xpath(".//div[@role='tablist']//div[4]//a")).getText();
		System.out.println(title);

		Assert.assertEquals(title, datareaderobj.EditReceipeName);


	}

	@Test(priority = 3)
	public void DeleteRecipe() throws FileNotFoundException, IOException, ParseException, InterruptedException{

		datareaderobj = new dataReader();
		datareaderobj.readData();

		String title = driver.findElement(By.xpath(".//div[@role='tablist']//div[4]//a")).getText();		
		driver.findElement(By.id("btn-del3")).click();
		Assert.assertFalse(false, title);
		Thread.sleep(3000);


	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
