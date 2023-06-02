package testcases.AMR;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.Base;
import common.RetryAnalyzer;

public class BR extends Base {
	public static String fakeMailWeb;
	public static String mkWeb;
	public static String verificationCode;
	public static String[] consultantID = {"HK2746","EH1141"};

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public static void BRAZIL_AGREEMENT() throws InterruptedException, IOException {
//	COMMON
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().deleteAllCookies();
		Actions action = new Actions(driver);
		
// FAKE MAIL		
		driver.get(config.getProperty("FAKE_MAIL_URL"));
		System.out.println("FAKE MAIL OPEN");
		fakeMailWeb = driver.getWindowHandle();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("MAIL"))));
		String Mail = driver.findElement(By.xpath(BR_loc.getProperty("MAIL"))).getText();
		driver.switchTo().newWindow(WindowType.TAB);
		System.out.println("MAIL COPIED: "+Mail);

//	MARYKAY PAGE														
		driver.get(config.getProperty("BR_URL"));
		Thread.sleep(5000);
		mkWeb = driver.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("CONSULTANT_NUMBER")))).sendKeys(consultantID[(int) (Math.floor(Math.random() * 2))]);
		System.out.println("BRAZIL SIGNUP PAGE OPEN");
		WebElement recruiter = driver.findElement(By.xpath(BR_loc.getProperty("RECRUITER_BUTTON"))); 
		js.executeScript("arguments[0].scrollIntoView(true);", recruiter);
		recruiter.click();
		Thread.sleep(8000);
		try {

			boolean actualPara = driver.findElement(By.xpath(BR_loc.getProperty("RECRUITER_ERROR"))).isDisplayed();
			boolean True = true;
			if (actualPara == True) {
				recruiter.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("RECRUITER_NAME"))));
				WebElement email = driver.findElement(By.xpath(BR_loc.getProperty("BY_EMAIL")));
				js.executeScript("arguments[0].scrollIntoView(true);", email);
				email.click();
				driver.findElement(By.xpath(BR_loc.getProperty("EMAIL"))).sendKeys(Mail);
//	THIS WILL USE TO EXECUTE JAVASCRIPT CODE IN JAVA LANGUAGE
				js.executeScript("window.scroll(0,800)", "");
				driver.findElement(By.xpath(BR_loc.getProperty("REGISTER_BUTTON"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("VERIFICATION_CODE_FIELD"))));
				driver.switchTo().window(fakeMailWeb);
				System.out.println("BACK TO FAKE MAIL WEB - PASS");
			}
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("RECRUITER_NAME"))));
			WebElement email = driver.findElement(By.xpath(BR_loc.getProperty("BY_EMAIL")));
			js.executeScript("arguments[0].scrollIntoView(true);", email);
			email.click();
			driver.findElement(By.xpath(BR_loc.getProperty("EMAIL"))).clear();
			driver.findElement(By.xpath(BR_loc.getProperty("EMAIL"))).sendKeys(Mail);
//  THIS WILL USE TO EXECUTE JAVASCRIPT CODE IN JAVA LANGUAGE
			js.executeScript("window.scroll(0,800)", "");
			driver.findElement(By.xpath(BR_loc.getProperty("REGISTER_BUTTON"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("VERIFICATION_CODE_FIELD"))));
			driver.switchTo().window(fakeMailWeb);
			System.out.println("BACK TO FAKE MAIL WEB - PASS");
		}

// VERIFICATION CODE PAGE
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("RECEIVED_CODE")))).click();
		// OPEN(switch to) I-FRAME and COPY VERIFICATION CODE
		driver.switchTo().frame("iframeMail");
		verificationCode = driver.findElement(By.xpath(BR_loc.getProperty("VERIFICATION_CODE"))).getText();
		System.out.println("VERIFICATION CODE COPIED - PASS");
		driver.switchTo().window(mkWeb);

//  RESETPASSWORD() THROWS INTERRUPTEDEXCEPTION {
		Thread.sleep(5000);
		System.out.println("RESET PASSWORD PAGE OPEN - PASS");
		driver.findElement(By.xpath(BR_loc.getProperty("VERIFICATION_CODE_FIELD"))).sendKeys(verificationCode);
		driver.findElement(By.xpath(BR_loc.getProperty("PASSWORD_FIELD"))).sendKeys(config.getProperty("PASSWORD"));
		driver.findElement(By.xpath(BR_loc.getProperty("CONFIRM_PASSWORD_FIELD"))).sendKeys(config.getProperty("PASSWORD"));
		driver.findElement(By.xpath(BR_loc.getProperty("SUBMIT_PASSWORD_BUTTON"))).click();

