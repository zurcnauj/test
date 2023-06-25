package com.test.testSpringboot.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "phones")
@IdClass(PhoneEntity.class)
public class PhoneEntity implements Serializable {

    @Id
    private String number;//"number": "1234567",
    @Id
    private String citycode;//"citycode": "1",
    @Id
    private String contrycode;//"contrycode": "57"

    @Id
    @Column(name = "user_id")
    private Long userId;

    public PhoneEntity(){}

    public PhoneEntity( String contrycode,String citycode, String number) {
        this.number = number;
        this.citycode = citycode;
        this.contrycode = contrycode;
    }
}
