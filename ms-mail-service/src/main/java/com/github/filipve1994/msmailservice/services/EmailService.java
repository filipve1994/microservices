package com.github.filipve1994.msmailservice.services;

import com.github.filipve1994.msmailservice.dto.UserDto;

public interface EmailService {

    void sendSimpleMessage(UserDto input);
}
