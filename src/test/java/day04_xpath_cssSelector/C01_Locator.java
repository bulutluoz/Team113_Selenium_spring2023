package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locator {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //	1- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com");
        //  2- Arama kutusuna “city bike” yazip aratin
        WebElement aramaKutusuElementi= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("city bike" + Keys.ENTER);
        //	3- Görüntülenen sonuçların sayısını yazdırın
        WebElement aramaSonucuElementi= driver.findElement(By.className("sg-col-inner"));
        System.out.println(aramaSonucuElementi.getText());
        //	4- Listeden ilk urunun resmine tıklayın.

        List<WebElement> urunResimElementleriList= driver.findElements(By.className("s-image"));
        urunResimElementleriList.get(0).click();

        Thread.sleep(4000);
        driver.close();
    }
}
