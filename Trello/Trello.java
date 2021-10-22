package Trello;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import POM_And_PF_Trello.Add_Card;
import POM_And_PF_Trello.Add_List;
import POM_And_PF_Trello.Create_Board;
import POM_And_PF_Trello.Login_Page;

public class Trello 
{
	WebDriver driver;

	@Test(priority = 1)
	public void LoadUrl()
	{
		System.setProperty("webdriver.chrome.driver", "/home/qq379/Selenium/chromedriver");

		driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://trello.com/login");
	}

	@Test(priority = 2)
	public void Login_Trello()
	{
		PageFactory.initElements(driver, Login_Page.class);

		Login_Page.Microsoft.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Login_Page.Email.sendKeys("divyangowda98@gmail.com");

		Login_Page.Next.click();

		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("passwd")));
		Login_Page.Password.sendKeys("Divya@123");

		Login_Page.Sign_in.click();

		Login_Page.Save_Info.click();
	}

	@Test(priority = 3)
	public void Create_Boards() throws InterruptedException
	{
		PageFactory.initElements(driver, Create_Board.class);

		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Create new board')]")));
		Create_Board.create_board.click();

		Create_Board.add_board.sendKeys("Qapitol_QA");

		Thread.sleep(2000);

		Create_Board.Create.click();
	}

	@Test(priority = 4)
	public void AddList() throws InterruptedException
	{
		PageFactory.initElements(driver, Add_List.class);


		Add_List.Another_List.click();

		Add_List.List_Name.sendKeys("Project");

		Add_List.add_list.click();

	}

	@Test(priority = 5)
	public void AddCard()
	{
		PageFactory.initElements(driver, Add_Card.class);

		Add_Card.addcard.click();

		Add_Card.titlecard.sendKeys("Employees");


		driver.close();
		driver.quit();


	}
}








