package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosFrame_selenium {
    WebDriver driver;

    @Before
    public void iniciaTeste(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Windows.html");
    }
    
    @Test
    public void testeIFrameSimples(){
        driver.switchTo().frame("singleframe"); //muda o contexto do driver para o frame
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Teste QA Academy");
        driver.switchTo().defaultContent(); //voltar para o contexto anterior
    }

    @AfterClass
    public void after() throws InterruptedException {
        driver.quit();
    }
}
