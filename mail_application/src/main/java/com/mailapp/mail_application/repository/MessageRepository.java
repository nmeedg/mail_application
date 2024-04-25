package com.mailapp.mail_application.repository;

import com.mailapp.mail_application.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
