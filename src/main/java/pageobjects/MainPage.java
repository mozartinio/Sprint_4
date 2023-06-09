package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class MainPage {
    private WebDriver driver;

    //локатор лого яндекс
    private final By logoYandex = By.className("Header_LogoYandex__3TSOI");
    //локатор лого самокат
    private final By logoSamokat = By.className("Header_LogoScooter__3lsAR");
    //локатор кнопки "Заказать" в хедере
    private By headerOrderButton = By.className("Button_Button__ra12g");
    //локатор кнопки "Статус заказа"
    private final By headerStatusButton = By.className("Header_Link__1TAG7");
    //локатор кнопки "Заказать"
    private final By orderButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");

    // Локаторы кнопок с вопросами
    public static final String[] questionArrayButtons = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};
    //Локаторы текстов "Вопросы о важном
    public static final String[]  textQuestionsAboutImportantArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void pushHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    public void pushHeaderStatusButton() {
        driver.findElement(headerStatusButton).click();
    }

    public void pushOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void pushLogoYandex() {
        driver.findElement(logoYandex).click();
    }

    public void scrollToPushOrderButton() {
        WebElement element = driver.findElement(orderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //метод для скролла до списка "Вопросы о важном"
    public void scrollPageToQuestionsAboutImportant(){
        WebElement lastQuestionArrow = driver.findElement(By.id(questionArrayButtons[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
    }

    //Клик по кнопке вопроса
    public void pushQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
    }
}
