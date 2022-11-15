package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ExercicioDragAndDrop_selenium {
    WebDriver driver;

    @Before
    public void iniciaTeste(){
        setupChromeDriver();
        driver.get("https://demo.automationtesting.in/Windows.html");
    }
    
    @Test
    public void testeDragAndDrop(){
        WebElement elementoInicial = driver.findElement(By.xpath("//img[@id='node']"));
        WebElement areaDestino = driver.findElement(By.id("//div[@id='droparea']"));
        Actions actionProvider = new Actions(driver);
        actionProvider.dragAndDrop(elementoInicial, areaDestino).build().perform();
    }

    @AfterClass
    public void after() throws InterruptedException {
        driver.quit();
    }

    public void setupChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true); //setup chrome headless (executa em segundo plano)
        options.setAcceptInsecureCerts(true); //executa os testse mesmo com certificado inseguro
        options.addArguments("disable-popup-blocking"); // desabilita os pop-ups, pode add mais option por string ou lista atraves desse add.Arguments
        driver = new ChromeDriver(options); //inicializa com todas as opções setadas a cima.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

    }
}
