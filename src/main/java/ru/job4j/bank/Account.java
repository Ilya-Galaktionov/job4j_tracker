package ru.job4j.bank;

import java.util.Objects;
/**
 * Класс описывает модель счета пользователя банка
 * @author Ilya Galaktionov
 * @version 1.0
 */

public class Account {
    /**
     * Хранение реквизитов счета осуществляется в поле типа String
     */
    private String requisite;
    /**
     * Хранение баланса счета пользователя осуществляется в поле типа double
     */
    private double balance;
    /**
     * Конструктор для создания пользователя и иницилизации полей
     * @param requisite реквизиты счета пользователя
     * @param balance баланс счета пользователя
     */

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }
    /**
     * Метод позволяет получить реквизиты счета пользователя
     * @return возвращает реквизиты счета пользователя
     */

    public String getRequisite() {
        return requisite;
    }
    /**
     * Метод позволяет установить реквизиты счета пользователя
     * @param requisite устанавливает новые реквизиты счета пользователя
     */

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }
    /**
     * Метод позволяет получить баланс счета пользователя
     * @return возвращает баланс счета пользователя
     */

    public double getBalance() {
        return balance;
    }
    /**
     * Метод позволяет установить баланс счета пользователя
     * @param balance устанавливает новый баланс счета пользователя
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }
    /**
     * Метод сравнивает пользователей по реквезитам
     * @param o объект, с которым сравнивается пользователь
     * @return возвращает true, если пользователь и объект равны,
     * false если объект и пользователь не равны или o равен null
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }
    /**
     * Метод позволяет получить hashcode объекта по полю реквизиты
     * @return возвращает численное значение hashcode
     */

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
