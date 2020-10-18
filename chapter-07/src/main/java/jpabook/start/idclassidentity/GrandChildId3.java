package jpabook.start.idclassidentity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class GrandChildId3 implements Serializable {

    private ChildId3 childId;

    private String id;
}
