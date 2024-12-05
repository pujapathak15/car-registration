package org.pageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CarDeatilsPage {
    WebDriver driver;
//Page factory for filling details page

    private By vechileType = By.xpath("//div/span[contains(text(),'Car']");
    Select selectMake =new Select(driver.findElement(By.id("Manufacturer")));
    Select selectModel =new Select(driver.findElement(By.id("Model")));
    Select selectFuel =new Select(driver.findElement(By.id("FuelType")));
    Select selectRegYear =new Select(driver.findElement(By.id("RegYear")));
    Select selectColour =new Select(driver.findElement(By.id("Colour")));
    private By metalicPaint = By.xpath("//div/span[contains(text(),'Yes']");
    Select selectVehicle =new Select(driver.findElement(By.id("Derivative")));
    private By myCarButton = By.id("confirm");
    //captured the whole div
    private By resultOutput = By.xpath("//div[@class='container justify-content-center align-self-center']");


    public CarDeatilsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterMoreCarDetails() {

        // Selected by index as these details are not present as input data
        driver.findElement(vechileType).click();
        selectMake.selectByIndex(1);
        selectModel.selectByIndex(2);
        selectFuel.selectByIndex(1);
        selectRegYear.selectByIndex(2);
        selectColour.selectByIndex(3);
        driver.findElement(metalicPaint).click();
        selectVehicle.selectByIndex(2);
        driver.findElement(myCarButton).click();
    }

    public String getValuationResult() {
        WebElement result = driver.findElement(resultOutput);
        // this will through error need proper string alteration,
        // due to time constraints could not able to make actual changes
        return result.getText().trim();
    }
}
