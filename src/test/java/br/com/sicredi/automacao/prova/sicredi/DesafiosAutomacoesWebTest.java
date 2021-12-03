package br.com.sicredi.automacao.prova.sicredi;

import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Desafio Automacao 1
public class DesafiosAutomacoesWebTest {

	private WebDriver driver;

	private static void timeSleep(int miliSeg){
		try{
			Thread.sleep(miliSeg);
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
	}

	@Test
	public void test() {
		//vars
		String siteUrl               = "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap";
		String buttonBootStrap1Xpath = "//*[@id=\"switch-version-select\"]";
		String buttonBootStrap2Xpath = "/html/body/div[1]/select/option[4]";
		String buttonAddRecordXpath  = "/html/body/div[2]/div[2]/div[1]/div[2]/form/div[1]/div[1]/a";
		String buttonSaveId          = "form-button-save";

		//varsPut
		String inputNameId           = "field-customerName";
		String inputLastNameId       = "field-contactLastName";
		String inputFistNameId       = "field-contactFirstName";
		String inputPhoneId          = "field-phone";
		String inputAdressLine1Id    = "field-addressLine1"; 
		String inputAdressLine2Id    = "field-addressLine2";
		String inputCityId           = "field-city";
		String inputStateId          = "field-state";
		String inputPostalCodeId     = "field-postalCode";
		String inputCoutryId         = "field-country";
		String inputEmployeeNumberId = "field-salesRepEmployeeNumber";
		String inputCreditLimitId    = "field-creditLimit";
		String inputDeletedId        = "field-deleted";

		//values
		String name             = "Teste Sicredi";
		String lastName         = "Teste";
		String contactFirstName = "seu nome";
		String phone            = "51 9999-9999";
		String addressLine1     = "Av Assis Brasil, 3970";
		String addressLine2     = "Torre D";
		String city             = "Porto Alegre";
		String state            = "RS";
		String postalCode       = "91000-000";
		String country          = "Brasil";
		String fromEmployeer    = "Fixter";
		String creditLimit      = "200";

		//bot
		Scanner myObj = new Scanner(System.in);
		System.out.println("Automacao iniciada, testando: https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
		System.out.println("outomatisering begin, testing: https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
		System.setProperty("webdriver.gecko.driver","Driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get(siteUrl);
		driver.findElement(By.xpath(buttonBootStrap1Xpath)).click();
		driver.findElement(By.xpath(buttonBootStrap2Xpath)).click();//.sendKeys(usersearch + Keys.ENTER); //name locator for text box
		driver.findElement(By.xpath(buttonAddRecordXpath)).click();
		driver.findElement(By.id(inputNameId)).sendKeys(name);
		driver.findElement(By.id(inputLastNameId)).sendKeys(lastName);
		driver.findElement(By.id(inputFistNameId)).sendKeys(contactFirstName);
		driver.findElement(By.id(inputPhoneId)).sendKeys(phone);
		driver.findElement(By.id(inputAdressLine1Id)).sendKeys(addressLine1);
		driver.findElement(By.id(inputAdressLine2Id)).sendKeys(addressLine2);
		driver.findElement(By.id(inputCityId)).sendKeys(city);
		driver.findElement(By.id(inputStateId)).sendKeys(state);
		driver.findElement(By.id(inputPostalCodeId)).sendKeys(postalCode);
		driver.findElement(By.id(inputCoutryId)).sendKeys(country);
		driver.findElement(By.id(inputEmployeeNumberId)).sendKeys(fromEmployeer);
		driver.findElement(By.id(inputCreditLimitId)).sendKeys(creditLimit);

		driver.findElement(By.id(buttonSaveId)).click();
		timeSleep(4000);

		//assertion
		String result = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]/p")).getText();
		assertEquals("Your data has been successfully stored into the database. Edit Record or Go back to list", result);


//Desafio automacao 2

		//vars2
		String linkBackListXpath     = "/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]/p/a[2]";
		String inputSearchName       = "/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[3]/input";
		String checkBoxActinosXpath  = "/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[1]/div/input";
		String buttonDeleteXpath     = "/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[2]/div[1]/a";
		String pupUpOkXpath          = "/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]";
		String textAreYouSureXpath   = "/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[1]";
		String pupUP2                = "/html/body/div[3]/span[3]/p"; 

		//bot2
		driver.findElement(By.xpath(linkBackListXpath)).click();
		driver.findElement(By.xpath(inputSearchName)).sendKeys(name);
		driver.findElement(By.xpath(checkBoxActinosXpath)).click();
		driver.findElement(By.xpath(buttonDeleteXpath)).click();

		//assertion2
		String assertion2 = driver.findElement(By.xpath(textAreYouSureXpath)).getText();
		assertEquals("Are you sure that you want to delete those 10 items?",assertion2);

		driver.findElement(By.xpath(pupUpOkXpath)).click();

		timeSleep(1000);

		//assertion3
		String assertion3 = driver.findElement(By.xpath(pupUP2)).getText();
		assertEquals("Your data has been successfully deleted from the database.",assertion3);


		timeSleep(1000);
		driver.quit();
		driver.close();
		
	}

}
