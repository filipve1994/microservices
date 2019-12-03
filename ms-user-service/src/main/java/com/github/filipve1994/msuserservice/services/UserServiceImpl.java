package com.github.filipve1994.msuserservice.services;

import com.github.filipve1994.msuserservice.kafka.producer.Sender;
import com.github.filipve1994.msuserservice.models.User;
import com.github.filipve1994.msuserservice.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Sender sender;

    @Value("${spring.kafka.topic.userCreated}")
    private String USER_CREATED_TOPIC;

    @Override
    public User registerUser(User input) {

        User createdUser = userRepository.save(input);
        sender.send(USER_CREATED_TOPIC, createdUser);
        return createdUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
