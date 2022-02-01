package hellojpa;

import hellojpa.jpashop.Book;
import hellojpa.jpashop.Order;
import hellojpa.jpashop.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);
            tx.commit();
        } catch (Exception e) {
            System.out.println("erro!");
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