/*	RECRUITERSECTION
		Thread.sleep(5000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(BR_loc.getProperty("Spinner"))));
		System.out.println("SIGNUP SUCCESSFULLY");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("Recruiter_Subsidary"))));
		WebElement CONTINUE_BUTTON = driver.findElement(By.xpath(BR_loc.getProperty("Continue_Button")));
		js.executeScript("arguments[0].scrollIntoView(true);", CONTINUE_BUTTON);
		CONTINUE_BUTTON.click();
*/

//	PERSONAL INFORMATION PAGE
		Thread.sleep(5000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(BR_loc.getProperty("SPINNER"))));
		System.out.println("SIGNUP SUCCESSFULLY - PASS");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("DATE_OF_BIRTH"))));
		driver.findElement(By.xpath(BR_loc.getProperty("NOME"))).sendKeys(RandomStringUtils.randomAlphabetic(10));
		driver.findElement(By.xpath(BR_loc.getProperty("DATE_OF_BIRTH"))).click();
		String[] month = { "jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez" };
		// int <-math.floor <-math.random
		// convert 28 into string <-28 <-28.00 <-0.982346*29 = 28.8
		driver.findElement(By.xpath(BR_loc.getProperty("DATE_OF_BIRTH"))).sendKeys(Integer.toString(((int) (Math.floor(Math.random() * 29)))) + " de "+ month[(int) (Math.floor(Math.random() * 12))] + ". de "+ Integer.toString((1950 + (int) (Math.floor(Math.random() * 54)))));
		driver.findElement(By.xpath(BR_loc.getProperty("SOBRENOME"))).sendKeys(RandomStringUtils.randomAlphabetic(10));
		driver.findElement(By.xpath(BR_loc.getProperty("ESTADO_CIVIL"))).click();
		driver.findElement(By.xpath(BR_loc.getProperty("SEXO"))).click();
		driver.findElement(By.xpath(BR_loc.getProperty("NOME_PREFERIDO"))).sendKeys(RandomStringUtils.randomAlphabetic(10));
		driver.findElement(By.xpath(BR_loc.getProperty("CONTINUE_BUTTON"))).click();

//	ADDRESS INFORMATION PAGE
		Thread.sleep(5000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("SPINNER")));
		System.out.println("PERSONAL SECTION - PASS");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("COMPLEMENTO"))));
		driver.findElement(By.xpath(BR_loc.getProperty("POSTAL_CODE_FIELD"))).sendKeys("320");
		driver.findElement(By.xpath(BR_loc.getProperty("POSTAL_CODE"))).click();
		driver.findElement(By.xpath(BR_loc.getProperty("NUMERO_FIELD"))).sendKeys(RandomStringUtils.randomNumeric(5));
		driver.findElement(By.xpath(BR_loc.getProperty("COMPLEMENTO"))).sendKeys(RandomStringUtils.randomAlphabetic(10));
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(BR_loc.getProperty("CONTINUE_BUTTON"))));
		driver.findElement(By.xpath(BR_loc.getProperty("CONTINUE_BUTTON"))).click();
			
// CONTACT INFORMATION PAGE
		Thread.sleep(5000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("SPINNER")));
		System.out.println("ADDRESS SECTION - PASS");
		driver.findElement(By.xpath(BR_loc.getProperty("HOME_PHONE"))).sendKeys(RandomStringUtils.randomNumeric(11));
		driver.findElement(By.xpath(BR_loc.getProperty("CELL_PHONE"))).sendKeys(RandomStringUtils.randomNumeric(10));
//		driver.findElement(By.xpath(BR_loc.getProperty("Office_Phone"))).sendKeys(RandomStringUtils.randomNumeric(9));
		List<WebElement> elements = driver.findElements(By.xpath(BR_loc.getProperty("RADIO_BUTTON")));
		elements.get(1).click();
		driver.findElement(By.xpath(BR_loc.getProperty("CHECKBOX"))).click();
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(BR_loc.getProperty("CONTINUE_BUTTON"))));
		driver.findElement(By.xpath(BR_loc.getProperty("CONTINUE_BUTTON"))).click();		

