package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import resources.AbstractComponents;

public class Checkout extends AbstractComponents {
	WebDriver driver;

	@FindBy(id = "quantity_wanted")
	WebElement quantityText;

	@FindBy(id = "group_1")
	WebElement sizeSelect;

	@FindBy(id = "color_14")
	WebElement color;

	@FindBy(css = "button[name='Submit'] span")
	WebElement buttonCart;

	@FindBy(css = "a[title='Proceed to checkout'] span")
	WebElement proceedCheckout;

	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
	WebElement nextStepSummary;

	@FindBy(css = "button[name='processAddress']")
	WebElement nextStepAddress;

	@FindBy(xpath = "//*[@id=\"uniform-cgv\"]/span")
	WebElement checkboxAgree;

	@FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
	WebElement nextStepShipping;

	@FindBy(css = "a[class='cheque']")
	WebElement selectPayment;

	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button")
	WebElement nextStepFinal;

	@FindBy(css = "span[class='price']")
	WebElement priceConfirmationOrder;

	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void changeQuantity(String quantity) {
		quantityText.clear();
		quantityText.sendKeys(quantity);
	}

	public void changeSize(String value) {
		Select size = new Select(sizeSelect);
		size.selectByValue(value);
	}

	public void changeColor() {
		color.click();
	}

	public void addToCart() {
		buttonCart.click();
	}

	public void proceedCheckout() {
		waitElementVisible(proceedCheckout);
		proceedCheckout.click();
	}

	public void nextStepSummary() {
		executeScript(true, "800");
		waitElementVisible(nextStepSummary);
		nextStepSummary.click();
	}

	public void nextStepAddress() {
		executeScript(true, "800");
		waitElementVisible(nextStepAddress);
		nextStepAddress.click();
	}

	public void nextStepShipping() {
		executeScript(true, "300");
		waitElementVisible(checkboxAgree);
		checkboxAgree.click();
		nextStepShipping.click();
	}

	public void nextStepPayment() {
		executeScript(true, "800");
		waitElementVisible(selectPayment);
		selectPayment.click();
	}

	public void nextStepFinal() {
		executeScript(true, "800");
		waitElementVisible(nextStepFinal);
		nextStepFinal.click();
	}

	public String priceConfirmation() {
		executeScript(true, "300");
		waitElementVisible(priceConfirmationOrder);
		return priceConfirmationOrder.getText();
	}
}