package Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    // локатор для кнопки принятия куки
    private final By cookieButton = By.id("rcc-confirm-button");
    private final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mozar\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", "C:\Users\mozar\Desktop\geckodriver-v0.33.0-win32\\geckodriver.exe");
//        driver = new FirefoxDriver();

        //открыть страницу Яндекс.Самокаты
        driver.get(URL);
        driver.findElement(cookieButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}