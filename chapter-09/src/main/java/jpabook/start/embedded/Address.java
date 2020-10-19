package jpabook.start.embedded;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String city;

    private String street;

    private String zipCode;
}
