package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosAlertas_selenium {
    WebDriver driver;

    @Before
    public void iniciaTeste(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Alerts.html");

    }
    @Test
    public void testesAlertasSimples()throws InterruptedException{
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAlerta = alert.getText();
        String mensagemEsperada = "I am an alert box!";
        Thread.sleep(20000);
        alert.accept();
        Assert.assertEquals(mensagemEsperada, mensagemAlerta);

    }
    @Test
    public void testesAlertasOkeCancela()throws InterruptedException{
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAlerta = alert.getText();
        String mensagemEsperada = "Press a Button !";
        Thread.sleep(20000);
        alert.dismiss();
        Assert.assertEquals(mensagemEsperada, mensagemAlerta);

    }
    @Test
    public void testesAlertasComPrompt()throws InterruptedException{
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("QA Academy | Formação em Automatização de testes web");
        Thread.sleep(20000);
        alert.accept();

    }
    @AfterClass
    public void after() throws InterruptedException {
        driver.quit();
    }
}
