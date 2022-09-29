package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private Long id;
    private String name;
    private char gender;
    private String phone;
    private Date birth;
    private int population;
    private float income;
    private String address;
    private Date createTime;
}
