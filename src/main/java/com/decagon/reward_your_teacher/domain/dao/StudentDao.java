package com.decagon.reward_your_teacher.domain.dao;


import com.decagon.reward_your_teacher.domain.entities.StudentEntity;

import java.util.Optional;

public interface StudentDao extends CrudDao<StudentEntity, Long>{
    public Optional<StudentEntity> findStudent(String email);
}
