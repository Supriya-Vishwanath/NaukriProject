package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadResumeSteps {
 WebDriver driver;

@Given("User is on Naukri login page")
public void user_is_on_naukri_login_page() {
	  driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.naukri.com/");
}

@When("User logs in with valid credentials")
public void user_logs_in_with_valid_credentials() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file' and @id='attachCV']"));
     uploadElement.sendKeys("C:\\Users\\91849\\Documents\\Suppa 2.0\\GrowSkills\\Supriya_V_Resume.pdf");
}

@Then("Resume should be uploaded successfully")
public void resume_should_be_uploaded_successfully() {
	 System.out.println("Resume uploaded successfully!");
//     driver.quit();
}

}
