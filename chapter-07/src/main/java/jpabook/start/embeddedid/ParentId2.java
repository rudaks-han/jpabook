package jpabook.start.embeddedid;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ParentId2 implements Serializable {

    private String id1;

    private String id2;
}
