package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pageFactory.CarDeatilsPage;
import org.pageFactory.CarValuationPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.util.CarInputData;
import org.util.CarOutputData;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CarValidationTest {
    WebDriver driver;
    CarInputData inputData;
    CarValuationPage valuationPage;
    CarDeatilsPage detailsPage;
    CarOutputData outputData;
    Map<String, String> expectedResults;


    @BeforeClass
    public void initialSetUp() throws Exception {
        driver = new ChromeDriver();
        driver.get("https://www.webuyanycar.com/");
        inputData = new CarInputData();
        valuationPage = new CarValuationPage(driver);
        detailsPage = new CarDeatilsPage(driver);
        outputData = new CarOutputData();
        expectedResults = outputData.readExpectedResults("src/test/dataDir/car_output.txt");
    }

    @DataProvider(name = "data")
    public Object[][] getCarData() throws IOException {
        List<String> carRegNo = inputData.readCarNo("src/test/resources/dataDit/car_input.txt");
        return carRegNo.stream().map(num -> new Object[]{num, "40000"}).toArray(Object[][]::new);
    }

    @Test(dataProvider = "data")
    public void testCarValuation(String regNumber, String mileage) {
        valuationPage.enterCarDetails(regNumber, mileage);
        detailsPage.enterMoreCarDetails();
        String actualResult = detailsPage.getValuationResult();
        Assert.assertTrue(actualResult.contains(expectedResults.get(regNumber)));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}