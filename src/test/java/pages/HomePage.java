package pages;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;
import utilities.ExcelCellReader;
import utilities.Helpers;

public class HomePage extends BasePage {

	public HomePage() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	Helpers help=new Helpers();
	ExcelCellReader excelreader = new ExcelCellReader();

	@FindBy(css ="input[placeholder*='Ürün, Marka Arayın']")
	public WebElement placeholderSearchArea;

	@FindBy(id ="o-searchSuggestion__input")
	public WebElement searchArea;
	
	@FindBy(id ="onetrust-accept-btn-handler")
	public WebElement acceptCookies;
	
	@FindBy(id ="genderManButton")
	public WebElement genderBtn;
	
	@FindBy(css ="button[class='o-header__search--close -hasButton']")
	public WebElement deleteBtn;
	
	@FindBy(xpath ="/html/body/header/div[2]/div[2]/div[2]/div/div[2]/div/div/div[1]/div/div")
	public WebElement product;
	
	@FindBy(xpath ="//*[@id=\"productList\"]/div")
	public List<WebElement> productElems;
	
	@FindBy(xpath ="/html/body/div[3]/div[1]/div[1]/div[2]/div[2]/h1/span")
	public WebElement productName;
	
	@FindBy(xpath ="//*[@id=\"priceNew\"]")
	public WebElement productPrice;
	
	
	@FindBy(xpath ="//*[contains(concat(' ', normalize-space(@class), ' '), 'm-variation__item')]")
	public List<WebElement> productSize;

	@FindBy(css ="button[id='addBasket']")
	public WebElement addBasketBtn;
	
	@FindBy(xpath ="//a[@title='Sepetim']")
	public WebElement BasketBtn;
	
	@FindBy(css ="span[class='m-productPrice__salePrice']")
	public WebElement productPriceInBasket;

	@FindBy(css ="span[class='m-basket__productInfoName']")
	public WebElement productTitleInBasket;
	
	@FindBy(css ="button[id='removeCartItemBtn0-key-0']")
	public WebElement deleteItem;
	
	@FindBy(css ="select[id='quantitySelect0-key-0']")
	public WebElement selectItemCountDropdown;
	
	@FindBy(css ="ption[value='2']")
	public WebElement item2;
	
	public void selectRandomProduct() {
		int maxProduct = productElems.size();
		Random random = new Random();
		int randomProduct = random.nextInt(maxProduct);
		productElems.get(randomProduct).click();	
	}
	public void selectRandomSize() throws InterruptedException {
		List<WebElement> specificSpans = new ArrayList<>();
		  for (WebElement element : productSize) {
	          String className = element.getAttribute("class");
	          if (className.equals("m-variation__item") || className.equals("m-variation__item -criticalStock")) {
	              specificSpans.add(element);
	          }
	      }
		int maxProductSize = specificSpans.size();
		Random random = new Random();
		int randomProductSize = random.nextInt(maxProductSize);
		specificSpans.get(randomProductSize).click();		
	}
	
	public void setTextForSearch(String text){		
		searchArea.click();
		searchArea.sendKeys(text);
		ExcelCellReader.readCell(1, 1);
	}

	public void searchText(String text){
		waitForClickablility(searchArea,10);
		searchArea.click();
		setTextForSearch(text);
		
		searchArea.sendKeys(Keys.ENTER);
	}
	public void Writefile() throws IOException {
		help.clearFile();
		String productNameText = productName.getText();
		String productPriceText = productPrice.getText();
		FileWriter writer = new FileWriter("TestFile.txt");
        writer.write(productNameText);
        writer.write(System.getProperty("line.separator")); 
   
        writer.write(productPriceText);
        
        writer.close();
	}
	public void priceInBasketConvertFormat(){

		String price=productPriceInBasket.getText();
        String[] parts = price.split(",");
        
        if (parts.length > 1 && parts[1].equals("00 TL")) {
        	price = parts[0] + " TL";
        }
        
        System.out.println("Değiştirilmiş değer: " + price);
       
	}
	

}
