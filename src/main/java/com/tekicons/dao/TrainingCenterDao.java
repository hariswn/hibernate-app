package com.tekicons.dao;

import com.tekicons.config.HibernateConfig;
import com.tekicons.entity.onetomany.TrainingCenter;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TrainingCenterDao {

    public void saveTrainingCenter(TrainingCenter trainingCenter) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(trainingCenter);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateTrainingCenter(TrainingCenter trainingCenter) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(trainingCenter);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteTrainingCenter(int id) {

        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a TrainingCenter object
            TrainingCenter trainingCenter = session.get(TrainingCenter.class, id);
            if (trainingCenter != null) {
                session.delete(trainingCenter);
                System.out.println("TrainingCenter is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public TrainingCenter getTrainingCenter(int id) {

        Transaction transaction = null;
        TrainingCenter trainingCenter = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an TrainingCenter object
            trainingCenter = session.get(TrainingCenter.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return trainingCenter;
    }
}
