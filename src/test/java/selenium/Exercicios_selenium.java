package selenium;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercicios_selenium {
    WebDriver driver;

    @Test
    public void testeFromularioSelenium() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Aline"); // primeiro nome
        driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Ayrão"); // ultimo nome
        driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[2]/div/textarea"))
                .sendKeys("Rua Elisa Batista de Lima, 85"); // endereço
        driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys("alineayrao@gmail.com"); // email
        driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("11981640373"); // Telefone
        driver.findElement(By.xpath("//*[@ng-model='radiovalue' and @value='FeMale']")).click(); // seleciona o radiobuton da tela
        // driver.quit(); //fecha o navegador e encerra o processo
        // driver.close(); //fecha o navegador se tiver uma aba só aberta ou a aba e não mata o processo

        Assert.assertTrue(driver.findElement(By.xpath("//*[@ng-model='radiovalue' and @value='FeMale']")).isSelected());
        // Assert.assertFalse("Elemento não selecionado",driver.findElement(By.xpath("//*[@ng-model='radiovalue' and
        // @value='FeMale']")).isSelected());// validar se não está criando um teste fake, msg será retornada no erro.

        driver.findElement(By.xpath("//input[@value='Movies']")).click(); // seleciona um checkbox
        Assert.assertTrue("Chekbox não selecionado",
                driver.findElement(By.xpath("//input[@value='Movies']")).isSelected());

        driver.findElement(By.xpath("//div[@id='msdd']")).click();// clica na lista
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(), 'Portuguese')]")).click(); // seleciona opção da lista
        driver.findElement(By.xpath("//a[contains(text(), 'English')]")).click(); // seleciona mais de uma opção da lista
                                                                                  
        boolean linguagemPortugueseSelecionada = driver
                .findElement(
                        By.xpath("//div[contains(text(), 'Portuguese') and @class='ui-autocomple-multiselect-item"))
                .isDisplayed();
        boolean linguagemEnglishSelecionada = driver
                .findElement(By.xpath("//div[contains(text(), 'English') and @class='ui-autocomple-multiselect-item"))
                .isDisplayed();

        Assert.assertTrue(driver
                .findElement(
                        By.xpath("//div[contains(text(), 'Portuguese') and @class='ui-autocomple-multiselect-item"))
                .isDisplayed());
        Assert.assertTrue(driver
                .findElement(By.xpath("//div[contains(text(), 'English') and @class='ui-autocomple-multiselect-item"))
                .isDisplayed());

        // WebElement selecElement = driver.findElement(By.xpath("//select[@id='Skills']"));
        Select selectObject = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
        selectObject.selectByVisibleText("Java");
        Select selectAnoAniversario = new Select(driver.findElement(By.xpath("//select[@id='yearbox']")));
        selectAnoAniversario.selectByVisibleText("1986");
        Select selectMes = new Select(driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[1]")));
        selectMes.selectByVisibleText("March");
        Select selectDia = new Select(driver.findElement(By.xpath("//select[@id='daybox']")));
        selectDia.selectByVisibleText("23");

        driver.findElement(By.xpath("//*[@id='firstpassword']")).sendKeys("Teste");
        driver.findElement(By.xpath("//*[@id='secondpassword']")).sendKeys("Teste");
        driver.findElement(By.xpath("//*[@id='submitbtn']")).click();

    }

    @AfterClass
    public void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
