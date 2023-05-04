package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Xpath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna basin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        //3- Delete butonu’nun gorunur oldugunu test edin

        WebElement deleteButtonElementi= driver.findElement(By.xpath("//*[text()='Delete']"));
        if (deleteButtonElementi.isDisplayed()){
            System.out.println("Delete button testi PASSED");
        }else {
            System.out.println("Delete button testi FAILED");
        }

        Thread.sleep(3000);
        //4- Delete tusuna basin
        deleteButtonElementi.click();
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addElementsElementi= driver.findElement(By.xpath("//h3"));

        // driver.findElement(By.tagName("h3"))

        if (addElementsElementi.isDisplayed()){
            System.out.println("Add/Remove Elements testi PASSED");
        }else {
            System.out.println("Add/Remove Elements testi FAILED");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
