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
        Thread.sleep(5000);//espera para não dar erro entre os comandos
        driver.findElement(By.xpath("//html/body/div[2]/div/div/div[1]/button[1]")).click(); //localiza o cookie e clica em aceitar
        Thread.sleep(1000);//espera para não dar erro entre os comandos
        driver.findElement(By.xpath("//*[@id='dataItem-k3hb7c5j-comp-k0wqferu']/a")).click(); //clica no botão do linkedin da pagina
    }

    @Test
    public void testeSeleniumEnviarTextoParaTela() throws InterruptedException{
        WebDriver driver = new ChromeDriver(); //abre o navegador
        driver.get("https://www.qaacademy.com.br"); //abre o site desejado
        Thread.sleep(5000);//espera para não dar erro entre os comandos
        driver.findElement(By.xpath("//html/body/div[2]/div/div/div[1]/button[1]")).click(); //localiza o cookie e clica em aceitar
        Thread.sleep(1000);//espera para não dar erro entre os comandos
        driver.findElement(By.xpath("//*[@id='input_comp-k37gdip8']")).click(); //clica no campo nome
        driver.findElement(By.xpath("//*[@id='input_comp-k37gdip8']")).sendKeys("Aline Ayrão");//envia o texo para o campo nome
        driver.findElement(By.xpath("//*[@id='input_comp-k37gdiq1']")).click(); //clica no campo E-mail
        driver.findElement(By.xpath("//*[@id='input_comp-k37gdiq1']")).sendKeys("alineayrao@gmail.com");//envia o texo para o campo e-mail
        driver.findElement(By.xpath("//*[@id='comp-k37gdiro']/button")).click(); //clica em enviar
        
    }
}
