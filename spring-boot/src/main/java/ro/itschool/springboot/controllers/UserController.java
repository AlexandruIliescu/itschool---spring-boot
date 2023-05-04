package ro.itschool.springboot.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.itschool.springboot.models.dtos.OrderDTO;
import ro.itschool.springboot.models.dtos.UserDTO;
import ro.itschool.springboot.services.UserService;

import java.util.List;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @PutMapping("/api/users/{userId}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUserById(userId, userDTO));
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/api/{userId}/orders")
    public ResponseEntity<OrderDTO> createOrderByUserId(@PathVariable @NotNull Long userId, @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(userService.createOrder(userId, orderDTO));
    }
}