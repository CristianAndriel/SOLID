package S.Service;

import S.Models.User;

public class EmailService {

    public void sendWelcomeEmail(User user) {
        String email = user.getEmail();
        System.out.println("Enviando email de boas-vindas para " + email);
    }
}
