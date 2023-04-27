package com.example.CarRental.EmailService;

public class EmailSender implements IEmailSender{
    @Override
    public void sendEmail() {
        System.out.println("Sending email to fleet manager");
    }
}
