package jpabook.start.exception.jpo.member;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Member {

    @Id
    private Long id;

    @Column(length = 10)
    private String name;
}
