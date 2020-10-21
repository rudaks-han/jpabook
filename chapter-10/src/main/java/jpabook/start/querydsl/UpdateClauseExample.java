package jpabook.start.querydsl;

import static jpabook.start.QMember.member;

import javax.persistence.EntityManager;

import com.mysema.query.jpa.impl.JPAUpdateClause;
import jpabook.start.Base;

public class UpdateClauseExample extends Base {

    public static void main(String[] args) {
        init();

        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        query(em);
        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void query(EntityManager em) {

        JPAUpdateClause updateClause = new JPAUpdateClause(em, member);
        long count = updateClause.where(member.id.eq(1L))
            .set(member.age, 20)
            .execute();

        System.out.println("----------- result -----------");
        System.out.println("count : " + count);
    }

}
