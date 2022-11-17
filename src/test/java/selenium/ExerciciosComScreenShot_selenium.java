package selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosComScreenShot_selenium {
    static WebDriver driver;

    @Before
    public void iniciaTeste(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Windows.html");

    }
    @Test
    public void testeJanelasWindows() throws InterruptedException, IOException{
        driver.findElement(By.linkText("click")).click();
        screenShot("Janela Windows 1");
        Object [] janelas = driver.getWindowHandles().toArray(); //mapeando as janelas (e/ou tab) abertas
        driver.switchTo().window(janelas[1].toString()); //faz a troca de janelas/abas 
        screenShot("Tab Navegador");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev/")); //valida se a url está aberta na janela/aba

    }
    public void screenShot(String nomeScreenShot) throws IOException{
        TakesScreenshot screenshot = (TakesScreenshot) driver; // convertendo o driver em takescreenshot
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE); //tira o screenshot e transforma para o tipo File
        FileUtils.copyFile(arquivo, new File("output"+File.separator+nomeScreenShot+"_screenShot.jpg")); //grava os bytes do arquivo para sistema operacional
    }

    @AfterClass
    public static void after() throws InterruptedException {
        driver.quit();
    }
}
