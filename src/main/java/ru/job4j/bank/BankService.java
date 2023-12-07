package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Класс описывает модель банковского сервиса
 * @author Ilya Galaktionov
 * @version 1.0
 */

public class BankService {
    /**
     * Хранения пользователей с привязанными к ним счетами
     * осуществляется в коллекции типа HashMap
     * объект user - ключ значения
     * List - список значений, содержащими счета пользоватлей Account
     */

    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить пользователя в системы
     * если такого пользователя нет
     * @param user добавляемый пользователь
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалить пользователья по номеру поспарта
     * @param passport номер паспорта пользователя, которого
     *                 нужно удалить
     */

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод позволяет добавить новый счет пользователя
     * @param passport номер паспорта пользователя
     * @param account новый счет пользователя
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Метод позволяет найти пользователя по номеру паспорта
     * @param passport номер паспорта искомого пользователя
     * @return возвращает объек пользователя
     * или null если пользователь не найден
     */

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позволяет найти пользователя по реквизитам счета
     * @param passport номер паспорта искомого пользователя
     * @param requisite реквизиты счета искомого пользователя
     * @return возвращает искомый счет или null если счет или пользователь не найдены
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        return users.get(user)
                .stream()
                .filter(u -> u.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позволяет перечеслять деньги с одного счета на другой
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount сумма отправляемых денег
     * @return возвращает true если перевод прошел успешно,
     * false - перевод не выполнен
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
            Account srcAccount = findByRequisite(srcPassport, srcRequisite);
            Account destAccount = findByRequisite(destPassport, destRequisite);
            if (srcAccount == null || destAccount == null || srcAccount.getBalance() < amount) {
                return false;
            }
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
    }

    /**
     * Метод позволяет получить список счетов пользователя
     * @param user пользователь, у которого нужно получить список счетов
     * @return возвращает список счетов пользователя
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
