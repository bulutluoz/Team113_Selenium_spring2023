package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_MahserinDortAtlisi {
    public static void main(String[] args) {

        // 1- driver icin gerekli ayarlamalari yap
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver");
        // 2- webDriver olustur
        WebDriver driver = new ChromeDriver();
        // 3- window'u maximize yap
        driver.manage().window().maximize();
        // 4- gecikmeler icin maximum bekleme suresi tanimla
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // bu 4 adim her testin basinda yapacagimiz islemlerdir
    }
}
