import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AuthorizationTest {
    static WebDriver driver;
    private static final String BASE_URL = "https://www.culture.ru/auth/login";

    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));  // max время ожидание загрузки страницы
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // обязательно установить значение неявного ожидания
    }

    @BeforeEach
    void setUpBrowser(){
        driver.get(BASE_URL);
    }

    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow( () -> driver.navigate().to(BASE_URL),
                "Страница недоступна");
    }

    @Test
    void cultureAuthorization() {
        login();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[text()='Афиша']")))
                .click()
                .build()
                .perform();
    }

    @AfterEach
    void exit(){
        driver.quit(); // завершение работы теста
    }

    private void login() {
        driver.findElement(By.xpath("//span[text()='E-mail']")).click();
        driver.findElement(By.id("login")).sendKeys("ivanych19.77@mail.ru");
        driver.findElement(By.id("password")).sendKeys("daulmirra2014");
        driver.findElement(By.xpath("//div[text()='Войти']")).click();
    }
}
