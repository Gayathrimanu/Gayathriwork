package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPage {
    private WebDriver driver;
    WebDriverWait wait;

    //constructor
    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Locators

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By genderFemale = By.xpath("//label[@for='gender-radio-2']");
    private By mobile = By.id("userNumber");
    private By dob = By.id("dateOfBirthInput");
    private By subjects = By.id("subjectsInput");

    private By hobbiesMusic = By.xpath("//label[@for='hobbies-checkbox-3']");
    private By fileupload = By.id("uploadPicture");
    private By currentAddress = By.id("currentAddress");
    private By stateDropdown = By.id("react-select-3-input");
    private By cityDropdown = By.id("react-select-4-input");
    private By submitBtn = By.id("submit");

    //page actions
    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String emailAddress) {
        driver.findElement(email).sendKeys(emailAddress);
    }

    public void selectGenderFemale() {
        WebElement female =
                driver.findElement(By.xpath("//label[@for='gender-radio-2']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(female));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", female);

        female.click();
    }


    public void enterMobile(String number) {
        driver.findElement(mobile).sendKeys(number);
    }

    public void enterDOB(String day, String month, String year) {
        // Open date picker
        driver.findElement(dob).click();

        // Select Year
        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        yearDropdown.click();
        yearDropdown.findElement(By.xpath("//option[text()='" + year + "']")).click();

        // Select Month
        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        monthDropdown.click();
        monthDropdown.findElement(By.xpath("//option[text()='" + month + "']")).click();

        // Select Day
        WebElement dayElement = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='" + day + "']"));
        dayElement.click();
    }

    public void enterSubject(String subject) {
        WebElement subjectField = driver.findElement(subjects);
        subjectField.sendKeys(subject);
        subjectField.sendKeys(Keys.ENTER);
    }

    public void selectHobby() {
        driver.findElement(hobbiesMusic).click();
    }

    public void enterAddress(String address) {
        driver.findElement(currentAddress).sendKeys(address);
    }

    public void uploadPicture(String filePath) {
        driver.findElement(fileupload).sendKeys(filePath);
    }

    public void selectState(String state) {
        WebElement stateInput = driver.findElement(stateDropdown);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
    }

    public void selectCity(String city) {
        WebElement cityInput = driver.findElement(cityDropdown);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
    }
    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

        // Click using JS to avoid ElementClickInterceptedException
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    }
    public void waitForSubmissionModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
    }
}
