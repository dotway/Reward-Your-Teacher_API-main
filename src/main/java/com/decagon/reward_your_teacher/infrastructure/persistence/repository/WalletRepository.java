package com.decagon.reward_your_teacher.infrastructure.persistence.repository;

import com.decagon.reward_your_teacher.domain.entities.transact.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity,Long> {
}
