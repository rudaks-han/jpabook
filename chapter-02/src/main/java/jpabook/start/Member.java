package jpabook.start;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {

    @Id
    private String id;

    private String username;

    private Integer age;
}
