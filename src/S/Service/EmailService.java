package S.Service;

import S.User;

public class EmailService {

    public void sendWelcomeEmail(User user) {
        String email = user.getEmail();
        System.out.println("Enviando email de boas-vindas para " + email);
    }
}
