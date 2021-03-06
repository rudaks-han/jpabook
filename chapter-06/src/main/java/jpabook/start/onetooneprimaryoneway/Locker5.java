package jpabook.start.onetooneprimaryoneway;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locker5 {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Locker5(String name) {
        this.name = name;
    }
}
