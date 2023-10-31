package com.openclassrooms.starterjwt.services;

import com.openclassrooms.starterjwt.models.Session;
import com.openclassrooms.starterjwt.models.User;
import com.openclassrooms.starterjwt.repository.SessionRepository;
import com.openclassrooms.starterjwt.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class SessionServiceTest {
    @InjectMocks
    private SessionService sessionService;

    @Mock
    private SessionRepository sessionRepository;

    @Mock
    private UserRepository userRepository;

    private Session session;
    private User user;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @DisplayName("Test de creation de session")
    @Test
    public void testCreate() {
        Session session = new Session();
        when(sessionRepository.save(session)).thenReturn(session);
        sessionService.create(session);
        verify(sessionRepository).save(session);
    }
    @DisplayName("Test de suppression de session")
    @Test
    public void testDelete() {

        Long id = 1L;
        doNothing().when(sessionRepository).deleteById(id);
        sessionService.delete(id);
        verify(sessionRepository).deleteById(id);

    }
    @Test
    public void testFindAll(){
      List<Session> list = new ArrayList<Session>();
//      List<User> listUser = new ArrayList<User>();
//      User user1 = new User("email@email.fr","test","test","test",false);
//      listUser.add(user1);
//        LocalDateTime localDateTime2 =
//                LocalDateTime.of(2019, Month.MARCH, 28, 14, 33, 48, 000000);
////      Session session1 = new Session(1L,"nom session",new Date(),"description a faire",1L,listUser, localDateTime2);
      when(sessionRepository.findAll()).thenReturn(list);
      sessionService.findAll();
      verify(sessionRepository.findAll());

    }
}
