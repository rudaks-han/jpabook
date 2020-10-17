package jpabook.start.twoway;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TwoWayExample {

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
        Team2 team = new Team2("team1", "팀1");
        em.persist(team);

        Member2 member1 = new Member2("member1", "회원1");
        member1.setTeam(team);
        em.persist(member1);

        Member2 member2 = new Member2("member2", "회원2");
        member2.setTeam(team);
        em.persist(member2);

        // 이 동작이 수행되지 않으면 FK가 설정되어 있지 않은 1차캐시에만 영속화 된 상태이다. SELECT 쿼리로 조회해봤자 list 사이즈 0이다.
        em.flush();
        em.clear();

    }

    public static void query(EntityManager em) {
        Team2 team = em.find(Team2.class, "team1");
        System.err.println("member size: " + team.getMembers().size());

        for (Member2 member: team.getMembers()) {
            System.out.println("id : " + member.getId() + ", username: " + member.getUsername() + " ,teamName: " + member.getTeam().getName());
        }
    }
}
