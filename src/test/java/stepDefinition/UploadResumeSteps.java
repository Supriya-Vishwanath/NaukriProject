package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadResumeSteps {
 WebDriver driver;
@Given("User is on Naukri login page")
public void user_is_on_naukri_login_page() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
      driver.get("https://www.naukri.com/");
}

@When("User logs in with valid credentials")
public void user_logs_in_with_valid_credentials() throws InterruptedException {
     Thread.sleep(5000);
    driver.findElement(By.id("login_Layer")).click();
    driver.findElement(By.xpath("//input[contains(@placeholder,'Email')]")).sendKeys("supriya.v.prof@gmail.com");
    driver.findElement(By.xpath("//input[contains(@placeholder,'pass')]")).sendKeys("Naukri2025$");
    driver.findElement(By.xpath("//button[text()='Login']")).click();
}

@When("User navigates to the resume upload section")
public void user_navigates_to_the_resume_upload_section() {
	driver.findElement(By.xpath("//div[contains(@class,'view-profile')]//a")).click();
}

@When("User uploads the resume file")
public void user_uploads_the_resume_file() {
	WebElement deleteEle=driver.findElement(By.xpath("//span[@data-title='delete-resume']"));
	deleteEle.click();
//	WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file' and contains(@id,'attachCV')]"));
//	
//    uploadElement.sendKeys("C:\\Users\\91849\\Documents\\Suppa 2.0\\GrowSkills\\Supriya_V_Resume.pdf");

    System.out.println("File path sent to upload field.");
}

@Then("Resume should be uploaded successfully")
public void resume_should_be_uploaded_successfully() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Supriya_V_Resume.pdf']")));
	 System.out.println("Resume uploaded successfully!");
     driver.quit();
}

}
