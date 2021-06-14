package com.techmania.springbootamigoscode.course;

import com.techmania.springbootamigoscode.intructor.Instructor;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Course {

    @Id
    private Long id;
    private String name;
    private Integer duration;
    @ManyToOne
    @JoinColumn(
            name = "inst_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private Instructor instructor;
}
