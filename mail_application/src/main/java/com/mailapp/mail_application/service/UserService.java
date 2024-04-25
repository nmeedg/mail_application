package com.mailapp.mail_application.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mailapp.mail_application.model.User;
import com.mailapp.mail_application.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository usersRepo;

    public List<User> listAll(){
        return usersRepo.findAll();
    }
    public String test(String mypassword){
        String pythonString="src/main/resources/static/fonctions.py";
        CommandLine command=new CommandLine("python");
        command.addArgument(pythonString);
        String arg1=mypassword;
        command.addArgument(arg1);
        DefaultExecutor executor=new DefaultExecutor();
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        PumpStreamHandler stramHandler=new PumpStreamHandler(outputStream);
        executor.setStreamHandler(stramHandler);
        executor.setExitValue(0);
        String output="";
        try {
            System.out.println("Test");
            int exitValue=executor.execute(command);
            output=outputStream.toString(StandardCharsets.UTF_8);
            System.out.println("Test");
            System.out.println("Fin"+exitValue);
            System.out.println("Termine avec "+output);
            
        } catch(IOException e) {
            e.printStackTrace();
        }
        output=output.strip();
        return output;
        }
       

    public void saveUser(User newUser){
        String hash=test(newUser.getPassword());
        newUser.setPassword(hash);
        System.out.println(hash);
        usersRepo.save(newUser);
    }

    public User getUser(long myId){
        return usersRepo.findById(myId).get();
    }
    public User getUserFromEmail(String email){
        List<User> allusers=listAll();
        for (User user : allusers) {
            if (user.getEmail().toLowerCase().equals(email.toLowerCase())) {
                return user;
            }
        }

        return null;
    }

    public void deleteUser(long myId){
        usersRepo.deleteById(myId);
    }
    public void updateUser(long myId,User newUser){
        User existUser=usersRepo.findById(myId).get();
        existUser = newUser;
        usersRepo.save(existUser);
    }

    public void connectedUser(long userId){
        User existUser=usersRepo.findById(userId).get();
        existUser.setIsConnected(true);
        usersRepo.save(existUser);
    }
    public void disconnectedUser(long userId){
        User existUser=usersRepo.findById(userId).get();
        existUser.setIsConnected(false);
        usersRepo.save(existUser);
    }
} 