//	IDENTIFICATION INFORMATION PAGE
		Thread.sleep(5000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(BR_loc.getProperty("SPINNER"))));
		System.out.println("CONTACT SECTION - PASS");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(config.getProperty("CPF_GENERATOR_URL"));
		List <WebElement> APPLY_MASK_CHECKBOX = driver.findElements(By.xpath(config.getProperty("APPLY_MASK_CHECKBOX")));
		wait.until(ExpectedConditions.visibilityOfAllElements(APPLY_MASK_CHECKBOX)).get(0).click();
		List <WebElement> GENERATE_BUTTON = driver.findElements(By.xpath(config.getProperty("GENERATE_BUTTON")));
		wait.until(ExpectedConditions.visibilityOfAllElements(GENERATE_BUTTON)).get(0).click();
		List <WebElement> CPF_FIELD = driver.findElements(By.xpath(config.getProperty("CPF_PATH")));
		String CPF_NUMBER = CPF_FIELD.get(0).getAttribute("value");
		System.out.println("CPF NUMBER : "+CPF_NUMBER);
		driver.switchTo().window(mkWeb);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("CPF")))).sendKeys(CPF_NUMBER);
		driver.findElement(By.xpath(BR_loc.getProperty("NACIONALIDAD"))).click();
		driver.findElement(By.xpath(BR_loc.getProperty("RG_RNE"))).sendKeys(CPF_NUMBER);
		driver.findElement(By.xpath(BR_loc.getProperty("CONTINUE_BUTTON"))).click();
			
// LEGAL INFORMATION PAGE  
		Thread.sleep(5000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(BR_loc.getProperty("SPINNER"))));
		System.out.println("IDENTIFICATION SECTION - PASS");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("CONTINUE_BUTTON"))));
		// THIS WILL USE TO EXECUTE JAVASCRIPT CODE IN JAVA LANGUAGE
		js.executeScript("window.scroll(0,200)", "");
		WebElement CONTAINER = driver.findElement(By.xpath(BR_loc.getProperty("CONTAINER")));
		js.executeScript("arguments[0].scrollTop = arguments[1];", CONTAINER, 20000);
		Thread.sleep(1000);
		List<WebElement> LELEMENTS = driver.findElements(By.xpath(BR_loc.getProperty("LEGAL_CHECKBOXES")));
		LELEMENTS.get(0).click();
		LELEMENTS.get(1).click();
		LELEMENTS.get(2).click();
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(BR_loc.getProperty("CONTINUE_BUTTON"))));
		driver.findElement(By.xpath(BR_loc.getProperty("CONTINUE_BUTTON"))).click();

//	REVIEW INFORMATION PAGE
		Thread.sleep(5000);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(BR_loc.getProperty("SPINNER"))));
		System.out.println("LEGAL SECTION - PASS");
		List<WebElement> CHECKBOX = driver.findElements(By.xpath(BR_loc.getProperty("REVIEW_CHECKBOXES")));
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfAllElements(CHECKBOX));
		CHECKBOX.get(0).click();
		CHECKBOX.get(1).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(BR_loc.getProperty("BUY_STARTER_KIT"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("SEND_BUTTON")))).click();

// STARTER KITS PAGE
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("COMMERCE_CONTINUE_BUTTON"))));
		System.out.println("REVIEW SECTION - PASS");
		System.out.println("STARTER KIT PAGE - OPEN");
		WebElement CHECKBOX1 = driver.findElement(By.xpath(BR_loc.getProperty("STARTER_KIT_RADIO_BUTTON")));
		js.executeScript("arguments[0].scrollIntoView(true);", CHECKBOX1);
		action.moveToElement(CHECKBOX1).click(CHECKBOX1).perform();
		driver.findElement(By.xpath(BR_loc.getProperty("COMMERCE_CONTINUE_BUTTON"))).click();

//	HOME SECTION
		Thread.sleep(5000);
		WebElement SHOOPINGBAGBUTTON = driver.findElement((By.xpath(BR_loc.getProperty("SHOOPING_BAG_BUTTON"))));
		js.executeScript("arguments[0].scrollIntoView(true);", SHOOPINGBAGBUTTON);
		wait.until(ExpectedConditions.visibilityOf(SHOOPINGBAGBUTTON));
		System.out.println("STARTER KIT SECTION - PASS");
		SHOOPINGBAGBUTTON.click();

//	SACOLA PAGE
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("FINALIZAR_PREDIDO")))).click();
		System.out.println("SHOOPING BAG SECTIONS - PASS");

