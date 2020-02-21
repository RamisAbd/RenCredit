package ru.aplana.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.steps.BaseSteps;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class MainPage extends BasePage {
    JavascriptExecutor executor = (JavascriptExecutor)BaseSteps.getDriver();
    @FindBy (xpath = "//a[@class='service__title-action']")
    WebElement elementPlus;
    @FindBy(xpath = "//span[@class='calculator__currency-field-btn']")
    WebElement idRUB;
    @FindBy(xpath = "//input[@name='amount']")
    WebElement amount;
    @FindBy(xpath = "//div[@class= 'jq-selectbox__trigger']")
    WebElement elementStrela;
    @FindBy(xpath = "//li[text()='6 месяцев']")
    WebElement month;
    @FindBy(xpath = "//input[@name='replenish']")
    WebElement replenish;
    @FindBy(xpath = "(//span[@class='calculator__check-block-input']//div)[5]" )
    WebElement monthlyСapitalization;
    @FindBy(xpath = "(//div[@class='jq-checkbox calculator__check'])[2]" )
    WebElement partialWithdrawal;
    @FindBy(xpath = "//span[@class='js-calc-rate']")
    WebElement rate;
    @FindBy(xpath = "//span[@class='js-calc-earned']")
    WebElement earned;
    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    WebElement replenishEnd;
    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement result;

    public void openDepositClick(String text) {
        WebElement openDeposit = elementPlus.findElement(By.xpath("//span[text()='"+text +"']"));
        Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(openDeposit).build().perform();
        new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(openDeposit));
        openDeposit.click();
    }
    public  void  selectRUB(String text){

        WebElement elementRUB = idRUB.findElement(By.xpath("//span[text()='"+text +"']"));
        new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.visibilityOf(elementRUB));
        executor.executeScript("arguments[0].scrollIntoView(true);", elementRUB);
        executor.executeScript("arguments[0].click();", elementRUB);
    }
    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Сумма вклада":
                new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.visibilityOf(amount));
                setText(amount, value);

                break;
            case  "На срок":
                new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(elementStrela));
                elementStrela.click();
                new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.visibilityOf(month));
                new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(month));
                clicker(month);
                break;
            case  "Ежемесечное пополнение":
                new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.visibilityOf(replenish));
                setText(replenish, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickMonthlyСapitalization(){
        new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(monthlyСapitalization));
        monthlyСapitalization.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickPartialWithdrawal(){
        new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(monthlyСapitalization));
        partialWithdrawal.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void fillEquals(String fieldName, String value){
        switch (fieldName){
            case  "Накопительная ставка":
                new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.visibilityOf(rate));
                assertEquals(rate.getText(),value);

                break;
            case  "Начислено":
                new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.visibilityOf(earned));
                assertEquals(earned.getText(),value);
                break;
            case  "Пополнение за 6 месяцев":
                new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.visibilityOf(replenishEnd));
                assertEquals(replenishEnd.getText(),value);
                break;
            case  "К снятию":
                new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.visibilityOf(result));
                assertEquals(result.getText(),value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }



    public MainPage () {
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }
}
