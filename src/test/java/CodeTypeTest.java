package first_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class CodeTypeTest {

    @Test
    public void newPasteEnter() {

        WebDriver driver = new ChromeDriver();

        driver.get("http://pastebin.com");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));

        WebElement codeInput = driver.findElement(By.id("postform-text"));
        codeInput.sendKeys("Hello from WebDriver");

        WebElement dropdown = driver.findElement(By.id("select2-postform-expiration-container"));
        dropdown.click();
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='select2-results__options']/li"));
        String option = "10 Minutes";
        for (WebElement opt : options) {
            if (opt.getText().equals(option)) {
                opt.click();
                break;
            }
        }

        WebElement nameInput = driver.findElement(By.id("postform-name"));
        nameInput.sendKeys("helloweb");

        WebElement pasteBtn = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button"));
        pasteBtn.click();
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.titleContains("helloweb - Pastebin.com"));

        driver.quit();

    }

}
