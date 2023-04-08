package com.decagon.reward_your_teacher.usecase.services.impl;

import com.decagon.reward_your_teacher.domain.dao.SchoolDao;
import com.decagon.reward_your_teacher.domain.dao.TeacherDao;
import com.decagon.reward_your_teacher.domain.entities.SchoolEntity;
import com.decagon.reward_your_teacher.domain.entities.TeacherEntity;
import com.decagon.reward_your_teacher.infrastructure.error_handler.CustomNotFoundException;
import com.decagon.reward_your_teacher.infrastructure.error_handler.EntityAlreadyExistException;
import com.decagon.reward_your_teacher.usecase.payload.request.TeacherRegistrationRequest;
import com.decagon.reward_your_teacher.usecase.payload.response.ApiResponse;
import com.decagon.reward_your_teacher.usecase.payload.response.RegistrationResponse;
import com.decagon.reward_your_teacher.usecase.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherDao;
    private final SchoolDao schoolDao;
private final ApiResponse registrationResponse;

    @Override
    public RegistrationResponse registerTeacher(TeacherRegistrationRequest teacherRegistrationRequest, MultipartFile file) {
        Optional<TeacherEntity> teacher = teacherDao.findTeacherByEmail(teacherRegistrationRequest.getEmail());
        if (teacher.isPresent()) {
            throw new EntityAlreadyExistException("Email taken");
        }
        SchoolEntity school = schoolDao.findSchool(teacherRegistrationRequest.getSchool())
                .orElseThrow(() -> new CustomNotFoundException("School name not found"));
        TeacherEntity teacher1 = TeacherEntity.builder()
                .name(teacherRegistrationRequest.getName())
                .email(teacherRegistrationRequest.getEmail())
                .password(teacherRegistrationRequest.getPassword())
                .school(school)
                .yearsOfTeaching(teacherRegistrationRequest.getYearsOfTeaching())
                .subjectsTaught(teacherRegistrationRequest.getSubjectTaught()).build();

        return registrationResponse.created("success", LocalDateTime.now(), teacherDao.saveRecord(teacher1));
    }
}