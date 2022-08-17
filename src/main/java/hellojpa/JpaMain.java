package hellojpa;

import hellojpa.config.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        test1();
//        EntityManagerFactory emf = JpaConfig.getEntityManagerFactory();
//
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();

//        try {
            //INSERT
//            Member member = new Member();

//            member.setId(2L);
//            member.setName("HelloB");

//            em.persist(member);

            //SELECT
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

//            findMember.setName("HelloJPA"); // update 수행

            //JPQL SELECT
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList(); //Member 객체를 대상으로 조회
//
//            for(Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();
    }

    public static void test1 () {
        EntityManagerFactory emf = JpaConfig.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            //영속성 컨테이너에 저장
            System.out.println("=== BEFORE ====");
            em.persist(member);
            System.out.println("=== AFTER ===");

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
