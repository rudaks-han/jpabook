package jpabook.start.onetoonetwoway;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locker2 {
    @Id
    @GeneratedValue
    private String id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member6 member;
}
