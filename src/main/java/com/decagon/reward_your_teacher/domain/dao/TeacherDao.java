package com.decagon.reward_your_teacher.domain.dao;

import com.decagon.reward_your_teacher.domain.entities.TeacherEntity;

import java.util.Optional;


public interface TeacherDao extends CrudDao<TeacherEntity, Long>{
    Optional<TeacherEntity> findTeacherByEmail(String email);
}
