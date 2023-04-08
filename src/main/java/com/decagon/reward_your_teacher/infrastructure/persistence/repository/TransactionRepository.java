package com.decagon.reward_your_teacher.infrastructure.persistence.repository;

import com.decagon.reward_your_teacher.domain.entities.transact.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {
}
