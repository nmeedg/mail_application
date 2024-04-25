package com.mailapp.mail_application.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mailapp.mail_application.model.Message;
import com.mailapp.mail_application.service.MessageService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/messages")
@CrossOrigin
@AllArgsConstructor
public class MessageController {
    private MessageService messageServices;

    @GetMapping("/all")
    public ResponseEntity<List<Message>> readAll(){
        return new ResponseEntity<>(messageServices.getAllMessages(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> sendMessage(@RequestBody Message message){
        long newId=messageServices.saveMessage(message);;
        return new ResponseEntity<>("Nouveau message enregistré"+newId, HttpStatus.OK);
    }

    @GetMapping("/send/{messageID}")
    public ResponseEntity<List<Message>> getMessageID(@PathVariable long messageID){

        List<Message> temp=messageServices.getUserMessages(messageID);
        System.out.println(temp);

        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    @GetMapping("/receive/{messageID}")
    public ResponseEntity<List<Message>> getReceiveMessageID(@PathVariable long messageID){

        List<Message> temp=messageServices.getReceiveUserMessages(messageID);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    
}
