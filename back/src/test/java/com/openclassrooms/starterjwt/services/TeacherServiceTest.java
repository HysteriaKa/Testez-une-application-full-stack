package com.openclassrooms.starterjwt.services;

import com.openclassrooms.starterjwt.models.Teacher;
import com.openclassrooms.starterjwt.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TeacherServiceTest {
    @InjectMocks
    TeacherService teacherservice;

    @Mock
    TeacherRepository teacherRepository;
    Teacher teacher;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindById(){

   given(teacherRepository.findById(1L)).willReturn(Optional.of(teacher));
  teacherservice.findById(teacher.getId());
   verify(teacherRepository.findById(1L));

    }
}
