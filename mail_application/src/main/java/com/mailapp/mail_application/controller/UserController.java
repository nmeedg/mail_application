package com.mailapp.mail_application.controller;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mailapp.mail_application.model.User;
import com.mailapp.mail_application.service.UserService;

import lombok.AllArgsConstructor;
@Controller
@RequestMapping("/users")
@CrossOrigin
@AllArgsConstructor
public class UserController {
    private UserService usersServices;

    @GetMapping("/all")
    public ResponseEntity<List<User>> readAll(){

        return new ResponseEntity<>(usersServices.listAll(), HttpStatus.OK);

    }
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user){
        usersServices.saveUser(user);
        return new ResponseEntity<>("Nouveau utilisateur enregistré avec sucess :", HttpStatus.OK);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<User> getOne(@PathVariable Long id){
        User newUser=usersServices.getUser(id);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    @GetMapping("/oneEmail/{email}")
    public ResponseEntity<User> getOneEmail(@PathVariable String email){
        User newUser=usersServices.getUserFromEmail(email);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        usersServices.deleteUser(id);
        return new ResponseEntity<>("Utilisteur supprimé", HttpStatus.OK);
    }
    @GetMapping("/test")
    public ResponseEntity<String> testPython(){
        usersServices.test("nme");
        return new ResponseEntity<>("Test du code python", HttpStatus.OK);
    }



    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String,String> userInfo){
       String hash=usersServices.test(userInfo.get("password"));
       // String hash=userInfo.get("password");
        List<User> allUsers=usersServices.listAll();
        long id=0;
        for (User user : allUsers) {
            if ((user.getEmail().equalsIgnoreCase(userInfo.get("email").toString())) && (user.getPassword().equals(hash))) {
               id=user.getUserId(); 
            }
        }
        if (id == 0) {
            return new ResponseEntity<>("Mot de passe ou adresse email incorrect", HttpStatus.NOT_FOUND);
        } else {
            usersServices.connectedUser(id);
            return new ResponseEntity<>(""+id, HttpStatus.OK);
        }
       
    }
    @PostMapping("/logout/{id}")
    public ResponseEntity<String> logout(@PathVariable Long id){

        usersServices.disconnectedUser(id);
        return new ResponseEntity<>("Vous etes déconnecté", HttpStatus.OK);

    }
}
