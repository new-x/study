package ru.job4j;

import java.util.*;

public class Menu {
    Map<User, List<Account>> banking = new HashMap<>();

    public void addUser(User user) {
        banking.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
    banking.remove(user);
    }

    public void addAccountToUser(User user, Account account) {
        List<Account> accountList = banking.get(user);
        accountList.add(account);
    }

    public void deleteAccountFromUser(User user, Account account) {
        List<Account> accountList = banking.get(user);
        accountList.remove(account);
    }

    public List<Account> getUserAccounts (User user) {
        List<Account> accountList = banking.get(user);
        return accountList;
    }

    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount){
        boolean result = false;
    List<Account> accountListOne = banking.get(srcUser);
    List<Account> accountListTwo = banking.get(dstUser);
    if (accountListOne.contains(srcAccount) & accountListTwo.contains(dstAccount)) {
        if (srcAccount.getValue() > amount){
            result = true;
        }
    }
    return result;
    }

}
