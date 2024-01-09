package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import utilities.Driver;

public class OpeningTimes extends BasePage{
	public OpeningTimes() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	String vendor = System.getProperty("vendorId");
	
	@FindBy(xpath ="//a[@href='/opening_times_global?int_ref=side-nav']")
	public WebElement openingTimesBtn;
	
	@FindBy(css ="button[data-testid='header-button-Outlets']")
	public WebElement outletsDropdown;

	@FindBy(css ="input[value='+ vendorId +']")
	public WebElement vendorRadioBtn;
	
	@FindBy(css ="button[data-testid='submit-btn']")
	public WebElement applyBtn;
	
	//@FindBy(xpath ="//span[text()='Eid Al Adha Schedule']")
	@FindBy(xpath ="//h1[contains(text(),'Eid Al Adha Schedule')]")
	public WebElement eidAlAdhaScheduleTitle;
	
	@FindBy(xpath ="//h1[contains(text(),'Eid Al Adha Schedule')]/../../button")
	public WebElement eidAlAdhaScheduleEdit;
	
	@FindBy(xpath ="//h1[contains(text(),'Regular schedule')]")
	public WebElement regularScheduleTitle;
	
	@FindBy(xpath ="//h1[contains(text(),'Regular schedule')]/../../button")
	public WebElement regularScheduleEdit;

	@FindBy(xpath ="//span[text()='Monday']/../span[2]/span[1]/input")
	public WebElement mondayEnableBtn;
	
	@FindBy(xpath ="//span[text()='Tuesday']/../span[2]/span[1]/input")
	public WebElement tuesdayEnableBtn;
	
	@FindBy(xpath ="//span[text()='Wednesday']/../span[2]/span[1]/input")
	public WebElement wednesdayEnableBtn;
	
	@FindBy(xpath ="//span[text()='Thursday']/../span[2]/span[1]/input")
	public WebElement thursdayEnableBtn;
	
	@FindBy(xpath ="//span[text()='Friday']/../span[2]/span[1]/input")
	public WebElement fridayEnableBtn;
	
	@FindBy(xpath ="//span[text()='Saturday']/../span[2]/span[1]/input")
	public WebElement saturdayEnableBtn;
	
	@FindBy(xpath ="//span[text()='Sunday']/../span[2]/span[1]/input")
	public WebElement sundayEnableBtn;
	
	@FindBy(xpath ="//button[text()='Reset']")
	public WebElement resetBtn;

	@FindBy(xpath ="//button[text()='Next']")
	public WebElement nextBtn;

	@FindBy(xpath ="//button[text()='Confirm']")
	public WebElement confirmBtn;
	@FindBy(xpath ="//button[text()='Apply and save changes']")
	public WebElement applyAndSaveBtn;


	@FindBy(css ="div[data-testid='time-selector-6-shift-0-from']")
	public WebElement day6Shift0From;  //Last day a week

	@FindBy(xpath ="//ul[@role='listbox']")
	public WebElement listboxforTime;//Last day a week

	@FindBy(xpath ="//li[starts-with(., '08:00')]")
	public WebElement listItem;

	@FindBy(css ="div[data-testid='time-selector-6-shift-0-to']")
	public WebElement day6Shift0To;   //Last day a week
	@FindBy(css ="div[data-testid='time-selector-0-shift-0-from']")
	public WebElement day0Shift0From; //Last day a week
	@FindBy(css ="div[data-testid='time-selector-0-shift-0-to']")
	public WebElement day0Shift0To;   //Last day a week

	@FindBy(css ="div[id='time-selector-0-shift-0-to']")
	public WebElement day0Shift0To1;   //Last day a week

	public void selectVendorOpeningTimes() throws InterruptedException {
		outletsDropdown.click();
		Thread.sleep(1000);
		vendorId().click();
		Thread.sleep(1000);
		waitForVisibility(applyBtn, 10).click();
		Thread.sleep(2000);
	}
	public void clickOpeningTimesPlugin(){
		waitForVisibility(openingTimesBtn,15);
		openingTimesBtn.click();
	}
	public void regularScheduleIsDisplayed(){
		waitForVisibility(regularScheduleTitle,10);
		regularScheduleTitle.isDisplayed();
	}
	public void regularScheduleClickEditBtn() throws InterruptedException {
		regularScheduleEdit.isDisplayed();
		waitForClickablility(regularScheduleEdit,5).click();
	}

	public void validateScheduleDrawer(){
		mondayEnableBtn.isDisplayed();
		tuesdayEnableBtn.isDisplayed();
		wednesdayEnableBtn.isDisplayed();
		thursdayEnableBtn.isDisplayed();
		fridayEnableBtn.isDisplayed();
		saturdayEnableBtn.isDisplayed();
		sundayEnableBtn.isDisplayed();
		resetBtn.isDisplayed();
		System.out.println("displayed all field");
	}
	public void editShiftOnScheduleDrawer(String fromValue,String toValue) throws InterruptedException {
			day6Shift0From.click();
			Thread.sleep(3000);
			valueFromTo(fromValue).click();
			System.out.println("setted from");
			day6Shift0To.click();
			Thread.sleep(3000);
			valueFromTo(toValue).click();
			System.out.println("settted to");
			nextBtn.click();
			applyAndSaveBtn.click();
			confirmBtn.click();
			Thread.sleep(3000);
	}
	public void eidAlAdhaScheduleEdit(){
		eidAlAdhaScheduleTitle.isDisplayed();
		eidAlAdhaScheduleEdit.isDisplayed();
		eidAlAdhaScheduleEdit.click();
	}
	public void snackbarMessageValidation(String status){
		snackbarMessage().isDisplayed();
		String msg = snackbarMessage().getText();
		if (status == "Success"){
			Assert.assertEquals(msg,"Changes saved successfully!");
		} else if (status == "Failure") {
			Assert.assertEquals(msg,"Something went wrong");
		}
	}


}
