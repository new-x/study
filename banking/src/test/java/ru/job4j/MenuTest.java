package ru.job4j;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    @Test
    public void addAccountToUser() {
        Menu menu = new Menu();
        User user = new User("Andrey", "Passport");
        User user1 = new User("Andrey1", "Passport1");
        Account account = new Account(6616, 622891);
        Account account1 = new Account(6626, 122891);
        Account account2 = new Account(6636, 222891);
        menu.addUser(user1);
        menu.addUser(user);
        menu.addAccountToUser(user, account);
        menu.addAccountToUser(user, account1);
        menu.addAccountToUser(user, account2);
        menu.deleteAccountFromUser(user, account1);
        List<Account> result  = menu.getUserAccounts(user);
        assertThat(result, is(-1));
    }
    @Test
    public void transferUserAccountOneToUserAccountTwo() {
        Menu menu = new Menu();
        User user = new User("Andrey", "Passport");
        User user1 = new User("Andrey1", "Passport1");
        Account account = new Account(5000, 1040);
        Account account1 = new Account(5500, 1060);
        Account account2 = new Account(0, 1080);
        menu.addUser(user1);
        menu.addUser(user);
        menu.addAccountToUser(user, account);
        menu.addAccountToUser(user1, account1);
        menu.addAccountToUser(user1, account2);
        boolean result  = menu.transferMoney(user1, account1, user, account, 1050);
        assertThat(result, is(true));
    }
}
