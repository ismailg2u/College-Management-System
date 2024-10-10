package com.college.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    private int id;
    private String name;
    private String surname;
    private String mail;
    private String address;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    private int situation;
    @ManyToOne
    @JoinColumn(name = "faculty", referencedColumnName = "ID")
    private  Define faculty;
    @ManyToOne
    @JoinColumn(name = "department", referencedColumnName = "ID")
    private  Define department ;

}
