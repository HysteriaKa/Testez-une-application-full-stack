package com.openclassrooms.starterjwt.services;

import com.openclassrooms.starterjwt.models.Session;
import com.openclassrooms.starterjwt.models.Teacher;
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
import java.util.*;

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
        session = Session.builder()
                .id(1L)
                .name("session")
                .teacher(new Teacher())
                .date(new Date())
                .users(new ArrayList<>())
                .description("description")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        user = User.builder()
                .id(1L)
                .admin(false)
                .email("test@email.fr")
                .firstName("test")
                .lastName("test")
                .password("test1234")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
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
    @DisplayName("Test de récupération de toutes les sessions")
    @Test
    public void testFindAll() {
        Session session = new Session();
        session.setId(1L);
        session.setUsers(new ArrayList<>());
        session.setName("session");
        session.setDate(new Date());
        session.setTeacher(new Teacher());
        session.setCreatedAt(LocalDateTime.now());
        session.setDescription("description");
        session.setUpdatedAt(LocalDateTime.now());

        when(sessionRepository.findAll()).thenReturn(Arrays.asList(session));
        sessionService.findAll();
        verify(sessionRepository).findAll();

    }

    @DisplayName("Test de get une session by id")
    @Test
    public void testGetById() {
        Long id = 1L;
        when(sessionRepository.findById(id)).thenReturn(Optional.of(session));
        sessionService.getById(id);
        verify(sessionRepository).findById(id);

    }

    @DisplayName("Test d'édition d'une session")
    @Test
    public void update() {
        Long id = 1L;
        session = new Session();
        session.setId(id);
        when(sessionRepository.save(session)).thenReturn(session);
        sessionService.update(id,session);
        verify(sessionRepository).save(session);

    }
    //participate
//    @Test
//    public void participate(){
//        Long id = 1L;
//        Long userId = 1L;
//        session = new Session();
//        session.setId(id);
//        user =new User();
//        user.setId(userId);
////        Session session = this.sessionRepository.findById(id).orElse(null);
////        User user = this.userRepository.findById(userId).orElse(null);
//        when(sessionRepository.findById(id)).thenReturn(Optional.of(session));
//        when(userRepository.findById(userId)).thenReturn(Optional.empty());
//        sessionService.participate(id,userId);
//        verify(sessionRepository.save(session));
//    }
    //noLongerParticipate
}
