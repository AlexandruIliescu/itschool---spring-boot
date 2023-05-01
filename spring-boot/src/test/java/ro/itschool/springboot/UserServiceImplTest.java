package ro.itschool.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ro.itschool.springboot.models.dtos.UserDTO;
import ro.itschool.springboot.models.entities.User;
import ro.itschool.springboot.repositories.OrderRepository;
import ro.itschool.springboot.repositories.UserRepository;
import ro.itschool.springboot.services.UserServiceImpl;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

//    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
//    private final OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
//    private final ObjectMapper objectMapper = Mockito.mock(ObjectMapper.class);

//    can be used @InjectMocks instead
//    private final UserServiceImpl userService = new UserServiceImpl(userRepository, orderRepository, objectMapper);

    @Test
    public void testCreateUser() {
        //given
        UserDTO userDTO = new UserDTO( "John", "johndoe@gmail.com", 27);
        User user = new User(1L, "John", "johndoe@gmail.com", 27, new ArrayList<>());
        User userSaved = new User(1L, "John", "johndoe@gmail.com", 27, new ArrayList<>());

        when(objectMapper.convertValue(userDTO, User.class)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(userSaved);
        //when
        userService.createUser(userDTO);
        //then
        verify(userRepository, times(1)).save(user);
        verify(objectMapper, times(1)).convertValue(userSaved, UserDTO.class);
    }
}