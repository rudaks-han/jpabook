package jpabook.start.querydsl;

import javax.persistence.EntityManager;

import com.mysema.query.jpa.impl.JPAQuery;
import jpabook.start.Base;
import jpabook.start.Member;

import static jpabook.start.QMember.member;

import java.util.List;

public class QueryDslExample extends Base {

    public static void main(String[] args) {
        init();

        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        query(em);
        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void query(EntityManager em) {

        JPAQuery query = new JPAQuery(em);
        List<Member> results = query.from(member)
            .where(member.name.eq("한경만"))
            .orderBy(member.name.desc())
            .list(member);

        System.out.println("----------- result -----------");
        for (Member member: results) {
            System.out.println("name: " + member.getName());
        }
    }

}
