package jpabook.start.onetoonetwoway;

import jpabook.start.onetooneoneway.Locker1;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member6 {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker1 locker;

    public Member6(String username) {
        this.username = username;
    }
}
