package jpabook.start.embeddedididentity;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GrandChildId4 implements Serializable {

    private ChildId4 childId;

    @Column(name = "grandchild_id")
    private String id;
}
