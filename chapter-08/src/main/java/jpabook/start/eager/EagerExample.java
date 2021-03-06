package jpabook.start.eager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EagerExample {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            testSave(em);  //비즈니스 로직
            query(em);
            tx.commit();//트랜잭션 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void testSave(EntityManager em) {
        Team1 team = new Team1("team1", "팀1");
        em.persist(team);

        Member1 member1 = new Member1("member1", "회원1", team);
        member1.setTeam(team);
        em.persist(member1);

        Member1 member2 = new Member1("member2", "회원2", team);
        member2.setTeam(team);
        em.persist(member2);

        em.flush();
        em.clear();
    }

    public static void query(EntityManager em) {
        Member1 member = em.find(Member1.class, "member1");

        System.out.println("----------------------------");
        System.out.println("getTeam()");
        System.out.println("----------------------------");

        Team1 team = member.getTeam();

        System.out.println(team.getName());
    }

}
