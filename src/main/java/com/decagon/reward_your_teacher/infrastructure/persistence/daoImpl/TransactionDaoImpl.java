package com.decagon.reward_your_teacher.infrastructure.persistence.daoImpl;

import com.decagon.reward_your_teacher.domain.dao.TransactionDao;
import com.decagon.reward_your_teacher.domain.entities.transact.TransactionEntity;
import com.decagon.reward_your_teacher.infrastructure.persistence.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionDaoImpl  extends CrudDaoImpl<TransactionEntity, Long> implements TransactionDao {
    private final TransactionRepository transactionRepository;
    protected TransactionDaoImpl(TransactionRepository transactionRepository) {
        super(transactionRepository);
        this.transactionRepository = transactionRepository;
    }
}
