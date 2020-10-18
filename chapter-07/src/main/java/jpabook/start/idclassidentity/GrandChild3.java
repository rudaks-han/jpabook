package jpabook.start.idclassidentity;

import javax.persistence.*;

@Entity
@IdClass(GrandChildId3.class)
public class GrandChild3 {
    @Id
    @ManyToOne
    @JoinColumn
    private Child3 child;

    @Id
    @Column(name = "grandchild_id")
    private String id;

    private String name;
}
