package com.twu.biblioteca;

import com.twu.biblioteca.control.UserAccountRepository;
import com.twu.biblioteca.core.UserAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserAccountRepositoryTest {
    private UserAccountRepository userAccountRepository = new UserAccountRepository();

    @Test
    public void should_return_one_user_account_when_get_one() {
        UserAccount expectedUserAccount = new UserAccount("001-0001", "password1", "user1", "user1@163.com", "12345678901");

        UserAccount actualUserAccount = userAccountRepository.getOne("001-0001");

        assertTrue(actualUserAccount != null);
        assertEquals(expectedUserAccount, actualUserAccount);
    }
}