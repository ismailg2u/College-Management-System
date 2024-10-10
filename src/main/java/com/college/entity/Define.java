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
@Table(name = "define")
public class Define {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "definetypeID", referencedColumnName = "ID")
    private DefineType defineType;

    private String name;
    private int situation;
}
