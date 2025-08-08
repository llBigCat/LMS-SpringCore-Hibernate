package com.llbigcat.repository;

import com.llbigcat.dtos.OverDueBorrowingDTO;
import com.llbigcat.entities.Borrowing;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Override
    public List<Borrowing> findAllOverdueBorrowing() {
        try(Session session = sessionFactory.openSession()){
            String nativeQuery = "SELECT * FROM borrowing b WHERE b.return_date IS NULL AND b.status = 'BORROWED' AND b.due_date < CURRENT_DATE";
            return session.createNativeQuery(nativeQuery, Borrowing.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public List<OverDueBorrowingDTO> findBorrowingsOverdueByDays(int days) {
        try(Session session = sessionFactory.openSession()){
            return (List<OverDueBorrowingDTO>) session
                    .createNativeQuery("CALL sp_getBorrowingsOverdueMoreThanDays(:days)",
                            "OverDueBorrowingMapping")
                    .setParameter("days", days)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
