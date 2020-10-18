package jpabook.start.mappedsuperclass;

import javax.persistence.Entity;

@Entity
public class Member extends BaseEntity {

    private String email;
}
