package selenium;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercicios_selenium {
    WebDriver driver; 
    @Test
    public void testeFromularioSelenium() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Aline"); //primeiro nome
        driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Ayrão"); //ultimo nome
        driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[2]/div/textarea")).sendKeys("Rua Elisa Batista de Lima, 85"); //endereço
        driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys("alineayrao@gmail.com"); //email
        driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("11981640373"); //Telefone
        Thread.sleep(3000);
        //driver.quit(); //fecha o navegador e encerra o processo
        //driver.close(); //fecha o navegador se tiver uma aba só aberta ou a aba e não mata o processo
    }
    @AfterClass
    public void after() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
