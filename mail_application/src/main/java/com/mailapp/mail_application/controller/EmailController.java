/*package com.mailapp.mail_application.controller;

import com.mailapp.mail_application.model.Email;
import com.mailapp.mail_application.model.User;
import com.mailapp.mail_application.repository.MessageRepository;
import com.mailapp.mail_application.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Email")
@CrossOrigin
@AllArgsConstructor
public class EmailController {
    //private final EmailService emailService;
    private final MessageRepository emailRepository;
    private final UserRepository userRepository;

    @PostMapping("/Connexion/{id}/{password}")
    public ResponseEntity<String> Connexion(@PathVariable Long id){
        Optional<User> NewUser = userRepository.findById(id);
        if (NewUser != null){ // && NewUser.getPassword().equals(password)){
            return new ResponseEntity<>("Bienvenue dans notre application", HttpStatus.OK);
        }
        return new ResponseEntity<>("Vous n'avez pas de compte! Enregistrez-vous!", HttpStatus.OK);
    }

    @PostMapping("/S'enregistrer")
    public ResponseEntity<String> Enregistrer(@RequestBody User user){

        userRepository.save(user);
        return new ResponseEntity<>("Enregistrement terminé", HttpStatus.OK);
    }

    @PostMapping("/Recieve")
    public ResponseEntity<String> Recieve(@RequestBody Email email){

       // return emailService.RecevoirMail(email);
        emailRepository.save(email);
        return new ResponseEntity<>("Nouveau message", HttpStatus.OK);
    }

    @PostMapping("/send")
    public ResponseEntity<String> Send(@RequestBody Email email){

        //return emailService.EnvoyerMail(email);
        emailRepository.save(email);
        return new ResponseEntity<>("Message envoyé", HttpStatus.OK);
    }

    @GetMapping("/readall")
    public ResponseEntity<List<Email>> Readall(){

        //return emailService.AfficheAll();
        return new ResponseEntity<>(emailRepository.findAll(), HttpStatus.OK);

    }
    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<Email>> Read(@PathVariable Long id){

       // return emailService.AfficherMail(id);
        return new ResponseEntity<>(emailRepository.findById(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> Delete(@PathVariable Long id){

       // return emailService.Supprimer(id);
        emailRepository.deleteById(id);
        return new ResponseEntity<>("Message supprimé", HttpStatus.OK);
    }

}*/
