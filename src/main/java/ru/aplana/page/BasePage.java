package ru.aplana.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.steps.BaseSteps;



public class BasePage {
    public BasePage () {
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }
    public void clicker(WebElement webElement){
        new WebDriverWait(BaseSteps.getDriver(), 10).until(ExpectedConditions.visibilityOf(webElement));
        Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(webElement).perform();
        webElement.click();
    }
    public void setText(WebElement webElement, String text ){
        new WebDriverWait(BaseSteps.getDriver(), 10).until(ExpectedConditions.visibilityOf(webElement));
        Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(webElement).perform();
        webElement.sendKeys(text);
    }
}
