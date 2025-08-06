package com.llbigcat.repository;

import com.llbigcat.entities.Book;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BookRepository implements IBookRepository{
    private final SessionFactory sessionFactory;
    @Override
    public Optional<Book> findById(Long id) {
        try(Session session = sessionFactory.openSession()){
            Book book = session.find(Book.class, id);
            return Optional.ofNullable(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from Book", Book.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public boolean create(Book book) {
        try(Session session = sessionFactory.openSession()){
            session.persist(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Book book) {
        try(Session session = sessionFactory.openSession()){
            session.merge(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Book book) {
        try(Session session = sessionFactory.openSession()){
            session.remove(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> search(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return List.of();
        }

        try (Session session = sessionFactory.openSession()) {
            StringBuilder queryBuilder = getStringBuilder(params);

            Query query = session.createQuery(queryBuilder.toString(), Book.class);

            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    //In case of title, best fit search
                    if ("title".equals(entry.getKey())) {
                        query.setParameter("title", "%" + entry.getValue() + "%");
                    } else {
                        query.setParameter(entry.getKey(), entry.getValue());
                    }
                }
            }

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<Book> topBorrowedBooks(int limit) {
        try (Session session = sessionFactory.openSession()) {
            //TODO: Add more
            return List.of();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    private static StringBuilder getStringBuilder(Map<String, Object> params) {
        StringBuilder queryBuilder = new StringBuilder("FROM Book b WHERE 1=1");

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                switch (entry.getKey()) {
                    case "title" -> queryBuilder.append(" AND LOWER(b.title) LIKE LOWER(:title)");
                    case "category" -> queryBuilder.append(" AND LOWER(b.category) = LOWER(:category)");
                    case "available" -> queryBuilder.append(" AND b.available = :available");
                    case "createdAt" -> queryBuilder.append(" AND b.createdAt = :createdAt");
                    case "version" -> queryBuilder.append(" AND b.version = :version");
                }
            }
        }
        return queryBuilder;
    }
}
