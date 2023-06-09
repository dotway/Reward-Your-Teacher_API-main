package com.decagon.reward_your_teacher.infrastructure.persistence.daoImpl;
import com.decagon.reward_your_teacher.domain.dao.StudentDao;
import com.decagon.reward_your_teacher.domain.entities.StudentEntity;
import com.decagon.reward_your_teacher.infrastructure.persistence.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentDaoImpl extends CrudDaoImpl<StudentEntity, Long> implements StudentDao {
    private final StudentRepository studentRepository;
    protected StudentDaoImpl(StudentRepository studentRepository) {
        super(studentRepository);
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<StudentEntity> findStudent(String email) {
        return studentRepository.findStudentEntityByEmail(email);
    }
}
