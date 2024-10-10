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
@Table(name = "courseselection")
public class CourseSelection {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "StudentID",referencedColumnName = "ID")
    private Student studentID;

    @ManyToOne
    @JoinColumn(name = "CourseID",referencedColumnName = "ID")
    private Course courseID;

    private int situation;

}
