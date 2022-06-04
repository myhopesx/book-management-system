package com.example.bookmanagmentsoftware.service;

import com.example.bookmanagmentsoftware.model.User;
import com.example.bookmanagmentsoftware.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
    public void addUser(User User)throws IllegalAccessException{
        userRepository.save(User);
    }
}
