package com.github.filipve1994.msmailservice.repositories;

import com.github.filipve1994.msmailservice.models.Mail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends CrudRepository<Mail, Long> {
}
