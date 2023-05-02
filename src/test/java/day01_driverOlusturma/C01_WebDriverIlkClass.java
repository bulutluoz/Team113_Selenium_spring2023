package day01_driverOlusturma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverIlkClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver");
        // windows kullanicilarinda sonda .exe olmali
        // mac kullanicilarinda .exe olmayacak

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
    }
}
