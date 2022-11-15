package selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimeiraClasseSelenium {
    
    @Test
    public void testeAberturaBrowser(){
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.qaacademy.com.br");
    }
    
}
