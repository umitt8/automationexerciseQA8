package automationexerciseQA8;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class TestCase_13 extends TestBase {

    @Test
    public void test1() {

//        1. Launch browser
        // driver.get("");
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");
//        3. Verify that home page is visible successfully
        driver.findElement(By.xpath("//i[@class='fa fa-home']"));
//        4. Click 'View Product' for any product on home page
        driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[21]")).click();
//        5. Verify product detail is opened

//        6. Increase quantity to 4
//        7. Click 'Add to cart' button
//        8. Click 'View Cart' button
//        9. Verify that product is displayed in cart page with exact quantity

    }
}
