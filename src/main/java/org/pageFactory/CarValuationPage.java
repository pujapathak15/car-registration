package org.pageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CarValuationPage {
    WebDriver driver;

    // With the mentioned input after adding required details, the details are not displaying
    //needs to add few more details manually whic being added in CarDetailsPage.java

    private By regInputField = By.id("vehicleReg");
    private By mileageInputField = By.id("Mileage");
    private By valuationButton = By.id("btn-go");
    
    public CarValuationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterCarDetails(String regNumber, String mileage) {
        driver.findElement(regInputField).sendKeys(regNumber);
        driver.findElement(mileageInputField).sendKeys(mileage);
        driver.findElement(valuationButton).click();
    }
}
