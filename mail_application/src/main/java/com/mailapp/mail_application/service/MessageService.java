package com.mailapp.mail_application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mailapp.mail_application.model.Message;
import com.mailapp.mail_application.repository.MessageRepository;

@Service
@Transactional
public class MessageService {
    @Autowired
    private MessageRepository messagesRepo;

    public List<Message> getAllMessages(){
        return messagesRepo.findAll();
    }

    public long saveMessage(Message myMessage){
        Message temp = messagesRepo.save(myMessage);
        return temp.getMessageId();
    }

    public List<Message> getUserMessages(long userId){
        List<Message> allMessages=getAllMessages();
        List<Message> myArray=new ArrayList<Message>();
        for (Message message : allMessages) {
            if (message.getExpediteurId() == userId) {
                myArray.add(message);
            }
            
        }
        return myArray;
    }
    public List<Message> getReceiveUserMessages(long userId){
        List<Message> allMessages=getAllMessages();
        List<Message> myArray=new ArrayList<Message>();
        for (Message message : allMessages) {
            if (message.getRecepteurId() == userId) {
                myArray.add(message);
            }
        }
        return myArray;
    }

}
