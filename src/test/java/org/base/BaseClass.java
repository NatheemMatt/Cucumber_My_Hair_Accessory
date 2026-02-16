package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static Actions a;
	public static Alert al;
	public static Select s;
	public static Robot r;
	public static JavascriptExecutor js;
	public static WebDriverWait w;
	public static FluentWait<WebDriver> fl;

	public static void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Browser launched successfully");
	}

	public static void urlLaunch(String url) {
		driver.get(url);
		System.out.println("URL launched: " + url);
	}

	public static void titleOfthePage() {
		String title1 = driver.getTitle();
		System.out.println("Page title is: " + title1);
	}

	public static void urlOfthePage() {
		String currentUrl1 = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl1);
	}

	public static void goTotheElement(WebElement eleMouse) {
		a = new Actions(driver);
		a.moveToElement(eleMouse).perform();
		System.out.println("Mouse moved to the element");
	}

	public static void dClick(WebElement eleDoubClick) {
		a = new Actions(driver);
		a.doubleClick(eleDoubClick).perform();
		System.out.println("Double click performed");
	}

	public static void rClick(WebElement rightClick) {
		a = new Actions(driver);
		a.contextClick(rightClick).perform();
		System.out.println("Right click performed");
	}

	public static void drAnddg(WebElement sEle, WebElement dEle) {
		a = new Actions(driver);
		a.dragAndDrop(sEle, dEle).perform();
		System.out.println("Drag and drop action completed");
	}

	public static void kbCOPY() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);

		System.out.println("Keyboard COPY action performed");
	}

	public static void kbPaste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

		System.out.println("Keyboard PASTE action performed");
	}

	public static void kbEnterKey() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("ENTER key pressed");
	}

	public static void kbDownKey() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		System.out.println("DOWN arrow key pressed");
	}

	public static void kbUpKey() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
		System.out.println("UP arrow key pressed");
	}

	public static void dropDownbyIndex(WebElement ele, int num) {
		s = new Select(ele);
		s.selectByIndex(num);
		System.out.println("Dropdown selected by index: " + num);
	}

	public static void dropDownbyText(WebElement ele, String text) {
		s = new Select(ele);
		s.selectByVisibleText(text);
		System.out.println("Dropdown selected by visible text: " + text);
	}

	public static void dropDownbyValue(WebElement ele, String value) {
		s = new Select(ele);
		s.selectByValue(value);
		System.out.println("Dropdown selected by value: " + value);
	}

	public static void dropDownDeselectAll(WebElement ele) {
		s = new Select(ele);
		s.deselectAll();

		System.out.println("All dropdown selections deselected");
	}

	public static void dropDownfirstSelect(WebElement ele) {
		s = new Select(ele);
		WebElement firstOption = s.getFirstSelectedOption();
		String text = firstOption.getText();
		System.out.println("First selected option is: " + text);
	}

	public static void dropDownallSelected(WebElement ele) {
		s = new Select(ele);
		List<WebElement> allSelec = s.getAllSelectedOptions();
		for (int i = 0; i < allSelec.size(); i++) {
			WebElement text = allSelec.get(i);
			String s = text.getText();
			System.out.println("All Selected options: " + s);
		}
	}

	public static void dropDownAllOptions(WebElement ele) {
		s = new Select(ele);
		List<WebElement> allOptions = s.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			WebElement text = allOptions.get(i);
			String s = text.getText();
			System.out.println("All Dropdown options: " + s);
		}
	}

	public static void dropDownStyle(WebElement ele) {
		s = new Select(ele);
		boolean dDStyle = s.isMultiple();
		System.out.println("Drop Down can be multi selected : " + dDStyle);
	}

	public static void dropDownDeselectbyValue(WebElement ele, String text) {
		s = new Select(ele);
		s.deselectByValue(text);
		System.out.println("Dropdown deselected by value: " + text);
	}

	public static void dropDownDeselectbyText(WebElement ele, String text) {
		s = new Select(ele);
		s.deselectByVisibleText(text);
		System.out.println("Dropdown deselected by visible text: " + text);
	}

	public static void dropDownDeselectbyIndex(WebElement ele, int num) {
		s = new Select(ele);
		s.deselectByIndex(num);
		System.out.println("Dropdown deselected by index: " + num);
	}

	public static void impliWait(int num) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
		System.out.println("Implicit wait applied for " + num + " seconds");
	}

	public static void unConditionalWait(int num) throws InterruptedException {
		Thread.sleep(num);
	}

	public static void parentWindowId() {
		String parentId = driver.getWindowHandle();
		System.out.println("Parent window ID: " + parentId);
	}

	public static void allWindowId() {
		Set<String> allWinId = driver.getWindowHandles();
		for (String x : allWinId) {
			System.out.println("Each Window ID is: " + x);
		}
	}

	public static void windowSwitchByNum(int num) {
		Set<String> allWinId = driver.getWindowHandles();
		List<String> allWin = new LinkedList<String>();
		allWinId.addAll(allWin);
		driver.switchTo().window(allWin.get(num));
		System.out.println("Switched to window at index: " + num);
	}

	public static void windowSwitchForTwoTabs() {
		String pId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for (String x : allId) {
			if (!x.equals(pId)) {
				driver.switchTo().window(x);
				System.out.println("Switched to child tab");
			} else {
				System.out.println("This is parent tab");
			}
		}
	}

	public static void windowSwitchByTab(int num) {
		Set<String> allWinId = driver.getWindowHandles();
		int tabCount = 1;
		for (String x : allWinId) {
			if (tabCount == num) {
				driver.switchTo().window(x);
				System.out.println("Switched to tab number: " + num);
				break;
			} else {
				System.out.println("Tab not Switched");
			}
			tabCount++;
		}
	}

	public static void windowSwitchbyUrl(String url) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String x : windowHandles) {
			driver.switchTo().window(x);
			String currentUrl = driver.getCurrentUrl();

			if (currentUrl.equals(url)) {
				System.out.println("Switched to window with URL: " + currentUrl);
				break;
			} else {
				System.out.println("URL not matched");
			}
		}
	}

	public static void switchingFrame(WebElement ele) {
		driver.switchTo().frame(ele);
		System.out.println("Switched to the frame successfully: " + ele);
	}

	public static void switchingFramebyDirectLocators(WebElement ele, String nameorid) {
		driver.switchTo().frame(nameorid);
		System.out.println("Switched to frame with Name/ID");
	}

	public static void getSnap(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File desFile = new File("C:\\Users\\HP\\eclipse-workspace\\SampleTest\\Screenshot\\" + name + ".png");
		FileUtils.copyFile(srcFile, desFile);
		System.out.println("Screenshot saved successfully");
	}

	public static void javaScriptSendKeys(WebElement ele, String value) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + value + "')", ele);
		System.out.println("Value set using JavaScript: " + value);
	}

	public static void javaScriptClicK(WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
		System.out.println("Clicked on element using JavaScript");
	}

	public static void javaScriptGetAttribute(WebElement ele) {
		js = (JavascriptExecutor) driver;
		Object userValue = js.executeScript("arguments[0].getAttribute('value')", ele);
		System.out.println("User input value : " + userValue);
	}

	public static void jsScrollUp(WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", ele);
		System.out.println("Scrolled UP to the element using JavaScript");
	}

	public static void jsScrollDown(WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		System.out.println("Scrolled DOWN to the element using JavaScript");
	}

	public static void waitForElementVisible(WebElement ele, int num) {
		w = new WebDriverWait(driver, Duration.ofSeconds(num));
		w.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitForElementClickable(WebElement ele, int num) {
		w = new WebDriverWait(driver, Duration.ofSeconds(num));
		w.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void waitForTextToBePresent(WebElement ele, int num, String val) {
		w = new WebDriverWait(driver, Duration.ofSeconds(num));
		w.until(ExpectedConditions.textToBePresentInElement(ele, val));
		System.out.println("Text " + val + " is now present in element");
	}

	public static String readDataFromExcel(int rowNo, int cellNo) throws IOException {

		File f = new File("C:\\Users\\HP\\eclipse-workspace\\Facebook\\Excel\\Fb.xlsx");

		FileInputStream fis = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fis);

		Sheet sh = w.getSheet("Sheet1");

		Row r = sh.getRow(rowNo);

		Cell c = r.getCell(cellNo);

		int type = c.getCellType();

		String val1 = "";

		if (type == 1) {
			val1 = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {

			Date dd = c.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			val1 = sdf.format(dd);
		}

		else {
			double num = c.getNumericCellValue();
			long l = (long) num;
			val1 = String.valueOf(l);

		}

		return val1;
	}

	public static void waitForUrlContains(String urlPart, int num) {
		w = new WebDriverWait(driver, Duration.ofSeconds(num));
		w.until(ExpectedConditions.urlContains(urlPart));
	}

	public static void waitForElementVisibleByLocator(By loctor, int num) {
		w = new WebDriverWait(driver, Duration.ofSeconds(num));
		w.until(ExpectedConditions.visibilityOfElementLocated(loctor));
	}

	public static void waitForElementClickableByLocator(By loctor, int num) {
		w = new WebDriverWait(driver, Duration.ofSeconds(num));
		w.until(ExpectedConditions.elementToBeClickable(loctor));
	}

	public static void waitForElementInvisible(WebElement ele, int num) {
		w = new WebDriverWait(driver, Duration.ofSeconds(num));
		boolean result = w.until(ExpectedConditions.invisibilityOf(ele));
		System.out.println(result);
	}

	public static void waitForElementInvisibleByLocator(By locator, int num) {
		w = new WebDriverWait(driver, Duration.ofSeconds(num));
		w.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void waitForAlert(int num) {
		w = new WebDriverWait(driver, Duration.ofSeconds(num));
		w.until(ExpectedConditions.alertIsPresent());
	}

	public static void fluvisibilityof(WebElement ele, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void fluvisibilityofallelements(List<WebElement> ele, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.visibilityOfAllElements(ele));
	}

	public static void fluvisibilityofelementlocated(By locator, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void fluvisibilityofallelementslocatedby(By locator, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public static void fluinvisibilityoftheelementlocated(By locator, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void fluinvisibilityofelementlocatedwithtext(By locator, String text, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}

	public static void flutexttobepresentinelement(WebElement ele, String value, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.textToBePresentInElement(ele, value));
	}

	public static void flutexttobepresentinelementlocated(By locator, String text, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public static void flutexttobepresentinelementvalue(By locator, String text, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
	}

	public static void flupresenceofelementlocated(By locator, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void flupresenceofallelementlocatedby(By locator, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public static void fluelementtobeclickable(WebElement ele, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void fluelementtobeselected(WebElement ele, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.elementToBeSelected(ele));
	}

	public static void fluelementselectionstatetobe(By locator, boolean selected, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.elementSelectionStateToBe(locator, selected));
	}

	public static void fluframetobeavailableandswitchtoit(By locator, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public static void flutitleis(String title, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.titleIs(title));
	}

	public static void flutitlecontains(String title, int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.titleContains(title));
	}

	public static void flualertispresent(int sec, Duration milli) {
		fl = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(milli)
				.ignoring(Throwable.class);
		fl.until(ExpectedConditions.alertIsPresent());
		al = driver.switchTo().alert();
		al.accept();

	}

	public static void clickTheBtn(WebElement ele) {
		ele.click();
	}

	public static void sendText(WebElement ele, String text) {
		ele.sendKeys(text);
	}

	public static void clearText(WebElement ele) {
		ele.clear();
	}

	public static void getAttributeValue(WebElement ele, String name) {
		String value = ele.getAttribute("value");
		System.out.println(name + value);
	}

	public static void quitTheBrowser() {
		driver.quit();
	}

	public static void date(String test) {
		Date d = new Date();
		System.out.println(test + d);
	}

	public static void space() {
		System.out.println();
	}
	
}
