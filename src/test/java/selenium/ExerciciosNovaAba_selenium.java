package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosNovaAba_selenium {
    static WebDriver driver;

    @Before
    public void iniciaTeste(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Windows.html");

    }
    @Test
    public void testeJanelasWindows() throws InterruptedException{
        driver.findElement(By.linkText("click")).click();
        Object [] janelas = driver.getWindowHandles().toArray(); //mapeando as janelas (e/ou tab) abertas
        driver.switchTo().window(janelas[1].toString()); //faz a troca de janelas/abas 
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev/")); //valida se a url está aberta na janela/aba

    }

    @AfterClass
    public static void after() throws InterruptedException {
        driver.quit();
    }
}
