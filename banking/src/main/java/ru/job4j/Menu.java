package ru.job4j;

import ru.job4j.Exseptions.NotFoundUser;

import java.util.*;

public class Menu {
    Map<User, List<Account>> banking = new HashMap<>();

    public User foundUser(User user){
        if (banking.get(user) != null){
            return user;
        } else {
            throw new NotFoundUser("Not found User.");
        }
    }

    public void addUser(User user) {
        banking.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
    banking.remove(foundUser(user));
    }

    public void addAccountToUser(User user, Account account) {
            List<Account> accountList = banking.get(foundUser(user));
            accountList.add(account);
    }

    public void deleteAccountFromUser(User user, Account account) {
        List<Account> accountList = banking.get(foundUser(user));
        accountList.remove(account);
    }

    public List<Account> getUserAccounts (User user) {
        List<Account> accountList = banking.get(foundUser(user));
        return accountList;
    }
    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount){
        boolean result = false;
            List<Account> accountListOne = banking.get(foundUser(srcUser));
            List<Account> accountListTwo = banking.get(foundUser(dstUser));
            if (accountListOne.contains(srcAccount) & accountListTwo.contains(dstAccount)) {
                if (srcAccount.getValue() >= amount){
                    dstAccount.setValue(srcAccount.getValue() - amount);
                    srcAccount.setValue(srcAccount.getValue() - amount);
                    accountListOne.set(0, srcAccount);
                    accountListTwo.set(0, dstAccount);
                    result = true;
                }
            }
    return result;
    }
}
