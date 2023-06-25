package com.test.testSpringboot.models.entities;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class UserEntity {

    public interface UserInfoBasic{}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UserInfoBasic.class})
    private long id;
    private String name;//"name": "Juan Rodriguez",
    @JsonView({UserInfoBasic.class})
    @Column(unique = true)
    private String email;//"email": "juan@rodriguez.org",
    private String password;//"password": "hunter2",

    @OneToMany( mappedBy = "userId")
//    @JoinColumn(name = "user_id")
    private List<PhoneEntity> phones;// "phones": []

    public UserEntity(){}
    public UserEntity(String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void addPhone(PhoneEntity phoneEntity){
        if(this.phones == null) this.phones = new LinkedList<>();
        this.phones.add(phoneEntity);
    }
}
