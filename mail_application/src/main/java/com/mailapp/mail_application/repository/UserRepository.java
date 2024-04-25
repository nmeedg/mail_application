package com.mailapp.mail_application.repository;
import com.mailapp.mail_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
