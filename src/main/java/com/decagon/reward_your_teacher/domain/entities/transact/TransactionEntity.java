package com.decagon.reward_your_teacher.domain.entities.transact;

import com.decagon.reward_your_teacher.domain.entities.AbstractEntity;
import com.decagon.reward_your_teacher.domain.entities.StudentEntity;
import com.decagon.reward_your_teacher.domain.entities.TeacherEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "transaction")
public class TransactionEntity extends AbstractEntity {

    private String transactionType;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    private StudentEntity student;

    @ManyToOne
    private TeacherEntity teacher;

}