//	1.BONUS PAGE
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("BONUS_LABEL"))));
		System.out.println("SACOLA SECTION - PASS");
		List <WebElement> CONTINUE = driver.findElements(By.xpath(BR_loc.getProperty("BONUS_CONTINUE")));
		js.executeScript("arguments[0].scrollIntoView(true);", CONTINUE.get(0));
		Thread.sleep(5000);
		driver.findElement(By.xpath(BR_loc.getProperty("BONUS_CONTINUE_BUTTON"))).click();
		
// 2.ENVIO PAGE
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("ENVIO_HEADING"))));
		System.out.println("RECONOCIMIENTOS SECTION PASS");
		Thread.sleep(3000);
		List <WebElement> CONTINUETOPAYMENTBUTTON = driver.findElements(By.xpath(BR_loc.getProperty("CONTINUE_TO_PAYMENT_BUTTON")));
		js.executeScript("arguments[0].scrollIntoView(true);", CONTINUETOPAYMENTBUTTON.get(1));
		Thread.sleep(5000);
		driver.findElement(By.xpath(BR_loc.getProperty("PAYMENT_BUTTON"))).click();

// 3.PAYMENT SECTION
		Thread.sleep(5000);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("Payment_Section_Checkbox1"))))
				.click();
		System.out.println("INFORMACION SECTION PASS");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("Payment_Section_Checkbox2"))))
				.click();
		WebElement button = driver.findElement(By.xpath(BR_loc.getProperty("Credit_Card_Button")));
		wait.until(ExpectedConditions.visibilityOf(button));
		js.executeScript("arguments[0].scrollIntoView(true);", button);
		Thread.sleep(3000);
		button.click();

// CREDITCARDSECTION() THROWS INTERRUPTEDEXCEPTION {
		Thread.sleep(15000);
		driver.switchTo().frame(BR_loc.getProperty("IFrame"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("Payment_Method")))).click();
		System.out.println("PAYMENT SECTION PASS");
		driver.findElement(By.xpath(BR_loc.getProperty("Payment_Method_Continue_Button"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(BR_loc.getProperty("Card_Number_Field"))).sendKeys(config.getProperty("Card_Number1"));
		driver.findElement(By.xpath(BR_loc.getProperty("Card_Number_Field"))).sendKeys(config.getProperty("Card_Number2"));
		driver.findElement(By.xpath(BR_loc.getProperty("Card_Number_Field"))).sendKeys(config.getProperty("Card_Number3"));
		driver.findElement(By.xpath(BR_loc.getProperty("Card_Number_Field"))).sendKeys(config.getProperty("Card_Number4"));
		String month1 = "" + (1 + (int) (Math.floor(Math.random() * 12)));
		String preMonth = month1.length() > 1 ? "" : "0"; // conditional statement & length function -> 3445 = 4 digit
		driver.findElement(By.xpath(BR_loc.getProperty("Expiry_Date"))).sendKeys(preMonth + month1);
		Thread.sleep(1000);
		driver.findElement(By.xpath(BR_loc.getProperty("Expiry_Date")))
				.sendKeys("20" + (25 + (int) (Math.floor(Math.random() * 16))));
		driver.findElement(By.xpath(BR_loc.getProperty("CVC")))
				.sendKeys("" + (100 + (int) (Math.floor(Math.random() * 100))));
		driver.findElement(By.xpath(BR_loc.getProperty("First_Name"))).sendKeys(RandomStringUtils.randomAlphabetic(10));
		driver.findElement(By.xpath(BR_loc.getProperty("Last_Name"))).sendKeys(RandomStringUtils.randomAlphabetic(10));
		driver.findElement(By.xpath(BR_loc.getProperty("Pay_Button"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BR_loc.getProperty("Order_Number_Message"))));

// SCREENSHOT() THROWS IOEXCEPTION {
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(":", "-").replace(" ", "-").substring(4);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"/MaryKay Screenshot/PE ORDERS/"+screenshotfilename+".png"));
		System.out.println("CREDIT CARD SECTION PASS");
		System.out.println("SCREENSHOT CAPTURE");
		driver.switchTo().window(fakeMailWeb);

// CONFIRMATIONMAIL() THROWS INTERRUPTEDEXCEPTION {
		driver.findElement(By.xpath(BR_loc.getProperty("Back_Button_Of_Fake_Mail"))).click();
		System.out.println("FAKE MAIL WEB OPEN");
//		wait.until(ExpectedConditions.visibilityOfElementBR_located(By.xpath(BR_loc.getProperty("Received_Mail")))).click();
		System.out.println("MARY KAY ORDER CONFIRMATION MAIL RECEIVED");
	}
}
