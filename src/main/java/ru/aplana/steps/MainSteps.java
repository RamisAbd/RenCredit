package ru.aplana.steps;

import io.qameta.allure.Step;
import ru.aplana.page.BasePage;
import ru.aplana.page.MainPage;

public class MainSteps extends BasePage {
    MainPage mainPage = new MainPage();
    @Step("Перейти в меню – Вклады")
    public void openDeposit(String text){
        mainPage.openDepositClick(text);
    }

    @Step("Выбрать – Рубли")
    public void selectRUBstep(String text){
        mainPage.selectRUB(text);
    }

    @Step("Поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        mainPage.fillField(field, value);
    }
    @Step("Выбрана ежемесячная капитализация")
    public void clickMonthlyСapitalization(){
        mainPage.clickMonthlyСapitalization();
    }
    @Step("Выбрано частичное снятие")
    public void partialWithdrawal(){
        mainPage.clickPartialWithdrawal();
    }
    @Step("Поле {0} имеют значение {1}")
    public void fillEquals(String field, String value){
        mainPage.fillEquals(field, value);
    }



}
