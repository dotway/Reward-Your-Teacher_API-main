package com.decagon.reward_your_teacher.infrastructure.persistence.daoImpl;

import com.decagon.reward_your_teacher.domain.dao.TeacherDao;
import com.decagon.reward_your_teacher.domain.entities.TeacherEntity;
import com.decagon.reward_your_teacher.infrastructure.persistence.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherDaoImpl extends CrudDaoImpl<TeacherEntity, Long> implements TeacherDao {
    private final TeacherRepository teacherRepository;
    protected TeacherDaoImpl(TeacherRepository teacherRepository) {
        super(teacherRepository);
        this.teacherRepository = teacherRepository;
    }
    @Override
    public Optional<TeacherEntity> findTeacherByEmail(String email) {
        return teacherRepository.findTeacherEntityByEmail(email);
    }
}
