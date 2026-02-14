package S;

import S.Models.User;
import S.Service.EmailService;
import S.Repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        // 1. Criar o usuário
        User user = new User("Cristian Silva", "cristian@email.com");

        // 2. Salvar no banco de dados
        UserRepository repository = new UserRepository();
        repository.save(user);

        // 3. Enviar email de boas-vindas
        EmailService emailService = new EmailService();
        emailService.sendWelcomeEmail(user);
    }
}