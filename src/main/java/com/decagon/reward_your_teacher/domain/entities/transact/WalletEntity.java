package com.decagon.reward_your_teacher.domain.entities.transact;

import com.decagon.reward_your_teacher.domain.entities.AbstractEntity;
import com.decagon.reward_your_teacher.domain.entities.StudentEntity;
import com.decagon.reward_your_teacher.domain.entities.TeacherEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "wallet")
public class WalletEntity extends AbstractEntity {

    private BigDecimal balance;
    private BigDecimal totalMoneySent;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private StudentEntity student;
    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private TeacherEntity teacher;

}
