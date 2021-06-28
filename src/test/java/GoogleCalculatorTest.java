package third_task;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleCalculatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://cloud.google.com");

        WebElement searchBtn = driver.findElement(By.xpath("//div[@class='devsite-search-container']"));
        searchBtn.click();

        WebElement searchField = driver.findElement(By.xpath("//input[@class='devsite-search-field devsite-search-query']"));
        searchField.sendKeys("Google Cloud Platform Pricing Calculator");
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(500);

        WebElement link = driver.findElement(By.xpath("//a[@href='https://cloud.google.com/products/calculator']"));
        driver.get(link.getAttribute("href"));
        Thread.sleep(2000);

        try {
            WebElement iframe1=driver.findElement((By.xpath("//devsite-iframe/iframe[@src='/products/calculator/index_760873447570f9085fc684cb27bac85599c029923272009bcca39da816762d7a.frame']")));
            driver.switchTo().frame(iframe1);
            WebElement iframe2=driver.findElement((By.xpath("//iframe[@id='myFrame']")));
            driver.switchTo().frame(iframe2);

            WebElement compEngine = driver.findElement(By.xpath("//md-tab-item[@aria-controls='tab-content-1']"));
            compEngine.click();

            WebElement instNumber = driver.findElement(By.id("input_65"));
            instNumber.sendKeys("4");

            WebElement softOS = driver.findElement(By.id("select_value_label_58"));
            softOS.click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select_container_78/md-select-menu/md-content/md-option']")));
            List<WebElement> listOS = driver.findElements(By.xpath("//div[@id='select_container_78/md-select-menu/md-content/md-option']"));
            String option1 = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
            for (WebElement opt : listOS) {
                if (opt.getText().equals(option1)) {
                    opt.click();
                    break;
                }
            }
            Thread.sleep(500);

            WebElement vmClass = driver.findElement(By.id("select_value_label_59"));
            vmClass.click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select_container_82']/md-select-menu/md-content/md-option")));
            List<WebElement> listVM = driver.findElements(By.xpath("//div[@id='select_container_82']/md-select-menu/md-content/md-option"));
            String option2 = "Regular";
            for (WebElement opt : listVM) {
                if (opt.getText().equals(option2)) {
                    opt.click();
                    break;
                }
            }
            Thread.sleep(500);

            WebElement vmSeries = driver.findElement(By.id("select_value_label_61"));
            vmSeries.click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select_container_90']/md-select-menu/md-content/md-option")));
            List<WebElement> seriesVM = driver.findElements(By.xpath("//div[@id='select_container_90']/md-select-menu/md-content/md-option"));
            String option3 = "N1";
            for (WebElement opt : seriesVM) {
                if (opt.getText().equals(option3)) {
                    opt.click();
                    break;
                }
            }
            Thread.sleep(500);

            WebElement vmType = driver.findElement(By.id("select_value_label_62"));
            vmType.click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select_container_92']/md-select-menu/md-content/md-optgroup/md-option")));
            List<WebElement> typeVM = driver.findElements(By.xpath("//div[@id='select_container_92']/md-select-menu/md-content/md-optgroup/md-option"));
            String option4 = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
            for (WebElement opt : typeVM) {
                if (opt.getText().equals(option4)) {
                    opt.click();
                    break;
                }
            }
            Thread.sleep(500);

            WebElement addGPU = driver.findElement(By.xpath("//md-checkbox[@aria-label='Add GPUs']"));
            addGPU.click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("select_value_label_410")));

            WebElement gpuNum = driver.findElement(By.id("select_value_label_410"));
            gpuNum.click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select_container_413']/md-select-menu/md-content/md-option")));
            List<WebElement> numGPU = driver.findElements(By.xpath("//div[@id='select_container_413']/md-select-menu/md-content/md-option"));
            String option5 = "1";
            for (WebElement opt : numGPU) {
                if (opt.getText().equals(option5)) {
                    opt.click();
                    break;
                }
            }
            Thread.sleep(500);

            WebElement gpuType = driver.findElement(By.id("select_value_label_411"));
            gpuType.click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select_container_415']/md-select-menu/md-content/md-option")));
            List<WebElement> typeGPU = driver.findElements(By.xpath("//div[@id='select_container_415']/md-select-menu/md-content/md-option"));
            String option6 = "NVIDIA Tesla V100";
            for (WebElement opt : typeGPU) {
                if (opt.getText().equals(option6)) {
                    opt.click();
                    break;
                }
            }
            Thread.sleep(500);

            WebElement ssdLocal = driver.findElement(By.id("select_value_label_372"));
            ssdLocal.click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select_container_374']/md-select-menu/md-content/md-option")));
            List<WebElement> locSSD = driver.findElements(By.xpath("//div[@id='select_container_374']/md-select-menu/md-content/md-option"));
            String option7 = "2x375 GB";
            for (WebElement opt : locSSD) {
                if (opt.getText().equals(option7)) {
                    opt.click();
                    break;
                }
            }
            Thread.sleep(500);

            WebElement dataLocal = driver.findElement(By.id("select_value_label_63"));
            dataLocal.click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select_container_94']/md-select-menu/md-content/md-option")));
            List<WebElement> locData = driver.findElements(By.xpath("//div[@id='select_container_94']/md-select-menu/md-content/md-option"));
            String option8 = "Frankfurt (europe-west3)";
            for (WebElement opt : locData) {
                if (opt.getText().equals(option8)) {
                    opt.click();
                    break;
                }
            }
            Thread.sleep(500);

            WebElement useYear = driver.findElement(By.id("select_value_label_64"));
            useYear.click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select_container_101']/md-select-menu/md-content/md-option")));
            List<WebElement> timeUse = driver.findElements(By.xpath("//div[@id='select_container_101']/md-select-menu/md-content/md-option"));
            String option9 = "1 Year";
            for (WebElement opt : timeUse) {
                if (opt.getText().equals(option9)) {
                    opt.click();
                    break;
                }
            }
            Thread.sleep(500);

            WebElement addEst = driver.findElement(By.xpath("//button[@aria-label='Add to Estimate']"));
            addEst.click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='Save Estimate']")));

            List<WebElement> results = driver.findElements(By.xpath("//md-content[@id='compute']/md-list/md-list-item/div"));
            for (WebElement opt : results) {
                System.out.println(opt.getText());
            }
            Thread.sleep(3000);
        }
        catch (Exception e) {
            e.getMessage();
        }
        Thread.sleep(2000);

        driver.quit();

    }

}
