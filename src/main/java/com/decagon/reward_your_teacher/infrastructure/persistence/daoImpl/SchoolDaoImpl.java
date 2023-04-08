package com.decagon.reward_your_teacher.infrastructure.persistence.daoImpl;

import com.decagon.reward_your_teacher.domain.dao.SchoolDao;
import com.decagon.reward_your_teacher.domain.entities.SchoolEntity;
import com.decagon.reward_your_teacher.infrastructure.persistence.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolDaoImpl extends CrudDaoImpl<SchoolEntity, Long> implements SchoolDao {
    private final SchoolRepository schoolRepository;

    public SchoolDaoImpl(SchoolRepository schoolRepository) {
        super(schoolRepository);
        this.schoolRepository = schoolRepository;
    }
    @Override
    public Optional<SchoolEntity> findSchool(String schoolName) {
        return schoolRepository.findSchoolEntityBySchoolName(schoolName);
    }

}
