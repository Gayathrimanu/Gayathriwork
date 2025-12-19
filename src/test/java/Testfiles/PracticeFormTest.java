package Testfiles;

import Base.BaseTest;
import Pages.PracticeFormPage;
import Utils.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class PracticeFormTest extends BaseTest {
    @Test
    public void fillPracticeForm() {
        PracticeFormPage formPage = new PracticeFormPage(driver);
        formPage.enterFirstName("John");
        formPage.enterLastName("Dot");
        formPage.enterEmail("john.doo@example.com");
        formPage.selectGenderFemale();
        formPage.enterMobile("9876543210");
        formPage.enterDOB("18", "November", "1980");
        formPage.enterSubject("Maths");
        formPage.selectHobby();
        formPage.enterAddress("179 Main Street, City");
        // Upload picture (provide full path)
        formPage.uploadPicture("C:\\Users\\Gayu\\screenshot.png");

        // Select State & City
        formPage.selectState("NCR");
        formPage.selectCity("Delhi");
     formPage.clickSubmit();
     formPage.waitForSubmissionModal();

        System.out.println("Form submitted successfully including State, City & Picture!");
    }
}

