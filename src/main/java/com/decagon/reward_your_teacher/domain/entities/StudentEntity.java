package com.decagon.reward_your_teacher.domain.entities;

import com.decagon.reward_your_teacher.domain.entities.message.NotificationEntity;
import com.decagon.reward_your_teacher.domain.entities.transact.TransactionEntity;
import com.decagon.reward_your_teacher.domain.entities.transact.WalletEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "students")
public class StudentEntity extends AbstractEntity {
    private String name;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;
    private String phoneNumber;
    private String title;

    @JsonManagedReference
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private WalletEntity wallet;

    @JsonManagedReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionEntity> transactionList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NotificationEntity> notificationList = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    private TeacherEntity teacher;

}
