package jpabook.start.embeddedididentity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class GrandChild {

    @EmbeddedId
    private GrandChildId4 id;

    @MapsId
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "parent_id"),
        @JoinColumn(name = "child_id")
    })
    private Child4 child;

    private String name;

}
