package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_GoogleNutella {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedIcerik="Google";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title testi FAILED");
        }

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@name='q']"));
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();
        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElementi= driver.findElement(By.id("result-stats"));
        System.out.println(sonucYaziElementi.getText());
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        String sonucYazisiStr= sonucYaziElementi.getText();
        String[] sonucYaziKelimeleriArr = sonucYazisiStr.split(" ");
        String sonucSayiAdediStr=sonucYaziKelimeleriArr[1]; // 130.000.000
        sonucSayiAdediStr = sonucSayiAdediStr.replaceAll("\\D",""); // "130000000"
        int sonucSayisiInt= Integer.parseInt(sonucSayiAdediStr);

        if (sonucSayisiInt>10000000){
            System.out.println("sonuc sayisi testi PASSED");
        }else{
            System.out.println("Sonuc sayisi testi FAILED");
        }

        //8- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
