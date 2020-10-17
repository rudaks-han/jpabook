package jpabook.start.onetomanytwoway;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToManyTwoWayExample {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            testSave(em);  //비즈니스 로직
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
        Member4 member1 = new Member4("회원1");
        Member4 member2 = new Member4("회원2");

        Team4 team = new Team4("팀1");
        team.getMembers().add(member1);
        team.getMembers().add(member2);

        em.persist(member1);
        em.persist(member2);
        em.persist(team);

        // 이 동작이 수행되지 않으면 FK가 설정되어 있지 않은 1차캐시에만 영속화 된 상태이다. SELECT 쿼리로 조회해봤자 list 사이즈 0이다.
        em.flush();
        em.clear();

    }

}
