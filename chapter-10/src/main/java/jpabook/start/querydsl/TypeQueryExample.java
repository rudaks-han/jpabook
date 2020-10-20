package jpabook.start.querydsl;

import javax.persistence.EntityManager;

import com.mysema.query.jpa.impl.JPAQuery;
import jpabook.start.Base;
import jpabook.start.Member;

public class TypeQueryExample extends Base {

    public static void main(String[] args) {
        init();

        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        query(em);
        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void query(EntityManager em) {

        JPAQuery query = new JPAQuery(em);
        //QMember qMember


        /*System.out.println("----------- result -----------");
        for (Member member: results) {
            System.out.println("name: " + member.getName());
        }*/
    }

}