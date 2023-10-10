package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка
 * @author Ilya Galaktionov
 * @version 1.0
 */

public class User {
    /**
     * Хранение номера паспорта осуществляется в поле типа String
     */
    private String passport;
    /**
     * Хранение имени пользователя осуществляется в поле типа String
     */
    private String username;
    /**
     * Конструктор для создания пользователя и иницилизации полей
     * @param passport паспорт пользователя
     * @param username имя пользователя
     */

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить номер паспорта пользователя
     * @return возвращает номер паспорта пользователя
     */

    public String getPassport() {
        return passport;
    }
    /**
     * Метод позволяет установить номер паспорта пользователя
     * @param passport устанавливает новый номер паспорта пользователя
     */

    public void setPassport(String passport) {
        this.passport = passport;
    }
    /**
     * Метод для получения имени пользователя
     * @return возвращает имя пользователя
     */

    public String getUsername() {
        return username;
    }
    /**
     * Метод позволяет установить имя пользователя
     * @param username устанавливает новое имя пользователя
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод сравнивает пользователей по паспорту
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод позволяет получить hashcode объекта по полю паспорта
     * @return возвращает численное значение hashcode
     */

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
