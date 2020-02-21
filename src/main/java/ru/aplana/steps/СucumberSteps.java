package ru.aplana.steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;


public class СucumberSteps {
    MainSteps mainSteps = new MainSteps();
    @Когда("Выбрано «(.*)»")
    public void menuItem(String text){
        mainSteps.openDeposit(text);
    }
    @И("Выбрать – (.*)")
    public void selectRUB(String text){
        mainSteps.selectRUBstep(text);
    }

    @Когда("Заполнены поля:")
    public void заполненыПоля(DataTable name) {
        name.asMap(String.class, String.class)
                .forEach((field, value) -> mainSteps.fillField(field.toString(),value.toString()));

    }

    @И("Выбрана Ежемесечная капитализация")
    public void выбранаЕжемесечнаяКапитализация() {
        mainSteps.clickMonthlyСapitalization();
    }

    @Тогда("Значение полей равны:")
    public void значениеПолейРавны(DataTable name) {
        name.asMap(String.class, String.class)
                .forEach((field, value) -> mainSteps.fillEquals(field.toString(),value.toString()));

    }
}
