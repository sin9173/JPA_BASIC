package hellojpa;

import hellojpa.config.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = JpaConfig.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();
    }
}
