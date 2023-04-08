package com.decagon.reward_your_teacher.domain.entities.message;

import com.decagon.reward_your_teacher.domain.entities.AbstractEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat")
public class ChatEntity extends AbstractEntity {

    private String message;
    private Long teacher_id;
    private Long student_id;

    @CreationTimestamp
    private LocalDateTime sendDate;

    @CreationTimestamp
    private LocalDateTime receivedDate;

}
