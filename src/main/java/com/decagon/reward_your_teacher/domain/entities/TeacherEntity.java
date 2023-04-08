 package com.decagon.reward_your_teacher.domain.entities;
import com.decagon.reward_your_teacher.domain.entities.enums.Status;
import com.decagon.reward_your_teacher.domain.entities.message.NotificationEntity;
import com.decagon.reward_your_teacher.domain.entities.transact.TransactionEntity;
import com.decagon.reward_your_teacher.domain.entities.transact.WalletEntity;
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
@Table(name = "teachers")
public class TeacherEntity extends AbstractEntity {
    private String name;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;
    private String phoneNumber;
    private String yearsOfTeaching;
    private String subjectsTaught;
    private Status status;
    private String nin;

    @JsonManagedReference
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<SchoolEntity> schoolList = new ArrayList<>();
    @JsonManagedReference
    @OneToOne(mappedBy = "teacher", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private WalletEntity wallet;

    @JsonManagedReference
    @OneToMany(mappedBy = "teacher", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<TransactionEntity> transactionList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "teacher", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<NotificationEntity> notificationList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<StudentEntity> studentList = new ArrayList<>();

}
