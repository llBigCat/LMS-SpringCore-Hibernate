package com.llbigcat.repository;

import com.llbigcat.entities.Member;
import com.llbigcat.entities.enums.BookStatus;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MemberRepository implements IMemberRepository{

    private final SessionFactory sessionFactory;

    @Override
    public boolean create(Member member) {
        try(Session session = sessionFactory.openSession()){
            session.persist(member);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Member member) {
        try(Session session = sessionFactory.openSession()){
            session.merge(member);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Member member) {
        try(Session session = sessionFactory.openSession()){
            session.remove(member);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<Member> findById(Long id) {
        try(Session session = sessionFactory.openSession()){
            Member member = session.find(Member.class, id);
            return Optional.ofNullable(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        try(Session session = sessionFactory.openSession()){
            Query query = session.createQuery("FROM Member m WHERE m.email = :email", Member.class);
            query.setParameter("email", email);
            Member member = (Member) query.getSingleResult();
            return Optional.ofNullable(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Member> findByName(String name) {
        try(Session session = sessionFactory.openSession()){
            Query query = session.createQuery("FROM Member m WHERE m.name LIKE :name", Member.class);
            query.setParameter("name", "%" + name + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public Optional<Member> findByPhone(String phone) {
        try(Session session = sessionFactory.openSession()){
            Query query = session.createQuery("FROM Member m WHERE m.phone = :phone", Member.class);
            query.setParameter("phone", phone);
            Member member = (Member) query.getSingleResult();
            return Optional.ofNullable(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean canBorrowMoreBooks(Long memberId) {
        try(Session session = sessionFactory.openSession()){
            Query query = session.createQuery("SELECT COUNT(b) FROM Borrowing b WHERE b.member.id = :memberId AND b.status = :status", Long.class);
            query.setParameter("memberId", memberId);
            query.setParameter("status", BookStatus.BORROWED);
            Long count = (Long) query.getSingleResult();
            return count < 3;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
