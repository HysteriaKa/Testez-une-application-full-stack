package com.openclassrooms.starterjwt.services;

import com.openclassrooms.starterjwt.models.Teacher;
import com.openclassrooms.starterjwt.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
        teacher = Teacher.builder()
                .id(1L)
                .firstName("test")
                .lastName("test")
                .createdAt(LocalDateTime.now())
                .build();
    }

    @Test
    public void testFindById(){
    Long id = 1L;
   when(teacherRepository.findById(id)).thenReturn(Optional.of(teacher));
   teacherservice.findById(id);
   verify(teacherRepository).findById(id);

    }
    @Test
    public void testFindAll(){
    Teacher teacher =new Teacher();
    teacher.setId(1L);
    teacher.setCreatedAt(LocalDateTime.now());
    teacher.setFirstName("test");
    teacher.setLastName("test");
    teacher.setUpdatedAt(LocalDateTime.now());
    when(teacherRepository.findAll()).thenReturn(Arrays.asList(teacher));
    teacherservice.findAll();
    verify(teacherRepository).findAll();
    }
}
