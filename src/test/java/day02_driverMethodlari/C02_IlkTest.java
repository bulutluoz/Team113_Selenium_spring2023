package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_IlkTest {
    public static void main(String[] args) throws InterruptedException {
        // once gerekli ayarlamalari yapip driver objesi olusturmaliyiz
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //4. Sayfa basligini(title) yazdirin
        System.out.println("Sayfa basligi : " + driver.getTitle());
        //5. Sayfa basliginin “Amazon” icerdigini test edin
        // yazilim testi beklenen degerlerin gerceklesip gerceklesmedigini test etmektir

        String expectedIcerik = "Amazon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title Amazon iceriyor, Test PASSED");
        }else {
            System.out.println("Title Amazon icermiyor, Test FAILED");
        }

        //6. Sayfa adresini(url) yazdirin
        System.out.println("Sayfa url : " + driver.getCurrentUrl());
        //7. Sayfa url’inin “amazon” icerdigini test edin.

        expectedIcerik = "amazon";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Url amazon iceriyor, URL test PASSED");
        } else {
            System.out.println("Url amazon icermiyor, URL test FAILED");
        }

        //8. Sayfa handle degerini yazdirin
        System.out.println("Sayfanin handle degeri : " + driver.getWindowHandle());
        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin

        expectedIcerik="alisveris";
        String actualPageSource= driver.getPageSource();

        if (actualPageSource.contains(expectedIcerik)){
            System.out.println("Sayfa kaynak kodlari alisveris iceriyor, test PASSED");
        }else {
            System.out.println("Sayfa kaynak kodlari alisveris icermiyor, test FAILED");
        }

        //10. Sayfayi kapatin.
        Thread.sleep(3000);
        driver.close();
    }
}
