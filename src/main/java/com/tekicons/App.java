package com.tekicons;

import com.tekicons.dao.AccountDao;
import com.tekicons.entity.Account;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {

        AccountDao accountDao = new AccountDao();

        Account account = new Account();
        // account.setAccNum(1);
        account.setAccName("Shreya");
        account.setAddress("Hyd");
        account.setMobile("47896512");
        accountDao.saveAccount(account);

        List<Account> accounts = accountDao.getAccounts();
        accounts.forEach(ac -> System.out.println(ac.getAccName()));

    }
}
