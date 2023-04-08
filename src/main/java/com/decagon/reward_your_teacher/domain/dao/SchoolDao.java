package com.decagon.reward_your_teacher.domain.dao;

import com.decagon.reward_your_teacher.domain.entities.SchoolEntity;

import java.util.Optional;


public interface SchoolDao extends CrudDao<SchoolEntity, Long>{
    Optional<SchoolEntity> findSchool(String schoolName);
}
