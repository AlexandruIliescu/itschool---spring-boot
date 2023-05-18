package ro.itschool.springboot.cleanCode;

public class SingleResponsabilityPrinciple {

    private UserAuthenticationService authenticationService;
    private EmailService emailService;

    public SingleResponsabilityPrinciple(UserAuthenticationService authenticationService, EmailService emailService) {
        this.authenticationService = authenticationService;
        this.emailService = emailService;
    }
    void processLogin(String username, String password) {
        if(authenticationService.authenticateUser(username, password)){
            String message = "User authenticated!";
            emailService.sendNotificationEmail(username, message);
        } else {
            String message = "Authentication failed!";
            emailService.sendNotificationEmail(username, message);
        }
    }
}

class UserAuthenticationService {

    boolean authenticateUser(String username, String password) {
        //logic goes here
        return false;
    }
}

class EmailService {

    void sendNotificationEmail(String recipient, String message) {
        //logic goes here
    }
}