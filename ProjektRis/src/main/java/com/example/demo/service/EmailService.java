package com.example.demo.service;


import com.example.demo.model.EmailDetails;

public interface EmailService {


    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);
}