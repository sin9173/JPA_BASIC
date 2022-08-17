package hellojpa;

import hellojpa.config.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        enumTest();
    }


    public static void enumTest() {
        EntityManagerFactory emf = JpaConfig.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member2 member = new Member2();
            member.setId(1L);
            member.setUsername("A");
            member.setRoleType(RoleType.USER);

            em.persist(member);

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    public static void entityManager () {
        EntityManagerFactory emf = JpaConfig.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //비영속 상태
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            //영속성 컨테이너에 저장(1차 캐시에 저장됨)
            System.out.println("=== BEFORE ====");
            em.persist(member);
            System.out.println("=== AFTER ===");

            //1차 캐시에서 가져옴 (Select 가 발생하지 않음)
            Member findMember = em.find(Member.class, 101L);

            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    public static void entityManager2 () {
        EntityManagerFactory emf = JpaConfig.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            //같은걸 가져올때 쿼리를 한번만 수행 (1차캐시에 저장 후 가져옴)
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("findMember1.id = " + findMember1.getId());
            System.out.println("findMember1.name = " + findMember1.getName());

            System.out.println("findMember2.id = " + findMember2.getId());
            System.out.println("findMember2.name = " + findMember2.getName());

            System.out.println("result = " + (findMember1 == findMember2));

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
    public static void entityManager3 () {
        EntityManagerFactory emf = JpaConfig.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //비영속 상태
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            //영속성 컨테이너에 저장(1차 캐시에 저장됨) 하고 insert 쿼리를 생성해 저장
            em.persist(member1);
            em.persist(member2);
            System.out.println("================================");

            //데이터베이스에 쿼리를 보냄
            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
    
    public static void detach() {
        EntityManagerFactory emf = JpaConfig.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //영속
            Member member = em.find(Member.class, 101L); //1차 캐시에 저장
            member.setName("AAAAA"); //값 변경
            
            //영속상태를 해제 (준영속 상태, update 가 발생하지 않음)
            em.detach(member); //

            em.clear(); //모든 영속상태를 해제

            Member member2 = em.find(Member.class, 101L); //1차 캐시에 저장

            System.out.println("================================");

            //데이터베이스에 쿼리를 보냄
            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    public static void insert() {
        EntityManagerFactory emf = JpaConfig.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //INSERT
            Member member = new Member();

            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    public static void select() {
        EntityManagerFactory emf = JpaConfig.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //SELECT
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            findMember.setName("HelloJPA"); // update 수행 (1차 캐시에 있는 스냅샷과 현재값을 비교함)

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    public static void jpqlSelect() {
        EntityManagerFactory emf = JpaConfig.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //JPQL SELECT
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList(); //Member 객체를 대상으로 조회

            for(Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
