//package com.mailapp.mail_application.service;
//
//import com.mailapp.mail_application.model.Email;
//import com.mailapp.mail_application.repository.EmailRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class EmailServiceImplement implements EmailService{
//
//    private  final EmailRepository emailRepository;
//    @Override
//    public Optional<Email> AfficherMail(Long id) {
//        return emailRepository.findById(id);
//    }
//
//    @Override
//    public List<Email> AfficheAll() {
//        return emailRepository.findAll();
//    }
//
//    @Override
//    public String EnvoyerMail(Email email) {
//
//         emailRepository.save(email);
//        return "Message envoyé";
//    }
//
//    @Override
//    public String RecevoirMail(Email email) {
//
//         emailRepository.save(email);
//        return "Nouveau message";
//    }
//
//    @Override
//    public String Supprimer(Long id) {
//        emailRepository.deleteById(id);
//        return "Message supprimé";
//    }
//}
