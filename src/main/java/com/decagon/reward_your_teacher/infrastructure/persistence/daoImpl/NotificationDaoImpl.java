package com.decagon.reward_your_teacher.infrastructure.persistence.daoImpl;

import com.decagon.reward_your_teacher.domain.dao.NotificationDao;
import com.decagon.reward_your_teacher.domain.entities.message.NotificationEntity;
import com.decagon.reward_your_teacher.infrastructure.persistence.repository.NotificationRepository;
import org.springframework.stereotype.Service;


@Service
public class NotificationDaoImpl extends CrudDaoImpl<NotificationEntity, Long> implements NotificationDao {
    private final NotificationRepository notificationRepository;
    protected NotificationDaoImpl( NotificationRepository notificationRepository) {
        super(notificationRepository);
        this.notificationRepository = notificationRepository;
    }
}
