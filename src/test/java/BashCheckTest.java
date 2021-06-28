package second_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class BashCheckTest {

    @Test
    public void bashHighlightCheck() {

        WebDriver driver = new ChromeDriver();

        driver.get("http://pastebin.com");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));

        WebElement codeInput = driver.findElement(By.id("postform-text"));
        codeInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        WebElement syntax = driver.findElement(By.id("select2-postform-format-container"));
        syntax.click();
        List<WebElement> options1 = driver.
                findElements(By.xpath("//ul[@class='select2-results__options select2-results__options--nested']/li"));
        String option1 = "Bash";
        for (WebElement opt : options1) {
            if (opt.getText().equals(option1)) {
                opt.click();
                break;
            }
        }

        WebElement expire = driver.findElement(By.id("select2-postform-expiration-container"));
        expire.click();
        List<WebElement> options2 = driver
                .findElements(By.xpath("//ul[@id='select2-postform-expiration-results']/li"));
        String option2 = "10 Minutes";
        for (WebElement opt : options2) {
            if (opt.getText().equals(option2)) {
                opt.click();
                break;
            }
        }

        WebElement nameInput = driver.findElement(By.id("postform-name"));
        nameInput.sendKeys("how to gain dominance among developers");

        WebElement pasteBtn = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button"));
        pasteBtn.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.titleContains("how to gain dominance among developers - Pastebin.com"));

        String actualTitle = driver.getTitle();
        String expectedTitle = "how to gain dominance among developers - Pastebin.com";
        if(actualTitle.equals(expectedTitle)) System.out.println("The page Title corresponds with the Paste Name.");
        //boolean b = actualTitle.equals(expectedTitle);
        //System.out.println(b);

        WebElement codeOutput = driver.findElement(By.xpath("//a[@class='btn -small h_800']"));
        if(codeOutput.getText().equals("Bash")) System.out.println("The syntax is highlighted with Bash.");

        WebElement code = driver.findElement(By.xpath("//ol[@class='bash']"));
        if(code.getText().equals("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force")) System.out.println("The Paste code equals the initial one.");

        driver.quit();

    }

}
