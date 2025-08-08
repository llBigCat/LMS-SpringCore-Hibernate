package com.llbigcat.repository;

import com.llbigcat.entities.Borrowing;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BorrowingRepository implements IBorrowingRepository{

    private final SessionFactory sessionFactory;

    @Override
    public boolean save(Borrowing borrowing) {
        try(Session session = sessionFactory.openSession()){
            session.persist(borrowing);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Borrowing borrowing) {
        try(Session session = sessionFactory.openSession()){
            session.merge(borrowing);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
