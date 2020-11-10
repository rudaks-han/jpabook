package jpabook.start.study;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Example {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            save(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void save(EntityManager em) {
        Team team = new Team(1L, "개발팀");
        Member member1 = new Member(1L, "한경만", team);
        Member member2 = new Member(2L, "정은영", team);

        team.getMembers().add(member1);
        team.getMembers().add(member2);

        em.persist(team);


        team.getMembers().clear();
/*        Member findMember1 = em.find(Member.class, 1L);
        Member findMember2 = em.find(Member.class, 2L);

        em.remove(findMember1);
        em.remove(findMember2);*/


    }


}
