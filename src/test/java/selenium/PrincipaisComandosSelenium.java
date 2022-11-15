package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrincipaisComandosSelenium {
    @Test
    public void testeSeleniumClick() throws InterruptedException{
        WebDriver driver = new ChromeDriver(); //abre o navegador
        driver.get("https://www.qaacademy.com.br"); //abre o site desejado
        Thread.sleep(3000);//espera para não dar erro entre os comandos
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/botton[1]")).click(); //localiza o cookie e clica em aceitar
        Thread.sleep(1000);//espera para não dar erro entre os comandos
        driver.findElement(By.xpath("//*[@id='img_1_comp-k0wqferu']/img")).click(); //clica no botão do linkedin da pagina
    }

    @Test
    public void testeSeleniumEnviarTextoParaTela() throws InterruptedException{
        WebDriver driver = new ChromeDriver(); //abre o navegador
        driver.get("https://www.qaacademy.com.br"); //abre o site desejado
        Thread.sleep(3000);//espera para não dar erro entre os comandos
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/botton[1]")).click(); //localiza o cookie e clica em aceitar
        Thread.sleep(1000);//espera para não dar erro entre os comandos
        driver.findElement(By.xpath("//*[@placeholder='Nome']")).click(); //clica no campo nome
        driver.findElement(By.xpath("//*[@placeholder='Nome']")).sendKeys("Aline Ayrão");//envia o texo para o campo nome
        driver.findElement(By.xpath("//*[@placeholder='Email']")).click(); //clica no campo E-mail
        driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("alineayrao@gmail.com");//envia o texo para o campo e-mail
        driver.findElement(By.xpath("//*[@id='comp-k37gdiro']/button")).click(); //clica em enviar
        
    }
}
