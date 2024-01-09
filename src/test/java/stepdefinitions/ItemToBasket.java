package stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import utilities.Driver;
import utilities.ExcelCellReader;
import utilities.Helpers;

public class ItemToBasket {

	HomePage home=new HomePage();
	Helpers help= new Helpers();
	ExcelCellReader excelreader = new ExcelCellReader();
	Actions actions=new Actions(Driver.getDriver());
	JavascriptExecutor jre = (JavascriptExecutor) Driver.getDriver();
	
@Given("user is on beymen home page")
public void user_is_on_beymen_home_page() throws InterruptedException {
	home.acceptCookies.click();
	home.genderBtn.click();
	System.out.println("Page Loaded");
//	Scrool.executeScript("window.scrollBy(0,300)", "");
	//jre.executeScript("arguments[0].scrollIntoView();", payment.settingsBtn);
	//jre.executeScript("arguments[0].click();", payment.settingsBtn);
//	actions.moveToElement(payment.settingsBtn).doubleClick().perform();
}
@And("search first value on excel")
public void search_first_value_on_excel() throws InterruptedException {
	home.placeholderSearchArea.click();
	home.setTextForSearch("şort");
	//home.setTextForSearch(excelreader.readCell(1, 1));
	System.out.println("First Value Searched");
	}
@And("delete first value from search bar")
public void delete_first_value_from_search_bar() throws InterruptedException {

	home.deleteBtn.click();	
	System.out.println("Search deleted");
	}

@And("search second value on excel")
public void search_second_value_on_excel() {
	home.searchText("gömlek");
	System.out.println("gömlekler listelendi");
}

@And("select anyone item on list")
public void select_anyone_item_on_list() {
	home.selectRandomProduct();

	System.out.println("Random product opened.");
}

@And("write selected item values to txt")
public void write_selected_item_values_to_txt() throws IOException {
	home.Writefile();
	help.readFile(0);
	System.out.println("item deatils writing to TestFile.txt");
}
@And("selected item add to basket")
public void selected_item_add_to_basket() throws IOException, InterruptedException {
	home.selectRandomSize();
	home.addBasketBtn.click();
	Thread.sleep(3000);
	System.out.println("item added to basket");
	
}
@And("compare item price and basket price")
public void compare_item_price_and_basket_price() throws IOException, InterruptedException {
	jre.executeScript("arguments[0].scrollIntoView();", home.BasketBtn);
	jre.executeScript("arguments[0].click();", home.BasketBtn);
	Assert.assertEquals(home.productTitleInBasket.getText(), help.readFile(1));
	System.out.println(home.productPriceInBasket.getText());
	System.out.println(home.productTitleInBasket.getText());
	help.readFile(1);
	Thread.sleep(30000);
	
	System.out.println("Values Validated.");
}

@And("item count up on basket")
	public void item_count_up_on_basket() {
		home.selectItemCountDropdown.click();
		home.item2.click();
		System.out.println("wallet displayed");
}
@And("delete item from basket")
	public void delete_item_from_basket() {
		home.deleteItem.click();
		System.out.println("items deleted");
}

@Then("user completed tests")
public void user_completed_tests() {
	System.out.println("Test completed.");
}

}
