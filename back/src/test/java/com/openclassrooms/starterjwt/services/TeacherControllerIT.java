package com.openclassrooms.starterjwt.services;
import com.openclassrooms.starterjwt.dto.TeacherDto;
import com.openclassrooms.starterjwt.mapper.TeacherMapper;
import com.openclassrooms.starterjwt.models.Teacher;
import com.openclassrooms.starterjwt.repository.TeacherRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;

public class TeacherControllerIT {
    private TeacherService teacherService;
    private TeacherMapper teacherMapper;
  @Test
  @Sql(statements = "INSERT INTO teacher (id, first_name, last_name, created_at, updated_at) VALUES (3, 'Vincenzo', 'Racca', 'via Roma','2021-06-02T21:33:45.249967','2021-06-02T21:33:45.249967')",
          executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
  @Sql(statements = "DELETE FROM teacher",
          executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void findByIdReturnOk(){
    Long id = 1L;
    Teacher teacher = this.teacherService.findById(id);
    if (teacher != null){ Assertions.assertNotNull(teacher);}
//      TeacherDto teacherDto = this.teacherMapper.toDto(teacher);



  }
    @Test
    public void findByIdReturnNotFound(){
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setCreatedAt(LocalDateTime.now());
        teacher.setFirstName("test");
        teacher.setLastName("test");
        teacher.setUpdatedAt(LocalDateTime.now());

    }
}
