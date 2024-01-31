package org.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:8080/attendance");

            WebElement usernameInput = driver.findElement(By.id("username"));
            WebElement passwordInput = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button"));

            usernameInput.sendKeys("Aqua");
            passwordInput.sendKeys("Systech123*");
            Thread.sleep(2000);
            loginButton.click();

            // Wait until the element is present on the page
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='h5 mb-0 mr-3 font-weight-bold text-gray-800']")));

            List<WebElement> allEmployeesdiv = driver.findElements(By.xpath("//div[@class='h5 mb-0 mr-3 font-weight-bold text-gray-800']"));
            String allEmployees = allEmployeesdiv.get(0).getText();

            // Dynamic assertion based on the retrieved value
            assertEquals("10", allEmployees);

            driver.get("http://localhost:8080/attendance/attendance-sheet");
            WebElement emp = driver.findElement(By.id("row_E23487"));

            // Find the radio button for Entry (or Absent, Exit, depending on your requirement)
            WebElement entryRadioButton = emp.findElement(By.xpath(".//input[@value='E23487_Entry']"));

            // Click on the radio button
            entryRadioButton.click();
            Thread.sleep(2000);

            // Find the "Submit" button for that employee
            WebElement submitButton = emp.findElement(By.xpath(".//input[@type='submit']"));

            // Click on the "Submit" button
            submitButton.click();
            Thread.sleep(2000);
            // Handle the alert
            Alert alert = driver.switchTo().alert();

            // Get the text from the alert
            String alertText = alert.getText();

            // Perform actions based on the alert text (you might need to parse the alert text)
            System.out.println("Alert Text: " + alertText);

            // Accept the alert (click OK)
            alert.accept();
            Thread.sleep(2000);

            driver.get("http://localhost:8080/attendance/home");
            Thread.sleep(2000);

            String expectedValue = "E23487";

            // Use XPath to find the table cell containing the expected value
            WebElement cellWithExpectedValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//td[text()='" + expectedValue + "']")));

            System.out.println(cellWithExpectedValue);
            // Assert that the element is not null, indicating the presence of the expected value
            assertNotNull(cellWithExpectedValue);

//            WebElement logOut = driver.findElement(By.xpath("//*[@id=\"userDropdown\"]"));
//            logOut.click();
            // Add wait if needed after clicking logout

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
//            driver.quit();
        }    }
}