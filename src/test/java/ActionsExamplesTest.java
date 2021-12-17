import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public  class ActionsExamplesTest {
    static WebDriver driver;
    private static final String BASE_URL = "https://lekopttorg.ru/";

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

    @Test // переход на страницу "Акции"
    void findElementAction(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='% Акции']")))
                .click()
                .build()
                .perform();
        Assertions.assertEquals("https://lekopttorg.ru/actions/","https://lekopttorg.ru/actions/");
    }

    @Test // ввод в поисковой строке слова "цитрамон"
    void inputText() {
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.id("title-search-input")),"цитрамон").pause(2000)
                .moveToElement(driver.findElement(By.xpath("//button[@class='top-search__btn']")))
                .click()
                .build()
                .perform();
        driver.findElement(By.xpath("//a[@data-name='Цитрамон-П тб №20 ']")).click();
        Assertions.assertEquals("https://lekopttorg.ru/catalog/index.php?q=%D1%86%D0%B8%D1%82%D1%80%D0%B0%D0%BC%D0%BE%D0%BD&s=",
                "https://lekopttorg.ru/catalog/index.php?q=%D1%86%D0%B8%D1%82%D1%80%D0%B0%D0%BC%D0%BE%D0%BD&s=");
        }

    @Test // переход на страницу "Статус заказа" и ввод номера "123" в строку
    void findAndClickTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Статус заказа']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Номер заказа']")).sendKeys("123");
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='slider__btn btn btn_big btn_green fs0']")).click();
        Assertions.assertEquals("123","123");
    }

    @AfterEach
    void exit(){
        driver.quit(); // завершение работы теста
    }
}
