package com.example.AuthendicationFlow.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@Data
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String emailId;
    private String location;
    private int age;
    private boolean isActive=true;
    private Date createDate;
    private Date lastUpdate;
    private String password;



    public Register(long id, String name, String emailId, String location, int age, boolean isActive, Date createDate, Date lastUpdate,String password) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.location = location;
        this.age = age;
        this.isActive = isActive;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.password=password;
    }



    @PrePersist
    public void createDate(){
        Date date=new Date();
        createDate=date;
        lastUpdate=date;
    }

    @PreUpdate
    public void lastUpdate(){
        Date Date=new Date();
        lastUpdate=Date;
    }
}
