package com.decagon.reward_your_teacher.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "school")
public class SchoolEntity extends AbstractEntity{
    private String schoolName;
    private String schoolType;
    private String schoolAddress;
    private String schoolCity;
    private String schoolState;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private TeacherEntity teacher;
}
