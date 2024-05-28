package com.tekicons.dao;

import com.tekicons.config.HibernateConfig;
import com.tekicons.entity.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountDao {

    public void saveAccount(Account account) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(account);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Account> getAccounts() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Account", Account.class).list();
        }
    }
}
