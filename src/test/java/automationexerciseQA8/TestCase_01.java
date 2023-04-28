package automationexerciseQA8;


import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase_01 extends TestBase {
    @Test
    public void test1() {


        //1. Launch browser
        //driver.get("");

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement home=driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue(home.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

        //6. Enter name and email address
        Faker faker = new Faker();

        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys(faker.name().firstName(), Keys.ENTER);

        WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        email.sendKeys(faker.internet().emailAddress(),Keys.ENTER);

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).submit();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccount= driver.findElement(By.xpath("(//b)[1]"));
        Assert.assertTrue(enterAccount.isDisplayed());


        //SAYFA KAYDIRMA
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();//title
        driver.findElement(By.id("password")).sendKeys("Abc12?");

        WebElement day= driver.findElement(By.id("days"));
        Select select1 = new Select(day);
        select1.selectByIndex(24);

        WebElement month= driver.findElement(By.id("months"));
        Select select2 = new Select(month);
        select2.selectByIndex(1);

        WebElement year= driver.findElement(By.id("years"));
        Select select3 = new Select(year);
        select3.selectByIndex(20);



        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement select = driver.findElement(By.id("newsletter"));
        // WebElement select = driver.findElement(By.xpath("//*[@type='checkbox'][1]"));
        select.click();


        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("last_name")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("company")).sendKeys(faker.company().name());
        driver.findElement(By.id("address1")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.id("address2")).sendKeys(faker.address().streetAddressNumber());

        WebElement country=driver.findElement(By.id("country"));
        Select selectCountry=new Select(country);
        selectCountry.selectByValue("Canada");

        driver.findElement(By.id("state")).sendKeys(faker.address().state());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("zipcode")).sendKeys(faker.address().zipCode());
        driver.findElement(By.id("mobile_number")).sendKeys(faker.phoneNumber().phoneNumber());

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).submit();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated=driver.findElement(By.xpath("//b"));
        Assert.assertTrue(accountCreated.isDisplayed());


        // REKLAM
        driver.navigate().refresh();

        //15. Click 'Continue' button

        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //REKLAM ve CLICK


        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();




        //16. Verify that 'Logged in as username' is visible
        WebElement loggedUsername= driver.findElement(By.xpath("//b"));
        Assert.assertTrue(loggedUsername.isDisplayed());




        //17. Click 'Delete Account' button

        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();


        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeleted= driver.findElement(By.xpath("//b"));
        Assert.assertTrue(accountDeleted.isDisplayed());

    }
}