package PageObjects;
import Utilities.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class Test extends BaseClass {

    private static Test instance;
    WebDriverWait wait = new WebDriverWait(driver, 30);
    private JavascriptExecutor js;
    private WebElement user;


    public Test(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        initializeElements();
    }
    public static Test getInstance(WebDriver driver, WebDriverWait wait) {
        if (instance == null) {
            instance = new Test(driver, wait);

        }
        return instance;
    }

    public void initializeElements() {

//Example to initialize elements if there are a lot of implementation and we need to reuse the elements
        user =  driver.findElement(By.id("username"));

          }
    public void signin() {

        user.sendKeys("juanes20272-jewe@force.com");
        driver.findElement(By.id("password")).sendKeys("Vrpjuanes1");
        driver.findElement(By.id("Login")).click();

    }
        public void account() {
            driver.get("https://power-enterprise-64.lightning.force.com/lightning/o/Account/home");
            driver.findElement(By.xpath("//button[contains(@class, 'slds-button_brand') and contains(text(), 'Agregar una cuenta')]")).click();
            driver.findElement(By.xpath("//input[contains(@class, 'slds-input') and @name='Name']")).sendKeys("Test");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'slds-button_brand') and @name='SaveEdit']")));
            driver.findElement(By.xpath("//button[contains(@class, 'slds-button_brand') and @name='SaveEdit']")).click();
    }

    public void validateAccount() throws InterruptedException {

        WebElement elemento = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']"));
        String textoElemento = elemento.getText();
        if (textoElemento.contains("Test")) {
            System.out.println("The word 'Test' is present.");
        } else {
            System.out.println("The word 'Test' is not present.");
        }


    }
    public void editAccount() {

        driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral' and @name='Edit']")).click();
        WebElement name = driver.findElement(By.xpath("//input[contains(@class, 'slds-input') and @name='Name']"));
        name.clear();
        name.sendKeys("TestUpdate");
        driver.findElement(By.xpath("//button[contains(@class, 'slds-button_brand') and @name='SaveEdit']")).click();

    }
    public void validateUpdate() throws InterruptedException {

        WebElement elemento2 = driver.findElement(By.xpath("//lightning-formatted-text[contains(text(),'TestUpdate')]"));
        String textoElemento2 = elemento2.getText();
        System.out.println((textoElemento2));
        // Verify "TestUpdate"
        if (textoElemento2.contains("TestUpdate")) {
            System.out.println("La word 'TestUpdate' is present");
        } else {
            System.out.println("La word 'TestUpdate' is not present");
        }
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon-border-filled']")).click();
       //I delete the account to create a maintainable script
        driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Eliminar']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Eliminar' and contains(@class, 'slds-button')]")));
        driver.findElement(By.xpath("//button[@title='Eliminar' and contains(@class, 'slds-button')]")).click();


    }
}

