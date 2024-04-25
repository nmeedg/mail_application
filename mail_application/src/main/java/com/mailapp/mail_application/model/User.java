package com.mailapp.mail_application.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(length = 100)
    private String username;

    @Column(length = 100)
    private String password;

    @Column(length = 115,nullable = false,unique = true)
    private String email;

    private int telephone;

    private Boolean isConnected=false;
}



