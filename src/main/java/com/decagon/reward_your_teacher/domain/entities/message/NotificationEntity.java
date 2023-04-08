package com.decagon.reward_your_teacher.domain.entities.message;

import com.decagon.reward_your_teacher.domain.entities.AbstractEntity;
import com.decagon.reward_your_teacher.domain.entities.StudentEntity;
import com.decagon.reward_your_teacher.domain.entities.TeacherEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "notification")

public class NotificationEntity extends AbstractEntity {
    private String message;

    @JsonBackReference
    @ManyToOne
    private StudentEntity student;

    @JsonBackReference
    @ManyToOne
    private TeacherEntity teacher;
}
