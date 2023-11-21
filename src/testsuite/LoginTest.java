package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Sign In’ link
 * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * click on the ‘Sign In’ link
 * Enter invalid username
 * Enter invalid password
 * Click on Login button
 * Verify the error message ‘Invalid email or password'.
 */
public class LoginTest extends BaseTest {
    String baseURL = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Find the Sign In button and Click on it
        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(), 'Sign In')]")); // Xpath for Sign in link
        signIn.click();
        String expectedText = "Welcome Back!";
        // Find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.className("page__heading"));
        String actualText = actualTextElement.getText();
        // Verify actual and expected text
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessage() {
        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(), 'Sign In')]")); // Xpath for Sign in link
        signIn.click();
        // Find the username field and Type the invalid username
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("prime321@gmail.com");
        // Find the password field and Type the invalid password
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("password");
        // Find the Login Button and Click on it
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text() ,'Sign in')]"));
        loginBtn.click();

        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]")).getText();
        // Validate actual and expected message
        Assert.assertEquals("Unable to log in", expectedErrorMessage, actualErrorMessage);


    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
