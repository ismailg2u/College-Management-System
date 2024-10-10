package com.college.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    private int id;
    private String name;
    private String surname;
    private String mail;
    private String address;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    private int situation;

    @ManyToOne
    @JoinColumn(name = "faculty", referencedColumnName = "ID")
    private Define faculty;

    @ManyToOne
    @JoinColumn(name = "department", referencedColumnName = "ID")
    private Define department;

    @ManyToOne
    @JoinColumn(name = "title", referencedColumnName = "ID")
    private Define title;



}
