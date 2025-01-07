package com.graphql.service;

import com.graphql.entity.User;
import com.graphql.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    public User createUser(String name, Integer marks) {
        log.info("name {}, marks {}",name,marks);
        User user = new User();

        user.setName(name);
        user.setMarks(marks);
        return userRepository.save(user);
    }

    public User updateUser(Integer id, String name, Integer marks) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            if (name != null) user.setName(name);
            if (marks != null) user.setMarks(marks);
            return userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }

}