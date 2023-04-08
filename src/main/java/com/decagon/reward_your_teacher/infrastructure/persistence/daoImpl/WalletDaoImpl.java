package com.decagon.reward_your_teacher.infrastructure.persistence.daoImpl;

import com.decagon.reward_your_teacher.domain.dao.WalletDao;
import com.decagon.reward_your_teacher.domain.entities.transact.WalletEntity;
import com.decagon.reward_your_teacher.infrastructure.persistence.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletDaoImpl extends CrudDaoImpl<WalletEntity, Long> implements WalletDao {
    private final WalletRepository walletRepository;
    protected WalletDaoImpl(WalletRepository walletRepository) {
        super(walletRepository);
        this.walletRepository = walletRepository;
    }
}
