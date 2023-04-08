package com.decagon.reward_your_teacher.infrastructure.persistence.repository;

import com.decagon.reward_your_teacher.domain.entities.message.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<NotificationEntity,Long> {
    Optional<NotificationEntity> findNotificationEntitiesByCreatedAt(LocalDateTime localDateTime);
}
