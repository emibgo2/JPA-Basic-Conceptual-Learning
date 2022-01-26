package hellojpa;

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

            // 영속
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();

            System.out.println("==============");
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
