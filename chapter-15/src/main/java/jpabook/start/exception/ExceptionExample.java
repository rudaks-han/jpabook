package jpabook.start.exception;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpabook.start.batchsize.Member3;
import jpabook.start.batchsize.Order2;
import jpabook.start.exception.jpo.member.Member;

public class ExceptionExample {

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

        Member member1 = null;

        try {
            member1 = new Member(1L, "한경만");
            em.persist(member1);
        } catch (Exception e) {
            //e.printStackTrace();
        }

        //em.clear();

        member1.setName("한경만1");
        member1.setName("한경만2");
        System.out.println("________");
        System.out.println(member1);

        em.flush();
        em.clear();

    }

}
