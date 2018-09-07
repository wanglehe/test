package com.army.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Organization {
    @Id
    @GeneratedValue
    private  long id;

    private String organizationName;

}
