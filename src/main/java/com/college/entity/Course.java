package com.college.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private int id;
    private String name;
    private String description;
    private String quota;
    private int situation;
    @ManyToOne
    @JoinColumn(name ="teacher", referencedColumnName = "ID")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "faculty",referencedColumnName = "ID")
    private  Define faculty;

    @ManyToOne
    @JoinColumn(name = "department", referencedColumnName = "ID")
    private  Define department ;

    @ManyToOne
    @JoinColumn(name = "term", referencedColumnName = "ID")
    private Define term;

    @ManyToOne
    @JoinColumn(name = "credit", referencedColumnName = "ID")
    private  Define credit;

    @ManyToOne
    @JoinColumn(name = "Coursestatus", referencedColumnName = "ID")
    private Define courseStatus;

}
